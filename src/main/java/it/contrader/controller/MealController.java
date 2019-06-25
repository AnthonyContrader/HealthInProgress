package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.dto.MealDTO;
import it.contrader.dao.*;
import it.contrader.services.MealService;
import it.contrader.services.*;
import it.contrader.*;

import java.util.List;

@Controller
@RequestMapping("/Meal")
public class MealController {

	private final MealService mealService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public MealController(MealService mealService) {
		this.mealService = mealService;
	}

	private void visualMeal(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) this.session.getAttribute("utente");

		List<MealDTO> allMeal = this.mealService.findMealDTOByUser(userDTO);
		request.setAttribute("allMealDTO", allMeal);
	}

	@RequestMapping(value = "/mealManagement", method = RequestMethod.GET)
	public String mealManagement(HttpServletRequest request) {
		visualMeal(request);
		return "meal/mealManagement";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteMeal(HttpServletRequest request) {
		int idPiatto = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", idPiatto);
		this.mealService.deleteMealById(idPiatto);
		visualMeal(request);
		return "meal/mealManagement";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "meal/insertMeal";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String mealName = request.getParameter("nome").toString();
		Integer mealKcal = Integer.parseInt(request.getParameter("kcal"));
		String mealTipo= request.getParameter("tipo").toString();
	
		

		MealDTO mealObj = new MealDTO();
		mealObj.setNome(mealName);
		mealObj.setUserDTO(userLogged);
		mealObj.setKcal(mealKcal);
		mealObj.setTipo(mealTipo);
		mealService.insertMeal(mealObj);
		visualMeal(request);
		 

		return "meal/mealManagement";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		MealDTO mealUpdate = new MealDTO();

		mealUpdate = this.mealService.getMealDTOById(id);
		request.setAttribute("mealUpdate", mealUpdate);
		return "meal/updateMeal";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("idPiatto"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String mealpiatto = request.getParameter("idPiatto");
		Integer mealkcal= Integer.parseInt(request.getParameter("kcal"));
		String mealtipo = request.getParameter("tipo");


		
		MealDTO mealUpdateDTO = new MealDTO();
		mealUpdateDTO.setUserDTO(userLogged);
		mealUpdateDTO.setIdPiatto(idUpdate);
		mealUpdateDTO.setNome(mealpiatto);
		mealUpdateDTO.setKcal(mealkcal);
		mealUpdateDTO.setTipo(mealtipo);

		
		mealService.updateMeal(mealUpdateDTO);
		visualMeal(request);
		
		return "meal/mealManagement";
	}
	
}