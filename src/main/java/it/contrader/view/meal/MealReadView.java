package it.contrader.view.meal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.MealController;
import it.contrader.dto.MealDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Meal;
import it.contrader.dao.MealDAO;
import it.contrader.view.View;

public class MealReadView implements View {

	private MealController mealController;
	private Request request;
	public MealReadView() {
		this.mealController = new MealController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int mealIdToRead;

		System.out.println("Inserisci l'ID dell'utente:");

		try {
			mealIdToRead = Integer.parseInt(getInput());
			Meal mealDB = mealController.readMeal(mealIdToRead);

			System.out.println("Id: " +  mealDB.getIdpiatti());
			System.out.println("Kcal: " + mealDB.getKcal());
			System.out.println("piatto: " + mealDB.getPiatto());
			
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
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
