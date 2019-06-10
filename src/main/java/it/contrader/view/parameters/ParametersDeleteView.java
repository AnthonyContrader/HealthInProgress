package it.contrader.view.parameters;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.ParametersController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Parameters;
import it.contrader.view.View;

public class ParametersDeleteView implements View {

	private ParametersController parametersController;
	private Request request;

	public ParametersDeleteView() {
		this.parametersController = new ParametersController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<User> users;
		//String usersId;

		//users = userController.getAllUser();
		System.out.println("Seleziona l'utente da cancellare: ");
		//System.out.println();
		//user.forEach(user -> System.out.println(user));
		//System.out.println();
		//System.out.println("Digita l'ID:");
		String idParameters = getInput();

		if (idParameters != null && StringUtils.isStrictlyNumeric(idParameters)) {
			parametersController.deleteParameters(Integer.parseInt(idParameters));
			
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
		MainDispatcher.getInstance().callAction("Parameters", "doControl", request);
	}

}
