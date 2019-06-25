package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.dto.SportDTO;
import it.contrader.services.SportService;
import it.contrader.services.*;

import java.util.List;

@Controller
@RequestMapping("/Sport")
public class SportController {

	private final SportService sportService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public SportController(SportService sportService) {
		this.sportService = sportService;
	}

	private void visualSport(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) this.session.getAttribute("utente");

		List<SportDTO> allSport = this.sportService.findSportDTOByUser(userDTO);
		request.setAttribute("allSportDTO", allSport);
	}

	@RequestMapping(value = "/sportManagement", method = RequestMethod.GET)
	public String deviceManagement(HttpServletRequest request) {
		visualSport(request);
		return "sport/sportManagement";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteSport(HttpServletRequest request) {
		int idSport = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", idSport);
		this.sportService.deleteSportById(idSport);
		visualSport(request);
		return "sport/sportManagement";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "sport/insertSport";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String sportName = request.getParameter("nome").toString();
		String sportTipo = request.getParameter("tipo").toString();
		Integer sportDurata= Integer.parseInt(request.getParameter("durata"));
		

		SportDTO sportObj = new SportDTO();
		sportObj.setNome(sportName);
		sportObj.setUserDTO(userLogged);
		sportObj.setTipo(sportTipo);
		sportObj.setDurata(sportDurata);
		sportService.insertSport(sportObj);
	
		visualSport(request);
		 

		return "sport/sportManagement";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		SportDTO sportUpdate = new SportDTO();

		sportUpdate = this.sportService.getSportDTOById(id);
		request.setAttribute("sportUpdate", sportUpdate);
		return "sport/updateSport";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("idSport"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String sportnome = request.getParameter("nome");
		String sporttipo = request.getParameter("tipo");
		Integer sportdurata = Integer.parseInt(request.getParameter("durata"));
		
		SportDTO sportUpdateDTO = new SportDTO();
		sportUpdateDTO.setUserDTO(userLogged);
		sportUpdateDTO.setNome(sportnome);
		sportUpdateDTO.setIdSport(idUpdate);
		sportUpdateDTO.setTipo(sporttipo);
		sportUpdateDTO.setDurata(sportdurata);
		
		sportService.updateSport(sportUpdateDTO);
		visualSport(request);
		
		return "sport/sportManagement";
	}
	
}