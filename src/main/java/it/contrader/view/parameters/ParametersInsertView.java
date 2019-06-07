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
		String sesso= new String() ;
		String altezza = new String() ;
		String peso = new String() ;
		String eta = new String() ;
		String polso = new String() ;
		String freqResp = new String() ;
		String tempCorp = new String();
		
		System.out.println("Inserisci i campi dei parametri:");
		System.out.println("Digita il sesso: ");
		sesso = getInput();
		System.out.println("Digita l'altezza: ");
		altezza = getInput();
		System.out.println("Inserisci il peso");
		peso = getInput();
		System.out.println("Inserisci il eta");
		eta = getInput();
		System.out.println("Inserisci il polso");
		 polso = getInput();
		System.out.println("Inserisci il freqResp");
		freqResp = getInput();
		System.out.println("Inserisci il tempCorp");
		tempCorp= getInput();

		if (!sesso.equals("") && !altezza.equals("") && !peso.equals("")&&!eta.equals("")&&!polso.equals("")&&!freqResp.equals("")&&!tempCorp.equals("")) {
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
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
