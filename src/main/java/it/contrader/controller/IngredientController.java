package it.contrader.controller;

import java.util.List;
import it.contrader.dto.IngredientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ingredient;
import it.contrader.service.IngredientService;

public class IngredientController implements Controller {

	private static String sub_package = "ingredient.";
	private IngredientService ingredientService;
	private Request request;

	public IngredientController() {
		this.ingredientService = new IngredientService();
	}

	public List<Ingredient> getAllIngredient() {
		return this.ingredientService.getAllIngredient();
	}

	public IngredientDTO readIngredient(int idingredient) {
		return this.ingredientService.readIngredient(idingredient);
	}

	public boolean insertIngredient(IngredientDTO ingredientDTO) {
		return this.ingredientService.insertIngredient(ingredientDTO);
	}

	public boolean updateIngredient(IngredientDTO ingredientDTO) {
		return this.ingredientService.updateIngredient(ingredientDTO);
	}

	public boolean deleteIngredient(Integer idingredient) {
		return this.ingredientService.deleteIngredient(idingredient);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Ingredient", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "IngredientRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "IngredientInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "IngredientUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "IngredientDelete", null);
				break;
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
