package it.contrader.converter;

import java.util.ArrayList;

import java.util.List;

import it.contrader.dto.ParametersDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Parameters;
import it.contrader.model.User;

public class ConverterParameteres {

	public static ParametersDTO toDTO(Parameters parameters) {
		ParametersDTO parametersDTO = null;
		if (parameters != null) {
			parametersDTO = new ParametersDTO(parameters.getSesso(), parameters.getAltezza(), parameters.getPeso(),
					parameters.getEta(), parameters.getPolso(), parameters.getFreqResp(), parameters.getTempCorp());
			parametersDTO.setIdParameter(parameters.getIdParameter());
			parametersDTO.setSesso(parameters.getSesso());
			parametersDTO.setAltezza(parameters.getAltezza());
			parametersDTO.setPeso(parameters.getPeso());
			parametersDTO.setEta(parameters.getEta());
			parametersDTO.setPolso(parameters.getPolso());
			parametersDTO.setFreqResp(parameters.getFreqResp());
			parametersDTO.setTempCorp(parameters.getTempCorp());

		}
		return parametersDTO;
	}

	public static Parameters toEntity(ParametersDTO parametersDTO) {
		Parameters parameters = null;
		if (parametersDTO != null) {
			parameters = new Parameters();
			parameters.setIdParameter(parametersDTO.getIdParameter());

			parameters.setSesso(parametersDTO.getSesso());

			parameters.setAltezza(parametersDTO.getAltezza());
			parameters.setPeso(parametersDTO.getPeso());
			parameters.setEta(parametersDTO.getEta());
			parameters.setPolso(parametersDTO.getPolso());
			parameters.setFreqResp(parametersDTO.getFreqResp());
			parameters.setTempCorp(parametersDTO.getTempCorp());

		}
		return parameters;
	}

	public static List<ParametersDTO> toListDTO(List<Parameters> list) {
		List<ParametersDTO> listParametersDTO = new ArrayList<>();

		if (!list.isEmpty()) {
			for (Parameters parameters : list) {
				listParametersDTO.add(ConverterParameteres.toDTO(parameters));
			}
		}
		return listParametersDTO;
	}

	public static List<Parameters> toListEntity(List<ParametersDTO> listParameteresDTO) {
		List<Parameters> list = new ArrayList<>();
		if (!listParameteresDTO.isEmpty()) {
			for (ParametersDTO parametersDTO : listParameteresDTO) {
				list.add(ConverterParameteres.toEntity(parametersDTO));
			}
		}
		return list;
	}
}
