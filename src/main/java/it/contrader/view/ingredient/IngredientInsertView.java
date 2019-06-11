package it.contrader.view.ingredient;

import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.controller.IngredientController;
import it.contrader.dto.IngredientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class  IngredientInsertView implements View {

	private IngredientController ingredientController;
	private Request request;

	public IngredientInsertView() {
		this.ingredientController = new IngredientController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String nome ;
		

		System.out.println("Inserisci il nome dell'ingrediente:");
		System.out.println("Digita il nome: ");
		nome = getInput();
		
		if (!nome.equals("") ) {
			ingredientController.insertIngredient(new IngredientDTO(nome));
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
