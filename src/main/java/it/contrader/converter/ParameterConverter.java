package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ParameterDTO;

import it.contrader.model.Parameter;

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
		Parameter parameter= null;
		if (parameterDTO != null) {
			parameter= new Parameter(parameterDTO.getId(),parameterDTO.getSesso(),parameterDTO.getAltezza(),parameterDTO.getPeso(),parameterDTO.getEta(),parameterDTO.getTotkcal());			
		}
		return parameter;
	}

	@Override
	public ParameterDTO toDTO(Parameter parameter) {
		ParameterDTO parameterDTO = null;
		if (parameter != null) {
			parameterDTO = new ParameterDTO(parameter.getId(),parameter.getSesso(),parameter.getAltezza(),parameter.getPeso(),parameter.getEta(),parameter.getTotkcal());
			
		}
		return parameterDTO;
	}
}