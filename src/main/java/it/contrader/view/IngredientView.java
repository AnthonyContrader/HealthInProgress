package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.IngredientController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ingredient;

public class IngredientView implements View {

	private IngredientController ingredientController;
	private Request request;
	private String choice;
	
	public IngredientView() {
		this.ingredientController = new IngredientController();
	}

	@Override
	public void showResults(Request request) {
System.out.println("\n------ Gestione utenti -------\n");

		

		System.out.println("ID\tUsername\tPassword\tTipoUtente");

		System.out.print("------------------------------------------------------");
		System.out.println();
		List<Ingredient> ingredient = ingredientController.getAllIngredient();


		ingredient.forEach(Ingredient -> System.out.println(ingredient.toString()));

	}

	@Override
	public void showOptions() {
		
		
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Ingredient", "doControl", this.request);
	}

}
