 
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
		
			parameter.setIdParameter(parameter.getIdParameter());
			parameter.setSesso(parameter.getSesso());
			parameter.setAltezza(parameter.getPeso());
			parameter.setEta(parameter.getEta());
			parameter.setTotKacl(parameter.getTotKacl());
			parameterDTO.setUserDTO(ConverterUser.toDTO(parameter.getUser()));
		

		}
		return parameterDTO;
	}

	public static Parameter toEntity(ParameterDTO parameterDTO) {
		Parameter parameter = null;
		if (parameterDTO != null) {
			parameter = new Parameter();
			parameter.setIdParameter(parameterDTO.getIdParameter());
			parameter.setUser(ConverterUser.toEntity(parameterDTO.getUserDTO()));
			parameter.setSesso(parameterDTO.getSesso());
			parameter.setAltezza(parameterDTO.getAltezza());
			parameter.setPeso(parameterDTO.getPeso());
			parameter.setTotKacl(parameterDTO.getTotKcal());

			
	
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