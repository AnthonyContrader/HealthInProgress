package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.MealDTO;
import it.contrader.dto.DeviceDTO;
import it.contrader.dto.IngredientDTO;
import it.contrader.services.DeviceService;
import it.contrader.services.*;

import java.util.List;

@Controller
@RequestMapping("/Ingredient")
public class IngredientController {

	private final IngredientService ingredientService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	private void visualIngredient(HttpServletRequest request) {
		MealDTO mealDTO = (MealDTO) this.session.getAttribute("piatto");

		List<IngredientDTO> allIngredient = this.ingredientService.findIngredientDTOByMeal(mealDTO);
		request.setAttribute("allIngredientDTO", allIngredient);
	}

	@RequestMapping(value = "/ingredientManagement", method = RequestMethod.GET)
	public String ingredientManagement(HttpServletRequest request) {
		visualIngredient(request);
		return "ingredient/ingredientManagement";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.ingredientService.deleteIngredientById(id);
		visualIngredient(request);
		return "ingredient/ingredientManagement";

	}

	@RequestMapping(value = "/insertRedirect", method = RequestMethod.GET)
	public String insertRedirect(HttpServletRequest request) {
		return "ingredient/insertIngredient";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request,HttpSession session) {
		MealDTO meal= (MealDTO) session.getAttribute("piatto");
		
		String ingredientName = request.getParameter("nome").toString();
		

		IngredientDTO ingredientObj = new IngredientDTO();
		ingredientObj.setNome(ingredientName);
		ingredientObj.setMealDTO(meal);
		ingredientService.insertIngredient(ingredientObj);
		visualIngredient(request);
		 

		return "ingredient/ingredientManagement";
	}
	@RequestMapping(value = "/updateRedirect", method = RequestMethod.GET)
	public String updateRedirect(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		IngredientDTO ingredientUpdate = new IngredientDTO();

		ingredientUpdate = this.ingredientService.getIngredientDTOById(id);
		request.setAttribute("ingredientUpdate", ingredientUpdate);
		return "ingredient/updateIngredient";
	}		
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpSession session) {
		
		Integer idUpdate = Integer.parseInt(request.getParameter("idIngredient"));
		MealDTO meal = (MealDTO) session.getAttribute("piatto");
		String ingredientName = request.getParameter("nome");
		
		IngredientDTO ingredientUpdateDTO = new IngredientDTO();
		ingredientUpdateDTO.setNome(ingredientName);
		ingredientUpdateDTO.setIdIngredient(idUpdate);
		ingredientUpdateDTO.setMealDTO(meal);

		
		
		ingredientService.updateIngredient(ingredientUpdateDTO);
		visualIngredient(request);
		
		return "ingredient/ingredientManagement";
	}
	
}