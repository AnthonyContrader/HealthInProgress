package it.contrader.view.meal;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.MealController;
import it.contrader.dto.MealDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Meal;
import it.contrader.view.View;

public class MealUpdateView implements View {

	private MealController mealController;
	private Request request;

	public MealUpdateView() {
		this.mealController = new MealController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idpiattiToUpdate;
		String piatto;
		int kcal;
	

		MealDTO mealDTO = new MealDTO();

		System.out.println("Digita l'Id dell'utente da modificare:");
		try {
			idpiattiToUpdate = Integer.parseInt(getInput());
			if (idpiattiToUpdate != 0) {
				mealDTO.setIdpiatti(idpiattiToUpdate);

				System.out.println("Digita il nuovo piatto:");
				piatto = getInput();

				if (!piatto.equals(""))
					mealDTO.setPiatto(piatto);
				System.out.println("Digita il numero di kcal:");
				kcal = Integer.parseInt(getInput());
				if (kcal>0)
					mealDTO.setKcal(kcal);
				mealController.updateMeal(mealDTO);

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
		MainDispatcher.getInstance().callAction("Meal", "doControl", request);
	}

}
