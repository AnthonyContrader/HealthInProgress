package it.contrader.service;

import java.util.List;
import it.contrader.converter.ConverterParameteres;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.ParametersDAO;
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
	
	public ParametersDTO readParameters(ParametersDTO parametersUpdate) {
		return ConverterParameteres.toDTO(this.parametersDAO.readParameters(ConverterParameteres.toEntity(parametersUpdate)));
	}
	
	public boolean updateParameters(ParametersDTO parametersDTO) {
		return this.parametersDAO.updateParameters(ConverterParameteres.toEntity(parametersDTO));
	}
	
	public boolean deleteParameters(ParametersDTO parametersdelete) {
		return this.parametersDAO.deleteParameters(ConverterParameteres.toEntity(parametersdelete));
	}
	
	
}
