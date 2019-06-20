package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.dto.ParameterDTO;
import it.contrader.dao.*;
import it.contrader.services.ParameterService;
import it.contrader.services.*;
import it.contrader.*;

import java.util.List;

@Controller
@RequestMapping("/Parameter")
public class ParameterController {

	private final ParameterService parameterService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public ParameterController(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

	private void visualParameter(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) this.session.getAttribute("utente");

		List<ParameterDTO> allParameter = this.parameterService.findParameterDTOByUser(userDTO);
		request.setAttribute("allParameterDTO", allParameter);
	}

	@RequestMapping(value = "/parametertManagement", method = RequestMethod.GET)
	public String parameterManagement(HttpServletRequest request) {
		visualParameter(request);
		return "parameter/manageParameter";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.parameterService.getParameterDTOById(id);
		visualParameter(request);
		return "parameter/manageParameter";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "parameter/insertParameter";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String parameterSesso = request.getParameter("Parameter_sesso").toString();
		Integer parameterAltezza = Integer.parseInt(request.getParameter("parameter_altezza"));
		Integer parameterPeso= Integer.parseInt(request.getParameter("parameter_peso"));
		Integer parameterEta= Integer.parseInt(request.getParameter("parameter_eta"));
		Integer parameterTotEtaKacl= Integer.parseInt(request.getParameter("parameter_totKcal"));
		

		ParameterDTO parameterObj = new ParameterDTO();
		parameterObj.setSesso(parameterSesso);
		parameterObj.setAltezza(parameterAltezza);
		parameterObj.setPeso(parameterEta);
		parameterObj.setPeso(parameterTotEtaKacl);

		visualParameter(request);
		 

		return "/manage";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ParameterDTO parameterUpdate = new ParameterDTO();

		parameterUpdate = this.parameterService.getParameterDTOById(id);
		request.setAttribute("Update", parameterUpdate);
		return "/update";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("id"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String sesso = request.getParameter("sesso");
		Integer altezza= Integer.parseInt(request.getParameter("altezza"));
		Integer peso= Integer.parseInt(request.getParameter("peso"));
		Integer eta= Integer.parseInt(request.getParameter("eta"));
		Integer totKcal= Integer.parseInt(request.getParameter("totKcal"));

		
		ParameterDTO parameterUpdateDTO = new ParameterDTO();
		parameterUpdateDTO.setSesso(sesso);
		parameterUpdateDTO.setAltezza(altezza);
		parameterUpdateDTO.setPeso(peso);
		parameterUpdateDTO.setTotKcal(totKcal);

		
		parameterService.updateParameter(parameterUpdateDTO);
		visualParameter(request);
		
		return "/manage";
	}
	
}