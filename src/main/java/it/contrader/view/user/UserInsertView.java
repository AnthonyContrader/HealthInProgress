package it.contrader.view.user;

import java.util.Scanner;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserInsertView implements View {

	private UserController usersController;
	private Request request;

	public UserInsertView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String nome= new String() ;
		String tipo = new String() ;
		String password = new String() ;

		System.out.println("Inserisci i campi dell'utente:");
		System.out.println("Digita il nome: ");
		nome = getInput();
		System.out.println("Digita il password: ");
		password = getInput();
		System.out.println("Inserisci la tipologia utente");
		tipo=getInput();
		if (!nome.equals("") && !password.equals("") && !tipo.equals("")) {
			usersController.insertUser(new UserDTO(nome,password,tipo));
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
