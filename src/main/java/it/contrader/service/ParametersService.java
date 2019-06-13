package it.contrader.service;

import java.util.ArrayList;
import java.util.List;
import it.contrader.converter.ConverterParameteres;
import it.contrader.dao.ParametersDAO;
import it.contrader.dto.ParametersDTO;
import it.contrader.model.Parameters;

public class ParametersService {

	private ParametersDAO parametersDAO;

	public ParametersService() {
		this.parametersDAO = new ParametersDAO();
	}

	public List<ParametersDTO> getAllParameters()  {



		List<Parameters> list = parametersDAO.getAllParameters();

		List<ParametersDTO> listDTO = new ArrayList<>();



		for (Parameters parameters : list) {

			listDTO.add(ConverterParameteres.toDTO(parameters));
		}
		return listDTO;

	}
	public boolean insertParameters(ParametersDTO parametersDTO) {
		return this.parametersDAO.insertParameters(ConverterParameteres.toEntity(parametersDTO));
	}
	
	public ParametersDTO readParameters(ParametersDTO parametersDTO) {
		return ConverterParameteres.toDTO(this.parametersDAO.readParameters(ConverterParameteres.toEntity(parametersDTO)));
		
	}
	
	public boolean updateParameters(ParametersDTO parametersDTO) {
		return this.parametersDAO.updateParameters(ConverterParameteres.toEntity(parametersDTO));
	}
	
	public boolean deleteParameters(ParametersDTO parametersdelete) {
		return this.parametersDAO.deleteParameters(ConverterParameteres.toEntity(parametersdelete));
	}
	
	
}
