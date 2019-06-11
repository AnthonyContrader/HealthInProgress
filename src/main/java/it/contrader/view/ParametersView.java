package it.contrader.view;

import java.util.List;


import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ParametersController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Meal;
import it.contrader.model.Parameters;
import it.contrader.model.User;


public class ParametersView implements View {

	private ParametersController parametersController;
	private Request request;
	private String choice;
	
	public ParametersView() {
		this.parametersController = new ParametersController();
	}

	@Override
	public void showResults(Request request) {


		System.out.println("\n------ Gestione Parametri-------\n");
	
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
		    MainDispatcher.getInstance().callAction("Parameters", "doControl", this.request);
	}

}
