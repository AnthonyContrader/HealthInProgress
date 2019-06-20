package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterSport;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.SportRepository;
import it.contrader.dto.SportDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Sport;
import it.contrader.model.User;

@Service
public class SportService {

	private final SportRepository sportRepository;
	
	@Autowired

	public SportService(SportRepository sportRepository) {
		this.sportRepository = sportRepository;
	}
	
	public List<SportDTO> getListaSportDTO(){
		return ConverterSport.toListDTO((List<Sport>) sportRepository.findAll());
		
	}
	
	public SportDTO getSportDTOById(Integer id) {
		return ConverterSport.toDTO(sportRepository.findById(id).get());
	}

	
	public boolean insertClient(SportDTO sportDTO) {
		return sportRepository.save(ConverterSport.toEntity(sportDTO)) != null;
	}
	
	public boolean updateSport(SportDTO sportDTO) {
		return sportRepository.save(ConverterSport.toEntity(sportDTO)) != null;
	}
	
	public void deleteSportById(Integer id) {
		sportRepository.deleteById(id);
	}
	
	public List<SportDTO> findSportDTOByUser( UserDTO userDTO) {
		
		final List<Sport> listSport = sportRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<SportDTO> listSportDTO = new ArrayList<>();
		listSport.forEach(i -> listSportDTO.add(ConverterSport.toDTO(i)));
		return listSportDTO;
	}
}