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
		return "sport/manageSport";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.sportService.getSportDTOById(id);
		visualSport(request);
		return "sport/manageSport";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "sport/insertSport";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String sportName = request.getParameter("sport_name").toString();
		String sportTipo = request.getParameter("sport_tipo").toString();
		Integer sportDurata= Integer.parseInt(request.getParameter("sport_duarata"));
		

		SportDTO sportObj = new SportDTO();
		sportObj.setNome(sportName);
		sportObj.setTipo(sportTipo);
		sportObj.setDurata(sportDurata);
	
		visualSport(request);
		 

		return "sport/manageSport";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		SportDTO sportUpdate = new SportDTO();

		sportUpdate = this.sportService.getSportDTOById(id);
		request.setAttribute("sportUpdate", sportUpdate);
		return "sport/update";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("id"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		Integer durata = Integer.parseInt(request.getParameter("duarata"));
		
		SportDTO sportUpdateDTO = new SportDTO();
		sportUpdateDTO.setNome(nome);
		sportUpdateDTO.setTipo(tipo);
		sportUpdateDTO.setDurata(durata);
		
		
		sportService.updateSport(sportUpdateDTO);
		visualSport(request);
		
		return "sport/manageSport";
	}
	
}