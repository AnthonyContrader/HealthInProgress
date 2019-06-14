package it.contrader.converter;



import it.contrader.dto.SportDTO;

import it.contrader.model.Sport;



/**

 * Il converter si occupa di "convertire" un model in un dto e viceversa

 *

 */

public class ConverterSport {



	/**

	 * Converte un NodesDTO in Nodes

	 */

	public static Sport toEntity(SportDTO sportDTO) {



		Sport sport= null;

		if (sportDTO != null) {
			sport = new Sport(sportDTO.getNome(),sportDTO.getDurata(),sportDTO.getTipo());

			if (sportDTO.getIdsport() != 0)

			sport.setIdsport(sportDTO.getIdsport());

		}
		

		

		return sport;

	}



	/**

	 * Converte un Nodes in NodesDTO

	 */



	public static SportDTO toDTO(Sport sport) {



		SportDTO sportDTO= null ;

		if (sport != null) {

			sportDTO = new SportDTO(sport.getNome(),  sport.getDurata(),sport.getTipo());

			sportDTO.setIdsport(sport.getIdsport());

			// userDTO.setId(user.getUserId());

		}



		return sportDTO;

	}



}