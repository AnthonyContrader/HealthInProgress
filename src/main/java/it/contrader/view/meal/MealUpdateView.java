package it.contrader.view.meal;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.*;
import it.contrader.dao.MealDAO;
import it.contrader.dto.*;
import it.contrader.service.*;
import it.contrader.main.MainDispatcher;
import it.contrader.model.*;
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
		int idPiattoToUpdate, kcal;
		String piatto;

		MealDTO mealDTO = new MealDTO();

		System.out.println("Digita idpiatto da modificare:");
		try {
			idPiattoToUpdate = Integer.parseInt(getInput());
			if (idPiattoToUpdate != 0) {

				mealDTO.setIdpiatti(idPiattoToUpdate);
				System.out.println("Digita il kcal da modificare:");
				kcal = Integer.parseInt(getInput());
				if (!kcal.equals(""))
					MealDTO.setKcal(kcal);

				System.out.println("Digita il nome piatto da modificare:");
				piatto = getInput();
				if (!piatto.equals(""))
					piatto.set

			
					mealController.updateMeal();
					

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
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
