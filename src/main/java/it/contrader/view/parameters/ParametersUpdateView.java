package it.contrader.view.parameters;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.*;
import it.contrader.dto.*;
import it.contrader.main.MainDispatcher;
import it.contrader.model.*;
import it.contrader.view.View;

public class ParametersUpdateView implements View {

	private ParametersController parametersController;
	private Request request;

	public ParametersUpdateView() {
		this.parametersController = new ParametersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int parameterIdToUpdate,eta,polso,ferqResp,tempCorp;
		double altezza,peso;
		String sesso ;

		ParametersDTO parametersDTO = new ParametersDTO();

		System.out.println("Digita l'Id dell parameter da modificare:");
		try {
			parameterIdToUpdate = Integer.parseInt(getInput());
			if (parameterIdToUpdate != 0) {
				parametersDTO.setIdParameter(parameterIdToUpdate);

				System.out.println("Digita il sesso:");
				sesso = getInput();
				if (!sesso.equals(""))
					parametersDTO.getSesso();
				
				System.out.println("Digita la nuova altezza");
				altezza = Double.parseDouble(getInput());
				if (altezza !=0)
					parametersDTO.setAltezza(altezza);

			
				System.out.println("Digita il nuovo peso");
				peso = Double.parseDouble(getInput());
				if (peso !=0)
					parametersDTO.setPeso(peso);
				
				System.out.println("Digita la nuova eta");
				eta = Integer.parseInt(getInput());
				if (eta !=0)
					parametersDTO.setEta(eta);
				
				
				System.out.println("Digita la nuova poslo");
				polso = Integer.parseInt(getInput());
				if (polso !=0)
					parametersDTO.setEta(polso);
				
				
				System.out.println("Digita la nuova ferResp");
				ferqResp = Integer.parseInt(getInput());
				if (ferqResp !=0)
					parametersDTO.setFreqResp(ferqResp);
				
				System.out.println("Digita la tempCorp");
				tempCorp= Integer.parseInt(getInput());
				if (tempCorp !=0)
					parametersDTO.setTempCorp(tempCorp);
				


				parametersController.updateParameters(parametersDTO);
				

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
