package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.dto.DeviceDTO;
import it.contrader.services.DeviceService;
import it.contrader.services.*;

import java.util.List;

@Controller
@RequestMapping("/Device")
public class DeviceController {

	private final DeviceService deviceService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public DeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	private void visualDevice(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) this.session.getAttribute("utente");

		List<DeviceDTO> allDevice = this.deviceService.findDeviceDTOByUser(userDTO);
		request.setAttribute("allDeviceDTO", allDevice);
	}

	@RequestMapping(value = "/deviceManagement", method = RequestMethod.GET)
	public String deviceManagement(HttpServletRequest request) {
		visualDevice(request);
		return "device/manageDevice";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.deviceService.getDeviceDTOById(id);
		visualDevice(request);
		return "device/manageDevice";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "device/insertDevice";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String deviceName = request.getParameter("device_name").toString();
		

		DeviceDTO deviceObj = new DeviceDTO();
		deviceObj.setNome(deviceName);
		deviceObj.setUserDTO(userLogged);
		deviceService.insertDevice(deviceObj);
		visualDevice(request);
		 

		return "device/manageDevice";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		DeviceDTO deviceUpdate = new DeviceDTO();

		deviceUpdate = this.deviceService.getDeviceDTOById(id);
		request.setAttribute("deviceUpdate", deviceUpdate);
		return "device/update";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("idDevice"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String deviceName = request.getParameter("nome");
		
		DeviceDTO deviceUpdateDTO = new DeviceDTO();
		deviceUpdateDTO.setNome(deviceName);

		
		deviceService.updateDevice(deviceUpdateDTO);
		visualDevice(request);
		
		return "device/manageDevice";
	}
	
}