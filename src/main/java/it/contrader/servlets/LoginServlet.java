package it.contrader.servlets;



import java.io.IOException;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import it.contrader.service.UserService;

import it.contrader.dto.UserDTO;



@SuppressWarnings("serial")

public class LoginServlet extends HttpServlet {

	

	private  UserService usersServiceDTO = new UserService();



	@Override

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		final HttpSession session = request.getSession();

		session.setAttribute("utente",null);



		if (request != null) {

			final String nome = request.getParameter("nome").toString();

			final String password = request.getParameter("password").toString();

			final UserDTO userDTO = usersServiceDTO.getUserByNomeAndPassword(nome, password);

			//System.out.println(userDTO.getUsername());

			//System.out.println(userDTO.getPassword());

			if (userDTO != null) {

				try {

				session.setAttribute("utente", userDTO.getNome());



			switch (userDTO.getTipo())

					{

			case "admin":

				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

				break;
			case "user":

				getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);

				break;

		
			default:

				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

				break;

		}

	}catch(Exception e) {

		session.setAttribute("error", "WRONG USER OR PASSWORD");

		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);	

	}

}

else {

getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

}

}

}}