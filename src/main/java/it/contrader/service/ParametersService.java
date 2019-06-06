package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterParameteres;
import it.contrader.dao.ParametersDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.ParametersDTO;
import it.contrader.model.Parameters;

public class ParametersService {

	private ParametersDAO parametersDAO;

	public ParametersService() {
		this.parametersDAO = new ParametersDAO();
	}

	public List<Parameters> getAllParameters() {
		return this.parametersDAO.getAllParameters();
	}

	public boolean insertParameters(ParametersDTO parametersDTO) {
		return this.parametersDAO.insertParameters(ConverterParameteres.toEntity(parametersDTO));
	}
	
	public ParametersDTO readParameters(int idParameters) {
		return ConverterParameteres.toDTO(this.parametersDAO.readParameters(idParameters));
	}
	
	public boolean updateParameters(ParametersDTO parametersDTO) {
		return this.parametersDAO.updateparameters(ConverterParameteres.toEntity(parametersDTO));
	}
	
	public boolean deleteParameters(int idParameters) {
		return this.parametersDAO.deleteParameters(idParameters);
	}
	
	
}
