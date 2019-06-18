package it.contrader.controller;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;



import it.contrader.dto.*;




import it.contrader.services.UserService;





import java.util.List;



@CrossOrigin

@Controller

@RequestMapping("/Home")

public class HomeController {



	private final UserService userService;

	

//	@Autowired

//	private ProjectService projectService;

//	

//	/*

//	private final ClientService clientService;

//	private final OrderService orderService;

//	private final TaskService taskService;

//	private final ProjectService projectService;

//	private final ProjectTemplateService projectTemplateService;

//	private final ResourceService resourceservice;

//*/

	private HttpSession session;



	@Autowired

	

	public HomeController(UserService userService) {

		this.userService = userService;

		

	}



	

	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)

	public String homeAdmin(HttpServletRequest request) {

		List<UserDTO> allUser = this.userService.getListaUserDTO();

		request.setAttribute("allUserDTO", allUser);

	
		return "homeAdmin.jsp";

	}



	


	

		
	}

