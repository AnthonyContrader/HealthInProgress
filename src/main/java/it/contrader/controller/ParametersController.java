package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ParametersDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Parameters;
import it.contrader.service.ParametersService;;

public class ParametersController implements Controller {

	private static String sub_package = "parameters.";
	private ParametersService parametersService;
	private Request request;

	public ParametersController() {
		this.parametersService = new ParametersService();
	}

	public List<Parameters> getAllParameters() {
		return this.parametersService.getAllParameters();
	}

	public ParametersDTO readParameters(int idParameters) {
		return this.parametersService.readParameters(idParameters);
	}

	public boolean insertParameters(ParametersDTO parametersDTO) {
		return this.parametersService.insertParameters(parametersDTO);
	}

	public boolean updateParameters(ParametersDTO parametersDTO) {
		return this.parametersService.updateParameters(parametersDTO);
	}

	public boolean deleteParameters(Integer idParameters) {
		return this.parametersService.deleteParameters(idParameters);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Parameters", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ParametersRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ParametersInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ParametersUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ParametersDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
