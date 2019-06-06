package it.contrader.controller;


import java.util.List;

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

	public List<Meal> getAllClient() {
		return this.mealService.getAllMeal();
	}
	
	public Meal readMeal(int MealId) {
		
		return this.mealService.readMeal(MealId);
	}
	
	public boolean insertMeal(Meal meal) {
		return this.mealService.insertMeal(meal);
	}

	public boolean updateMeal(Meal meal) {
		return this.mealService.updateMeal(meal);

	}

	public boolean deleteClient(Integer Idpiatti) {
		return this.mealService.deleteMeal(Idpiatti);

	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Client", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ClientRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ClientInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ClientUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ClientDelete", null);
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
