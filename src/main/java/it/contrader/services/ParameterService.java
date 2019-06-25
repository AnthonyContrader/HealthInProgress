 package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterParameter;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.ParameterRepository;
import it.contrader.dto.ParameterDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Parameter;
import it.contrader.model.User;

@Service
public class ParameterService {

	private final ParameterRepository parameterRepository;
	
	@Autowired

	public ParameterService(ParameterRepository parameterRepository) {
		this.parameterRepository = parameterRepository;
	}
	
	public List<ParameterDTO> getListaParameterDTO(){
	//	List <Parameter> prova= parameterRepository.findAll();
		return ConverterParameter.toListDTO((List<Parameter>) parameterRepository.findAll());
		
	}
	
	public ParameterDTO getParameterDTOById(Integer id) {
		return ConverterParameter.toDTO(parameterRepository.findById(id).get());
		
	}

	
	public boolean insertParameter(ParameterDTO parameterDTO) {
		return parameterRepository.save(ConverterParameter.toEntity(parameterDTO)) != null;
	}
	
	public boolean updateParameter(ParameterDTO parameterDTO) {
		return parameterRepository.save(ConverterParameter.toEntity(parameterDTO)) != null;
	}
	
	public void deleteParameterById(Integer id) {
		parameterRepository.deleteById(id);
	}

	
	public List<ParameterDTO> findParameterDTOByUser( UserDTO userDTO) {
		
		final List<Parameter> listParameter = parameterRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<ParameterDTO> listParameterDTO = new ArrayList<>();
		listParameter.forEach(i -> listParameterDTO.add(ConverterParameter.toDTO(i)));
		return listParameterDTO;
	}
}