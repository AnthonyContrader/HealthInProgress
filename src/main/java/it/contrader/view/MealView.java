package it.contrader.view;

import java.util.List;
import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.controller.MealController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Meal;

public class MealView implements View {

	private MealController mealController;
	private Request request;
	private String choice;
	
	public MealView() {
		this.mealController = new MealController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione Piatti -------\n");
			
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
		    MainDispatcher.getInstance().callAction("Meal", "doControl", this.request);
	}

}