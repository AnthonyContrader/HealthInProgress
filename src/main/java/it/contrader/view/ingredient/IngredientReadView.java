package it.contrader.view.ingredient;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.IngredientController;
import it.contrader.dto.IngredientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ingredient;
import it.contrader.view.View;

public class IngredientReadView implements View {

	private IngredientController ingredientController;
	private Request request;

	public IngredientReadView() {
		this.ingredientController = new IngredientController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int ingredientIdToRead;

		System.out.println("Inserisci l'ID dell'utente:");

		try {
			ingredientIdToRead = Integer.parseInt(getInput());
			IngredientDTO ingredientDB = ingredientController.readIngredient(ingredientIdToRead);

			System.out.println("Id: " + ingredientDB.getIdingredient());
			System.out.println("nome: " + ingredientDB.getNome());
			
			
			//Wait user to show
			System.out.println("Premi un tasto per continuare");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Ingredient", "doControl", request);
	}

}
