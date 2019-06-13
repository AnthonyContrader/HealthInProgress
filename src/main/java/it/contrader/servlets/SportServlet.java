package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.SportDTO;
import it.contrader.service.SportServiceDTO;


@SuppressWarnings("serial")
public class SportServlet extends HttpServlet {

	private final SportServiceDTO sportServiceDTO = new SportServiceDTO();
	private List<SportDTO> allSports = new ArrayList<>();


	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "SportManager":
			allSports = this.sportServiceDTO.getAllSports();
			request.setAttribute("allSport", allSports);
			getServletContext().getRequestDispatcher("/sport/manageSport.jsp").forward(request, response);
			break;

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/sport/insertSport.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("user_id"));
			final String nome = request.getParameter("nome");
			final String tipo = request.getParameter("tipo");
			final Double durata = Double.valueOf(request.getParameter("durata"));
			final SportDTO sports = new SportDTO(nome, tipo, durata);
			sportServiceDTO.insertSports(sports);
			showAllSports(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			SportDTO sportUpdate = new SportDTO("", "",0);
			sportUpdate.setIdsport(id);

			sportUpdate = this.sportServiceDTO.readSport(sportUpdate);
			request.setAttribute("sportUpdate", sportUpdate);
			getServletContext().getRequestDispatcher("/sport/updateSport.jsp").forward(request, response);

			break;

		case "update":
			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));
			//System.out.println("username: " + request.getParameter("user_user"));
			//System.out.println("password: " + request.getParameter("user_pass"));
			//System.out.println("Tipo utente: " + request.getParameter("user_type"));

			final Integer idUpdate = Integer.parseInt(request.getParameter("user_id"));
			final String nomeUpdate = request.getParameter("nome");
			final String tipoUpdate= request.getParameter("tipo");
			final Double durataUpdate = Double.valueOf(request.getParameter("durata"));
			final SportDTO sport = new SportDTO(nomeUpdate, tipoUpdate, durataUpdate);
			sport.setIdsport(idUpdate);

			sportServiceDTO.updateSport(sport);
			showAllSports(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));

			final SportDTO sportdelete = new SportDTO("","",0.0);
			sportdelete.setIdsport(deleteId);
			sportServiceDTO.deleteSports(sportdelete);
			showAllSports(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;


		}

	}

	private void showAllSports(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allSports = this.sportServiceDTO.getAllSports();
		request.setAttribute("allSport", allSports);
		getServletContext().getRequestDispatcher("/sport/manageUser.jsp").forward(request, response);
	}
}