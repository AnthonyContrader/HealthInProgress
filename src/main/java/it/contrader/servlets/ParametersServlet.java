package it.contrader.servlets;



import java.io.IOException;

import java.util.ArrayList;

import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import it.contrader.converter.ConverterParameteres;



import it.contrader.dto.ParametersDTO;
import it.contrader.model.Parameters;
import it.contrader.service.ParametersService;





public class ParametersServlet extends HttpServlet {



	private final ParametersService parametersService = new ParametersService();

	private List<Parameters> allParameters = new ArrayList<>();



	@Override

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		final String scelta = request.getParameter("richiesta");

		final HttpSession session = request.getSession(true);



		switch (scelta) {



		case "ParametersManager":

			allParameters = this.parametersService.getAllParameters();

			request.setAttribute("allParameters", allParameters);

			getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);

			break;



		case "insertRedirect":

			response.sendRedirect("parameters/insertParameters.jsp");

			break;



		case "insert":

			// final Integer id = Integer.parseInt(request.getParameter("user_id"));

			final String sesso = request.getParameter("sesso");

			final double altezza = Double.parseDouble(request.getParameter("altezza"));
			final  double peso = Double.parseDouble(request.getParameter("peso"));
			final int eta  = Integer.parseInt(request.getParameter("eta"));
			final int polso = Integer.parseInt(request.getParameter("polso"));
			final int freqResp = Integer.parseInt(request.getParameter("freqResp"));
			final int tempCorp = Integer.parseInt(request.getParameter("tempCorp"));

			final ParametersDTO parameters = new ParametersDTO(sesso,altezza,peso,eta,polso,freqResp,tempCorp);

			parametersService.insertParameters(parameters);

			showAllParameters(request, response);

			break;



		case "updateRedirect":

			int id = Integer.parseInt(request.getParameter("idParameter"));

			ParametersDTO parametersUpdate = new ParametersDTO();

			parametersUpdate.setIdParameter(id);



			parametersUpdate = this.parametersService.readParameters(parametersUpdate);

			request.setAttribute("parametersUpdate", parametersUpdate);

			getServletContext().getRequestDispatcher("/user/updateParameters.jsp").forward(request, response);



			break;



		case "update":

			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));

			//System.out.println("username: " + request.getParameter("user_user"));

			//System.out.println("password: " + request.getParameter("user_pass"));

			//System.out.println("Tipo utente: " + request.getParameter("user_type"));



			final Integer idUpdate = Integer.parseInt(request.getParameter("idParameter"));

			final String sessoupdate= request.getParameter("sesso");

			final double altezzaupdate= Double.parseDouble(request.getParameter("altezza"));
			final  double pesoupdate = Double.parseDouble(request.getParameter("peso"));
			final int etaupdate  = Integer.parseInt(request.getParameter("eta"));
			final int polsoupdate = Integer.parseInt(request.getParameter("polso"));
			final int freqRespupdate = Integer.parseInt(request.getParameter("freqResp"));
			final int tempCorpupdate = Integer.parseInt(request.getParameter("tempCorp"));

			final ParametersDTO Parameters = new ParametersDTO(sessoupdate,altezzaupdate,pesoupdate,etaupdate,polsoupdate,freqRespupdate,tempCorpupdate);

			Parameters.setIdParameter(idUpdate);



			parametersService.updateParameters(Parameters);

			showAllUsers(request, response);

			break;



		case "delete":

			final Integer deleteId = Integer.parseInt(request.getParameter("idParameter"));



			final ParametersDTO parametersdelete = new ParametersDTO();

			parametersdelete.setIdParameter(deleteId);

			parametersService.deleteParameters(parametersdelete);

			showAllUsers(request, response);

			break;



		case "indietro":

			response.sendRedirect("homeAdmin.jsp");

			break;



		case "logsMenu":

			response.sendRedirect("index.jsp");

			break;



		}



	}



	private void showAllParameters(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}



	private void showAllUsers(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		allParameters = this.parametersService.getAllParameters();

		request.setAttribute("allParameters", allParameters);

		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);
	}
	}
