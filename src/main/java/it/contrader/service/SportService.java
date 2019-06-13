package it.contrader.service;


import java.util.ArrayList;
import java.util.*;

import it.contrader.converter.SportConverter;
import it.contrader.dao.SportDAO;
import it.contrader.dto.SportDTO;
import it.contrader.model.Sport;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class SportService {

	private final SportDAO sportDAO;

	public SportService() {
		this.sportDAO = new SportDAO();
	}

	/**
	 * Come vediamo la lista recuperata � di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perch� � sporco e poco efficiente
	 */
	public List<SportDTO> getAllSports() {

		List<Sport> list = sportDAO.getAllSport();
		List<SportDTO> listDTO = new ArrayList<>();

		for (Sport sport : list) {
			listDTO.add(SportConverter.toDTO(sport));
		}

		return listDTO;
	}
	
	public SportDTO getSportByNomeAndTipoAndDurata(String nome, String tipo, Double durata) {
		return SportConverter.toDTO(sportDAO.login(nome, tipo, durata));
	}

	public SportDTO readSport(SportDTO sportDTO) {
		return SportConverter.toDTO(this.sportDAO.readSport(SportConverter.toEntity(sportDTO)));
	}
	
	public boolean updateSport(SportDTO sportDTO) {
		return this.sportDAO.updateSport(SportConverter.toEntity(sportDTO));
		
}
	
	public boolean deleteSports (SportDTO sportDTO) {
		return this.sportDAO.deleteSport(SportConverter.toEntity(sportDTO));
		
}
	
	public boolean insertSports (SportDTO sportsDTO) {
		return this.sportDAO.insertSport(SportConverter.toEntity(sportsDTO));
	
}
		
	
	
}