package it.contrader.converter;

import java.util.ArrayList;

import java.util.List;

import it.contrader.dto.ParametersDTO;
import it.contrader.model.Parameters;

public class ConverterParameteres {

	public static ParametersDTO toDTO(Parameters parameters) {
		ParametersDTO parametersDTO = null;
		if (parameters != null) {
			parametersDTO = new ParametersDTO();
			parametersDTO.setIdParameter(parameters.getIdParameter());;
			parametersDTO.setNome(parameters.getNome());
			parametersDTO.setSesso(parameters.getSesso());
			parametersDTO.setDispositivo(parameters.getDispositivo());
			parametersDTO.setAltezza(parameters.getAltezza());
			parametersDTO.setPeso(parameters.getPeso());
			parametersDTO.setEta(parameters.getEta());
			parametersDTO.setPolso(parameters.getPolso());
			parametersDTO.setFreqResp(parameters.getFreqResp());
			parametersDTO.setTempCorp(parameters.getTempCorp());
			parametersDTO.setOssSang(parameters.getOssSang());
		}
		return parametersDTO;
	}

	public static Parameters toEntity(ParametersDTO parametersDTO) {
		Parameters parameters = null;
		if (parametersDTO != null) {
			parameters = new Parameters();
			parameters.setIdParameter(parametersDTO.getIdParameter());
			parameters.setNome(parametersDTO.getNome());
			parameters.setSesso(parametersDTO.getSesso());
			parameters.setDispositivo(parametersDTO.getDispositivo());
			parameters.setAltezza(parametersDTO.getAltezza());
			parameters.setPeso(parametersDTO.getPeso());
			parameters.setEta(parametersDTO.getEta());
			parameters.setPolso(parametersDTO.getEta());
			parameters.setFreqResp(parametersDTO.getFreqResp());
			parameters.setTempCorp(parametersDTO.getTempCorp());
			parameters.setOssSang(parametersDTO.getOssSang());
			
		}
		return parameters;
	}

	public static List<ParametersDTO> toListDTO(List<Parameters> list) {
		List<ParametersDTO> listparametersDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Parameters parameters : list) {
				listparametersDTO.add(ConverterParameteres.toDTO(parameters));
			}
		}
		return listparametersDTO;
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
