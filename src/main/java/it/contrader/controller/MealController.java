package it.contrader.controller;


import java.util.List;

import it.contrader.dto.MealDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Meal;
import it.contrader.service.MealService;



public class MealController implements Controller {

	private static String sub_package = "meal.";
	private MealService mealService;
	private Request request;

	public MealController() {
		this.mealService= new MealService();
	}

	public List<Meal> getAllMeal() {
		return this.mealService.getAllMeal();
	}
	
	public Meal readMeal(int MealId) {
		
		return this.mealService.readMeal(MealId);
	}
	
	public boolean insertMeal(Meal mealDTO) {
		return this.mealService.insertMeal(mealDTO);
	}

	public boolean updateMeal(Meal meal) {
		return this.mealService.updateMeal(meal);

	}

	public boolean deleteMeal(Integer Idpiatti) {
		return this.mealService.deleteMeal(Idpiatti);

	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Meal", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "MealRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "MealInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "MealUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "Meal", null);
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

	public void insertMeal(MealDTO mealDTO) {
		// TODO Auto-generated method stub
		
	}

}
