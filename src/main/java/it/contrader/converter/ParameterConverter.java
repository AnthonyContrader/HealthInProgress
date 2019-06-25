 package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ParameterDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Parameter;
import it.contrader.model.User;
import it.contrader.*;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class ParameterConverter extends AbstractConverter<Parameter,ParameterDTO> {

	@Override
	public Parameter toEntity(ParameterDTO parameterDTO) {
		Parameter parameter = null;
		if (parameterDTO != null) {
			parameter = new Parameter(parameterDTO.getId(),parameterDTO.getSesso(),parameterDTO.getAltezza(),parameterDTO.getPeso(),parameterDTO.getTotKcal());			
		}
		return parameter;
	}

	@Override
	public ParameterDTO toDTO(Parameter parameter) {
		ParameterDTO parameterDTO = null;
		if (parameter != null) {
			parameterDTO = new ParameterDTO(parameter.getId(),parameter.getSesso(),parameter.getAltezza(),parameter.getPeso(),parameter.getTotKcal());
			
		}
		return parameterDTO;
	}
}