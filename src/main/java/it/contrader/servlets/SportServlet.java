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
import it.contrader.dto.SportDTO;
import it.contrader.service.SportService;

public class SportServlet extends HttpServlet {

	private final SportService sportServiceDTO = new SportService();
	private List<SportDTO> allSport = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);

		switch (scelta) {

		case "SportManager":
			allSport = this.sportServiceDTO.getAllSports();
			request.setAttribute("allSport", allSport);
			getServletContext().getRequestDispatcher("/sport/manageSport.jsp").forward(request, response);
			break;
			
		

		case "insertRedirect":
			getServletContext().getRequestDispatcher("/sport/insertSport.jsp").forward(request, response);
			break;

		case "insert":
			// final Integer id = Integer.parseInt(request.getParameter("idsport"));
			final String nome = request.getParameter("nome");
			final int tipo = Integer.parseInt(request.getParameter("tipo").toString());
			final int durata = Integer.parseInt(request.getParameter("durata").toString());
			
			final SportDTO sport = new SportDTO(nome,tipo,durata);
			sportServiceDTO.insertSport(sport);
			showAllSport(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			SportDTO sportUpdate = new SportDTO();
			sportUpdate.setIdsport(id);

			sportUpdate = this.sportServiceDTO.readSport(sportUpdate);
			request.setAttribute("sportUpdate", sportUpdate);
			getServletContext().getRequestDispatcher("/sport/updateSport.jsp").forward(request, response);

			break;

		case "update":
			
			final int idsport = Integer.parseInt(request.getParameter("idsport"));
			final String nomes = request.getParameter("nome");
			final int tipos = Integer.parseInt(request.getParameter("tipo"));
			final int duratas = Integer.parseInt(request.getParameter("durata"));
			
			final SportDTO sports = new SportDTO(nomes,tipos,duratas);
			sports.setIdsport(idsport);

			sportServiceDTO.updateSport(sports);
			showAllSport(request, response);
			break;

		

		case "delete":
			final int deleteId = Integer.parseInt(request.getParameter("id"));

			final SportDTO sportdelete =  new SportDTO();
			sportdelete.setIdsport(deleteId);
			sportServiceDTO.deleteSport(sportdelete);
			showAllSport(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeAdmin.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;


		}

	}

	private void showAllSport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allSport = this.sportServiceDTO.getAllSports();
		request.setAttribute("allSport", allSport);
		getServletContext().getRequestDispatcher("/sport/manageSport.jsp").forward(request, response);
	}
}