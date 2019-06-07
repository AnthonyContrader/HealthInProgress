package it.contrader.view;

import java.util.List;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ParametersController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Parameters;

public class ParametersView implements View {

	private ParametersController ParametersController;
	private Request request;
	private String choice;
	
	public ParametersView() {
		this.ParametersController = new ParametersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Gestione parametri -------\n");
		
		System.out.println("idparameter,sesso,altezza,peso,eta,polso,frequenzaRespiratoria,temperaturaCorporea");
		System.out.print("------------------------------------------------------");
		List<Parameters> parameters = ParametersController.getAllParameters();
		System.out.println();
		parameters.forEach(parameter -> System.out.println(parameters.toString()));
		System.out.println();
		
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
