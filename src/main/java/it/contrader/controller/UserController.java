package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;



import it.contrader.dto.UserDTO;

import it.contrader.services.UserService;



import java.util.ArrayList;

import java.util.List;



@CrossOrigin

@Controller

@RequestMapping("/User")

public class UserController {



	private final UserService userService;

	private HttpSession session;



	@Autowired

	public UserController(UserService userService) {

		this.userService = userService;

	}



	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)

	public String userManagement(HttpServletRequest request) {

		request.setAttribute("user", getUsers());

		return "user/userManagement";

	}



	public List<UserDTO> getUsers() {

		List<UserDTO> tmp = userService.getListaUserDTO();

		List<UserDTO> userList = new ArrayList<>();

		for (UserDTO user : tmp) {

			if (user.getUsertype() != "") {

				userList.add(user);

			}

		}



		return userList;

	}





	@RequestMapping(value ="/deleteUser", method = RequestMethod.GET)

	public String deleteUser(HttpServletRequest request) {

		int idUser = Integer.parseInt(request.getParameter("id"));

		userService.deleteUserById(idUser);

		request.setAttribute("user", getUsers());

		return "user/userManagement";

	}

	

	

	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)

	public String redirectUpdate(HttpServletRequest request) {

		int idUser = Integer.parseInt(request.getParameter("id"));

		UserDTO user = userService.getUserDTOById(idUser);

		request.setAttribute("user", user);

		return "user/updateUser";

	}

	

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)

	public String updateUser(HttpServletRequest request)

	{

		int idUpdate = Integer.parseInt(request.getParameter("id"));

		String usernameUpdate = request.getParameter("username");

		String passwordUpdate = request.getParameter("password");

		String usertypeUpdate = request.getParameter("usertype");



		

		final UserDTO user = new UserDTO(usernameUpdate,passwordUpdate,usertypeUpdate);

		user.setId(idUpdate);

		

		userService.updateUser(user);

		request.setAttribute("user", getUsers());

		return "user/userManagement";	

		

	}

	

	

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)

	public String insertUser(HttpServletRequest request) {

		

		String username= request.getParameter("username");

		String password = request.getParameter("password");

		String usertype = request.getParameter("usertype");

		UserDTO userDTO = new UserDTO(username,password,usertype);

		

		userService.insertUser(userDTO);

		

		request.setAttribute("user", getUsers());

		

		return "user/userManagement";		

	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String loginControl(HttpServletRequest request) {



		session = request.getSession();

		final String username = request.getParameter("username");

		final String password = request.getParameter("password");

		final UserDTO userDTO = userService.getUserByUsernameAndPassword(username, password);

		final String userType = userDTO.getUsertype();

		if (!StringUtils.isEmpty(userType)) {



			session.setAttribute("utente", userDTO);



			/*

			 * if (userType.equals("admin")) { return "home"; } else if

			 * (userType.equals("bo")) { return "home"; }

			 */

			switch (userType.toLowerCase()) {

			case "admin":

				return "redirect:/Home/homeAdmin";

			case "user":

				return "redirect:/Home/homeUser";

			default:

				return "index";

			}



		}

		return "index";

	}

}