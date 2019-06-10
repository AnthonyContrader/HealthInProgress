package it.contrader.view.meal;

import java.util.Scanner;

import it.contrader.controller.MealController;
import it.contrader.controller.Request;
import it.contrader.dto.MealDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Meal;
import it.contrader.view.View;

public class MealInsertView implements View {

	private MealController mealController;
	private Request request;

	public MealInsertView() {
		this.mealController = new MealController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int kcal ;
		String piatto = new String() ;
	

		System.out.println("Inserisci i campi del piatto:");	
		System.out.println("Digita il nome de piatto: ");
		piatto = getInput();
		System.out.println("Digita il num Kcal : ");
		kcal = Integer.parseInt(getInput());
		
		
		if (!piatto.equals("") && kcal !=0  ) {
			mealController.insertMeal(new MealDTO(piatto,kcal));
	    
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
		MainDispatcher.getInstance().callAction("Meal", "doControl", request);
	}

}
