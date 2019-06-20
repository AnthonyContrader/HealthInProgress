 
package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SportDTO;
import it.contrader.dao.SportRepository;
import it.contrader.model.Sport;

public class ConverterSport {

	public static SportDTO toDTO(Sport sport) {
		SportDTO sportDTO = null;
		if (sport != null) {
			sportDTO = new SportDTO();
		
			sport.setIdSport(sport.getIdSport());
			sportDTO.setNome(sport.getNome());
			sportDTO.setDurata(sport.getDurata());
			sportDTO.setTipo(sport.getTipo());
			sportDTO.setUserDTO(ConverterUser.toDTO(sport.getUser()));
		

		}
		return sportDTO;
	}

	public static Sport toEntity(SportDTO sportDTO) {
		Sport sport = null;
		if (sportDTO != null) {
			sport = new Sport();
			sport.setIdSport(sportDTO.getIdSport());
			sport.setUser(ConverterUser.toEntity(sportDTO.getUserDTO()));
			sport.setNome(sportDTO.getNome());
			sport.setDurata(sportDTO.getDurata());
			sport.setTipo(sportDTO.getTipo());

			
	
		}
		return sport;
	}

	public static List<SportDTO> toListDTO(List<Sport> list) {
		List<SportDTO> listSportDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Sport sport : list) {
				listSportDTO.add(ConverterSport.toDTO(sport));
			}
		}
		return listSportDTO;
	}

	public static List<Sport> toListEntity(List<SportDTO> listSportDTO) {
		List<Sport> list = new ArrayList<>();
		if (!listSportDTO.isEmpty()) {
			for (SportDTO sportDTO : listSportDTO) {
				list.add(ConverterSport.toEntity(sportDTO));
			}
		}
		return list;
	}

}