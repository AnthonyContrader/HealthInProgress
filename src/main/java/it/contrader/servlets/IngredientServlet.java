package it.contrader.servlets;



import java.io.IOException;

import java.util.ArrayList;

import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import it.contrader.dto.IngredientDTO;

import it.contrader.service.IngredientService;




@SuppressWarnings("serial")

public class IngredientServlet extends HttpServlet {



	private final IngredientService ingredientService = new IngredientService();

	private List<IngredientDTO> allIngredient = new ArrayList<>();





	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {



		final String scelta = request.getParameter("richiesta");

		final HttpSession session = request.getSession(true);



		switch (scelta) {



		case "IngredientManager":

			allIngredient = this.ingredientService.getAllIngredient();

			request.setAttribute("allIngredient", allIngredient);

			getServletContext().getRequestDispatcher("/ingredient/manageIngredient.jsp").forward(request, response);

			break;



		case "insertRedirect":

			getServletContext().getRequestDispatcher("/ingredient/insertIngredient.jsp").forward(request, response);

			break;



		case "insert":

			// final Integer id = Integer.parseInt(request.getParameter("user_id"));

			final String nome = request.getParameter("nome");

			


			final IngredientDTO ingredients = new IngredientDTO(nome);

			ingredientService.insertIngredient(ingredients);

			showAllIngredient(request, response);

			break;



		case "updateRedirect":

			int id = Integer.parseInt(request.getParameter("id"));

			IngredientDTO ingredientUpdate = new IngredientDTO("");

			ingredientUpdate.setIdingredient(id);

			ingredientUpdate = this.ingredientService.readIngredient(ingredientUpdate);

			request.setAttribute("ingredientUpdate", ingredientUpdate);

			getServletContext().getRequestDispatcher("/ingredient/updateIngredient.jsp").forward(request, response);



			break;



		case "update":

			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));
 
			//System.out.println("username: " + request.getParameter("user_user"));

			//System.out.println("password: " + request.getParameter("user_pass"));

			//System.out.println("Tipo utente: " + request.getParameter("user_type"));



			final Integer idUpdate = Integer.parseInt(request.getParameter("idingredient"));

		

			final String nomeUpdate = request.getParameter("nome");


			

			final IngredientDTO ingredient = new IngredientDTO(nomeUpdate);

			ingredient.setIdingredient(idUpdate);



			ingredientService.updateIngredient(ingredient);

			showAllIngredient(request, response);

			break;



		case "delete":

			final int deleteId = Integer.parseInt(request.getParameter("id"));



			final IngredientDTO ingredientdelete = new IngredientDTO("");

			ingredientdelete.setIdingredient(deleteId);

			ingredientService.deleteIngredient(ingredientdelete);

			showAllIngredient(request, response);

			break;



		case "indietro":

			response.sendRedirect("homeAdmin.jsp");

			break;



		case "logsMenu":

			response.sendRedirect("index.jsp");

			break;





		}



	}



	



	private void showAllIngredient(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		allIngredient = this.ingredientService.getAllIngredient();

		request.setAttribute("allIngredient", allIngredient);

		getServletContext().getRequestDispatcher("/ingredient/manageIngredient.jsp").forward(request, response);

	}

}
