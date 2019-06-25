package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SportDTO;

import it.contrader.model.Sport;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class SportConverter extends AbstractConverter<Sport,SportDTO> {

	@Override
	public Sport toEntity(SportDTO sportDTO) {
		Sport sport = null;
		if (sportDTO != null) {
			sport = new Sport(sportDTO.getId(),sportDTO.getNome(),sportDTO.getTipo(),sportDTO.getDurata(),sportDTO.getCalorie());			
		}
		return sport;
	}

	@Override
	public SportDTO toDTO(Sport sport) {
		SportDTO sportDTO = null;
		if (sport != null) {
			sportDTO = new SportDTO(sport.getId(),sport.getNome(),sport.getTipo(),sport.getDurata(),sport.getCalorie());
			
		}
		return sportDTO;
	}
}