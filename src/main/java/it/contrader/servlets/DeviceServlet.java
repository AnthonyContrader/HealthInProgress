package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.DeviceDTO;
import it.contrader.service.DeviceService;

public class DeviceServlet extends HttpServlet {

	private final DeviceService deviceServiceDTO = new DeviceService();
	private List<DeviceDTO> allDevices = new ArrayList<>();

    @Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "DeviceManager":
			allDevices = this.deviceServiceDTO.getAllDevices();
			request.setAttribute("allDevice", allDevices);
			getServletContext().getRequestDispatcher("/device/manageDevice.jsp").forward(request, response);
			break;
			
		case "DeviceManagerD":
			allDevices = this.deviceServiceDTO.getAllDevices();
			request.setAttribute("allDevice", allDevices);
			getServletContext().getRequestDispatcher("/device/manageDeviceD.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/device/insertDevice.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("device_id"));
			final String nome = request.getParameter("nome");
			
			final DeviceDTO devices = new DeviceDTO(nome);
			deviceServiceDTO.insertDevices(devices);
			showAllDevices(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			DeviceDTO deviceUpdate = new DeviceDTO("");
			deviceUpdate.setIddevice(id);

			deviceUpdate = this.deviceServiceDTO.readDevice(deviceUpdate);
			request.setAttribute("deviceUpdate", deviceUpdate);
			getServletContext().getRequestDispatcher("/device/updateDevice.jsp").forward(request, response);

			break;

		case "update":
			
			final int idUpdate = Integer.parseInt(request.getParameter("id_device"));
			final String nomeUpdate = request.getParameter("nome");
			
			final DeviceDTO device = new DeviceDTO(nomeUpdate);
			device.setIddevice(idUpdate);

			deviceServiceDTO.updateDevice(device);
			showAllDevices(request, response);
			break;

		

		case "delete":
			final int deleteId = Integer.parseInt(request.getParameter("id"));

			final DeviceDTO devicedelete =  new DeviceDTO("");
			devicedelete.setIddevice(deleteId);
			deviceServiceDTO.deleteDevices(devicedelete);
			showAllDevices(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;


		}

	}

	private void showAllDevices(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allDevices = this.deviceServiceDTO.getAllDevices();
		request.setAttribute("allDevice", allDevices);
		getServletContext().getRequestDispatcher("/device/manageDevice.jsp").forward(request, response);
	}
}