 
package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ParameterDTO;
import it.contrader.dao.ParameterRepository;
import it.contrader.model.Parameter;

public class ConverterParameter {

	public static ParameterDTO toDTO(Parameter parameter) {
		ParameterDTO parameterDTO = null;
		if (parameter != null) {
			parameterDTO = new ParameterDTO();
		
			parameterDTO.setId(parameter.getId());
			parameterDTO.setSesso(parameter.getSesso());
			parameterDTO.setAltezza(parameter.getAltezza());
			parameterDTO.setPeso(parameter.getPeso());
			parameterDTO.setEta(parameter.getEta());
			
			parameterDTO.setTotKcal(parameter.getTotKcal());
			parameterDTO.setUserDTO(ConverterUser.toDTO(parameter.getUser()));
		

		}
		return parameterDTO;
	}

	public static Parameter toEntity(ParameterDTO parameterDTO) {
		Parameter parameter = null;
		if (parameterDTO != null) {
			parameter = new Parameter();
			parameter.setId(parameterDTO.getId());
			parameter.setUser(ConverterUser.toEntity(parameterDTO.getUserDTO()));
			parameter.setSesso(parameterDTO.getSesso());
			parameter.setAltezza(parameterDTO.getAltezza());
			parameter.setEta(parameterDTO.getEta());
			parameter.setPeso(parameterDTO.getPeso());
			parameter.setTotKcal(parameterDTO.getTotKcal());

			
	
		}
		return parameter;
	}

	public static List<ParameterDTO> toListDTO(List<Parameter> list) {
		List<ParameterDTO> listParameterDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Parameter parameter : list) {
				listParameterDTO.add(ConverterParameter.toDTO(parameter));
			}
		}
		return listParameterDTO;
	}

	public static List<Parameter> toListEntity(List<ParameterDTO> listParameterDTO) {
		List<Parameter> list = new ArrayList<>();
		if (!listParameterDTO.isEmpty()) {
			for (ParameterDTO parameterDTO : listParameterDTO) {
				list.add(ConverterParameter.toEntity(parameterDTO));
			}
		}
		return list;
	}

}