package it.contrader.servlets;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import it.contrader.dto.ParametersDTO;

import it.contrader.service.ParametersService;



@SuppressWarnings("serial")

public class ParametersServlet extends HttpServlet {



	private final ParametersService parametersService = new ParametersService();

	private List<ParametersDTO> allParameters = new ArrayList<>();





	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {



		final String scelta = request.getParameter("richiesta");

		final HttpSession session = request.getSession(true);



		switch (scelta) {

		

		case "ParametersManager":
			
			allParameters = this.parametersService.getAllParameters();

			request.setAttribute("allParameters", allParameters);

			getServletContext().getRequestDispatcher("/parameters/manageParameters.jsp").forward(request, response);

			break;



		case "insertRedirect":

			getServletContext().getRequestDispatcher("/parameters/insertParameters.jsp").forward(request, response);

			break;



		case "insert":

			// final Integer id = Integer.parseInt(request.getParameter("user_id"));

			final String sesso = request.getParameter("sesso").toString();

			final double altezza = Double.parseDouble(request.getParameter("altezza").toString());

			final double peso = Double.parseDouble(request.getParameter("peso").toString());
			
			final int eta= Integer.parseInt(request.getParameter("eta").toString());

			final int polso = Integer.parseInt(request.getParameter("polso").toString());

			final int freqResp = Integer.parseInt(request.getParameter("freqResp").toString());

			final int tempCorp = Integer.parseInt(request.getParameter("tempCorp").toString());



			final ParametersDTO parameters = new ParametersDTO(sesso,altezza,peso,eta,polso,freqResp,tempCorp);

			parametersService.insertParameters(parameters);

			showAllParameters(request, response);

			break;



		case "updateRedirect":

			int id = Integer.parseInt(request.getParameter("id"));

			ParametersDTO parametersUpdate = new ParametersDTO();

			parametersUpdate.setIdParameter(id);

			parametersUpdate = this.parametersService.readParameters(parametersUpdate);

			request.setAttribute("parametersUpdate", parametersUpdate);

			getServletContext().getRequestDispatcher("/parameters/updateParameters.jsp").forward(request, response);



			break;



		case "update":

			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));

			//System.out.println("username: " + request.getParameter("user_user"));

			//System.out.println("password: " + request.getParameter("user_pass"));

			//System.out.println("Tipo utente: " + request.getParameter("user_type"));



			final Integer idparameter = Integer.parseInt(request.getParameter("idParameter"));

			final String sessos = request.getParameter("sesso");

			final Double altezzas = Double.parseDouble(request.getParameter("altezza"));

			final Double pesos = Double.parseDouble(request.getParameter("peso"));
			
			final int etas= Integer.parseInt(request.getParameter("eta"));

			final int polsos = Integer.parseInt(request.getParameter("polso"));

			final int freqResps = Integer.parseInt(request.getParameter("freqResp"));

			final int tempCorps = Integer.parseInt(request.getParameter("tempCorp"));
			
			
			

			

			final ParametersDTO parameter= new ParametersDTO(sessos,altezzas,pesos,etas,polsos,freqResps,tempCorps);

			parameter.setIdParameter(idparameter);



			parametersService.updateParameters(parameter);

			showAllParameters(request, response);

			break;



		case "delete":

			final int deleteId = Integer.parseInt(request.getParameter("id"));



			final ParametersDTO parametersdelete = new ParametersDTO();

			parametersdelete.setIdParameter(deleteId);

			parametersService.deleteParameters(parametersdelete);

			showAllParameters(request, response);

			break;



		case "indietro":

			response.sendRedirect("homeAdmin.jsp");

			break;



		case "logsMenu":

			response.sendRedirect("index.jsp");

			break;





		}



	}







	private void showAllParameters(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		allParameters= this.parametersService.getAllParameters();

		request.setAttribute("allParameters", allParameters);

		getServletContext().getRequestDispatcher("/parameters/manageParameters.jsp").forward(request, response);

	}

}