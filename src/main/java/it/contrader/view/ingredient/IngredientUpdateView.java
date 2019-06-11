package it.contrader.view.ingredient;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.IngredientController;
import it.contrader.dto.IngredientDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Ingredient;
import it.contrader.view.View;

public class IngredientUpdateView implements View {

	private IngredientController ingredientController;
	private Request request;

	public IngredientUpdateView() {
		this.ingredientController = new IngredientController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int ingredientIdToUpdate;
		String nome ;

		IngredientDTO ingredientDTO = new IngredientDTO();

		System.out.println("Digita l'Id dell'ingrediente da modificare:");
		try {
			ingredientIdToUpdate = Integer.parseInt(getInput());
			if (ingredientIdToUpdate != 0) {
				ingredientDTO.setIdingredient(ingredientIdToUpdate);

				System.out.println("Digita il nuovo ingrediente:");
				nome = getInput();
				
				if (!nome.equals(""))
					ingredientDTO.setNome(nome);
				

				
				
		
				ingredientController.updateIngredient(ingredientDTO);
				

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
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
