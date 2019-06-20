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
		return "meal/manageMeal";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.mealService.getMealDTOById(id);
		visualMeal(request);
		return "meal/manageMeal";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "meal/insertMeal";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		
		String mealPiatto = request.getParameter("meal_piatto").toString();
		Integer mealKcal = Integer.parseInt(request.getParameter("meal_kcal"));
		String mealTipo= request.getParameter("meal_tipo").toString();
	
		

		MealDTO mealObj = new MealDTO();
		mealObj.setNome(mealPiatto);
		mealObj.setKcal(mealKcal);
		mealObj.setTipo(mealTipo);


		visualMeal(request);
		 

		return "/manage";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MealDTO mealUpdate = new MealDTO();

		mealUpdate = this.mealService.getMealDTOById(id);
		request.setAttribute("Update", mealUpdate);
		return "/update";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("id"));
		UserDTO userLogged = (UserDTO) session.getAttribute("utente");
		String piatto = request.getParameter("piatto");
		Integer kcal= Integer.parseInt(request.getParameter("kcal"));
		Integer tipo= Integer.parseInt(request.getParameter("tipo"));


		
		MealDTO mealUpdateDTO = new MealDTO();
		mealUpdateDTO.setNome(piatto);
		mealUpdateDTO.setKcal(kcal);
		mealUpdateDTO.setKcal(kcal);

		
		mealService.updateMeal(mealUpdateDTO);
		visualMeal(request);
		
		return "/manage";
	}
	
}