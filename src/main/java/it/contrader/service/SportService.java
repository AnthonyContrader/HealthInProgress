package it.contrader.service;





import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterSport;
import it.contrader.dao.SportDAO;
import it.contrader.dto.SportDTO;
import it.contrader.model.Sport;


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

			listDTO.add(ConverterSport.toDTO(sport));

		}



		return listDTO;

	}

	

	public SportDTO readSport(SportDTO sportDTO) {

		return ConverterSport.toDTO(this.sportDAO.readSport(ConverterSport.toEntity(sportDTO)));

	}

	

	public boolean updateSport(SportDTO sportDTO) {

		return this.sportDAO.updateSport(ConverterSport.toEntity(sportDTO));

		

}

	

	public boolean deleteSport(SportDTO sportDTO) {

		return this.sportDAO.deleteSport(ConverterSport.toEntity(sportDTO));

		

}

	

	public boolean insertSport (SportDTO sportDTO) {

		return this.sportDAO.insertSport(ConverterSport.toEntity(sportDTO));

	}




}