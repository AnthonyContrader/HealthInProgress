package it.contrader.view.parameters;

import java.util.List;


import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ParametersController;
import it.contrader.dto.ParametersDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Parameters;
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
		int parametersIdToUpdate;
		String sesso;
		int eta, polso, freqres, tempcorp;
		double altezza, peso;

		ParametersDTO parametersDTO = new ParametersDTO();

		System.out.println("Digita l'Id parametro da modificare:");
		try {
			parametersIdToUpdate = Integer.parseInt(getInput());
			if (parametersIdToUpdate != 0) {
				parametersDTO.setIdParameter(parametersIdToUpdate);
				
				
				System.out.println("Digita nuovo sesso:");
				sesso = getInput();

				if (!sesso.equals(""))
					parametersDTO.setSesso(sesso);
				System.out.println("Digita la nuova altezza:");
				altezza = Double.parseDouble(getInput());
				
				if (altezza != 0)
					
				parametersDTO.setAltezza(altezza);

				System.out.println("Digita nuovo peso:");
				peso = Double.parseDouble(getInput());
				if (peso != 0)
				parametersDTO.setPeso(peso);
				System.out.println("Digita nuovo eta:");
				eta = Integer.parseInt(getInput());
				if (eta != 0)
				parametersDTO.setEta(eta);

				System.out.println("Digita nuovo peso:");
				peso = Integer.parseInt(getInput());
				if (peso != 0)
				parametersDTO.setPeso(peso);
				System.out.println("Digita nuovo polso:");
				polso = Integer.parseInt(getInput());
				if (polso != 0)
				parametersDTO.setPolso(polso);
				System.out.println("Digita nuovo freqResp:");
				freqres = Integer.parseInt(getInput());
				if (freqres != 0)
				parametersDTO.setFreqResp(freqres);
				System.out.println("Digita nuovo tempCorp:");
				tempcorp = Integer.parseInt(getInput());
				if (tempcorp != 0)
				parametersDTO.setTempCorp(tempcorp);

				parametersController.updateParameters(parametersDTO);

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
		}

	}

	@Override
	public String getInput() {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		return in.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Parameters", "doControl", request);
	}

}
