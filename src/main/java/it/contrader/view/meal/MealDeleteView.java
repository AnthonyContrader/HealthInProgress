package it.contrader.view.meal;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.*;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Meal;
import it.contrader.view.View;

public class MealDeleteView implements View {

	private MealController mealController;
	private Request request;

	public MealDeleteView() {
		this.mealController = new MealController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<User> users;
		//String usersId;

		//users = userController.getAllUser();
		System.out.println("Seleziona i piatti da cancellare: ");
		//System.out.println();
		//user.forEach(user -> System.out.println(user));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String idpiatti = getInput();

		if (idpiatti != null && StringUtils.isStrictlyNumeric(idpiatti)) {
			mealController.deleteMeal(Integer.parseInt(idpiatti));
			
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
		MainDispatcher.getInstance().callAction("Meal", "doControl", request);
	}

}
