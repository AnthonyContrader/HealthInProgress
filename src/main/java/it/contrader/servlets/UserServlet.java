package it.contrader.servlets;



import java.io.IOException;

import java.util.ArrayList;

import java.util.List;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import it.contrader.converter.ConverterUser;



import it.contrader.dto.UserDTO;

import it.contrader.service.UserService;





public class UserServlet extends HttpServlet {



	private final UserService userService = new UserService();

	private List<UserDTO> allUser = new ArrayList<>();



	@Override

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		final String scelta = request.getParameter("richiesta");

		final HttpSession session = request.getSession(true);



		switch (scelta) {



		case "UserManager":

			allUser = this.userService.getAllUser();

			request.setAttribute("allUser", allUser);

			getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);

			break;



		case "insertRedirect":

			response.sendRedirect("user/insertUser.jsp");

			break;



		case "insert":

			// final Integer id = Integer.parseInt(request.getParameter("user_id"));

			final String username = request.getParameter("nome");

			final String password = request.getParameter("password");

			final String usertype = request.getParameter("tipo");

			final UserDTO user = new UserDTO(username, password, usertype);

			userService.insertUser(user);

			showAllUsers(request, response);

			break;



		case "updateRedirect":

			int id = Integer.parseInt(request.getParameter("Iduser"));

			UserDTO userUpdate = new UserDTO("", "", "");

			userUpdate.setUserId(id);



			userUpdate = this.userService.readUser(userUpdate);

			request.setAttribute("userUpdate", userUpdate);

			getServletContext().getRequestDispatcher("/user/updateUser.jsp").forward(request, response);



			break;



		case "update":

			//System.out.println("ID: " + Integer.parseInt(request.getParameter("user_id")));

			//System.out.println("username: " + request.getParameter("user_user"));

			//System.out.println("password: " + request.getParameter("user_pass"));

			//System.out.println("Tipo utente: " + request.getParameter("user_type"));



			final Integer idUpdate = Integer.parseInt(request.getParameter("Iduser"));

			final String usernameUpdate = request.getParameter("nome");

			final String passwordUpdate = request.getParameter("password");

			final String usertypeUpdate = request.getParameter("tipo");

			final UserDTO User = new UserDTO(usernameUpdate, passwordUpdate, usertypeUpdate);

			User.setUserId(idUpdate);



			userService.updateUser(User);

			showAllUsers(request, response);

			break;



		case "delete":

			final Integer deleteId = Integer.parseInt(request.getParameter("id"));



			final UserDTO userdelete = new UserDTO("", "", "");

			userdelete.setUserId(deleteId);

			userService.deleteUser(userdelete);

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



	private void showAllUsers(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		allUser = this.userService.getAllUser();

		request.setAttribute("allUser", allUser);

		getServletContext().getRequestDispatcher("/user/manageUser.jsp").forward(request, response);

	}

}