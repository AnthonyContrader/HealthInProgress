package it.contrader.view.ingredient;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.IngredientController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ingredient;
import it.contrader.view.View;

public class IngredientDeleteView implements View {

	private IngredientController ingredientController;
	private Request request;

	public IngredientDeleteView() {
		this.ingredientController = new IngredientController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<User> users;
		//String usersId;

		//users = userController.getAllUser();
		System.out.println("Seleziona l'utente da cancellare: ");
		//System.out.println();
		//user.forEach(user -> System.out.println(user));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String ingredientId = getInput();

		if (ingredientId != null && StringUtils.isStrictlyNumeric(ingredientId)) {
			ingredientController.deleteIngredient(Integer.parseInt(ingredientId));
			
		} else {
			System.out.println("Valore inserito errato");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Ingredient", "doControl", request);
	}

}
