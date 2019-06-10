package it.contrader.view.parameters;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ParametersController;
import it.contrader.dto.ParametersDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Parameters;
import it.contrader.view.View;

public class ParametersReadView implements View {

	private  ParametersController parametersController;
	private Request request;

	public ParametersReadView() {
		this.parametersController = new ParametersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int parametersIdToRead;

		System.out.println("Inserisci l'ID dell'utente:");

		try {
			parametersIdToRead = Integer.parseInt(getInput());
			ParametersDTO parametersDB = parametersController.readParameters(parametersIdToRead);

			System.out.println("Id: " + parametersDB.getIdParameter());
			System.out.println("sesso: " + parametersDB.getSesso());
			System.out.println("Altezza: " + parametersDB.getAltezza());
			System.out.println("Peso: " + parametersDB.getPeso());
			System.out.println("Eta: " + parametersDB.getEta());
			System.out.println("Polso: " + parametersDB.getPolso());
			System.out.println("FreqResp: " + parametersDB.getFreqResp());
			System.out.println("TempCorp: " + parametersDB.getTempCorp());
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
		MainDispatcher.getInstance().callAction("Parameters", "doControl", request);
	}

}