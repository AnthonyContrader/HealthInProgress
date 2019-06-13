package it.contrader.converter;

import java.util.ArrayList;

import java.util.List;

import it.contrader.dto.ParametersDTO;
import it.contrader.model.Parameters;



public class ConverterParameteres {

	public static Parameters toEntity(ParametersDTO parametersDTO) {



		Parameters parameters= null;

		if (parametersDTO != null) {

			parameters = new Parameters(parametersDTO.getSesso(),parametersDTO.getAltezza(),parametersDTO.getPeso(),parametersDTO.getEta(),parametersDTO.getPolso(),parametersDTO.getFreqResp(),parametersDTO.getTempCorp());

			if (parametersDTO.getIdParameter() != 0)

			parameters.setIdParameter(parametersDTO.getIdParameter());

		}
		

		

		return parameters;

	}



	/**

	 * Converte un Nodes in NodesDTO

	 */



	public static ParametersDTO toDTO(Parameters parameters) {



		ParametersDTO parametersDTO= null ;

		if (parameters != null) {

			parametersDTO = new ParametersDTO(parameters.getSesso(),parameters.getAltezza(),parameters.getPeso(),parameters.getEta(),parameters.getPolso(),parameters.getFreqResp(),parameters.getTempCorp());

			parametersDTO.setIdParameter(parameters.getIdParameter());

			// userDTO.setId(user.getUserId());

		}



		return parametersDTO;

	}
}