package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.MealDTO;

import it.contrader.model.Meal;
import it.contrader.*;


@Component
public class MealConverter extends AbstractConverter<Meal,MealDTO> {

	@Override
	public Meal toEntity(MealDTO mealDTO) {
		Meal meal = null;
		if (mealDTO != null) {
			meal = new Meal(mealDTO.getId(),mealDTO.getTipo(),mealDTO.getNome(),mealDTO.getKcal());			
		}
		return meal;
	}

	@Override
	public MealDTO toDTO(Meal meal) {
		MealDTO mealDTO = null;
		if (meal != null) {
			mealDTO = new MealDTO(meal.getId(),meal.getKcal(),meal.getNome(),meal.getTipo());
			
		}
		return mealDTO;
	}
}
