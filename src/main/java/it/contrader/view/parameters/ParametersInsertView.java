package it.contrader.view.parameters;

import java.util.Scanner;



import it.contrader.controller.Request;
import it.contrader.controller.ParametersController;
import it.contrader.dto.ParametersDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class ParametersInsertView implements View {

	private ParametersController parametersController;
	private Request request;

	public ParametersInsertView() {
		this.parametersController = new ParametersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String sesso;
		double altezza  ;
		double peso;
		int eta,polso,freqResp,tempCorp;
		
		System.out.println("Inserisci i campi dei parametri:");
		System.out.println("Digita il sesso: ");
		sesso = getInput();
		System.out.println("Digita l'altezza: ");
		altezza =  Double.parseDouble(getInput());
		System.out.println("Inserisci il peso");
		peso = Double.parseDouble(getInput());
		System.out.println("Inserisci il eta");
		eta = Integer.parseInt(getInput());		
				System.out.println("Inserisci il polso");
		polso = Integer.parseInt(getInput());
		System.out.println("Inserisci il freqResp");
		freqResp =Integer.parseInt(getInput());
		System.out.println("Inserisci il tempCorp");
		tempCorp = Integer.parseInt(getInput());

		if (!sesso.equals("") && altezza!=0 && peso !=0 && eta !=0 && polso !=0 && freqResp !=0 && tempCorp !=0) 
		{
			parametersController.insertParameters(new ParametersDTO(sesso,altezza,peso,eta,polso,freqResp,tempCorp));
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
		MainDispatcher.getInstance().callAction("Parameters", "doControl", request);
	}

}
