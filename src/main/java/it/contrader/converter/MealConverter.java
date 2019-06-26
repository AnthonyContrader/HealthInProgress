package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.MealDTO;

import it.contrader.model.Meal;
/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class MealConverter extends AbstractConverter<Meal,MealDTO> {

	@Override
	public Meal toEntity(MealDTO mealDTO) {
		Meal meal = null;
		if (mealDTO != null) {
			meal = new Meal(mealDTO.getId(),mealDTO.getNome(),mealDTO.getTipo(),mealDTO.getKcal());			
		}
		return meal;
	}

	@Override
	public MealDTO toDTO(Meal meal) {
		MealDTO mealDTO = null;
		if (meal != null) {
			mealDTO = new MealDTO(meal.getId(),meal.getNome(),meal.getTipo(),meal.getKcal());
			
		}
		return mealDTO;
	}
}