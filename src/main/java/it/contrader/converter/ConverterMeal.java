 
package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MealDTO;
import it.contrader.dao.MealRepository;
import it.contrader.model.Meal;

public class ConverterMeal {

	public static MealDTO toDTO(Meal meal) {
		MealDTO mealDTO = null;
		if (meal != null) {
			mealDTO = new MealDTO();
		
			meal.setIdPiatto(meal.getIdPiatto());
			meal.setNome(meal.getNome());
			meal.setKcal(meal.getKcal());
			meal.setTipo(meal.getTipo());
			meal.setUser(ConverterUser.toEntity(mealDTO.getUserDTO()));
		

		}
		return mealDTO;
	}

	public static Meal toEntity(MealDTO mealDTO) {
		Meal meal = null;
		if (mealDTO != null) {
			meal = new Meal();
			meal.setIdPiatto(mealDTO.getIdPiatto());
			meal.setUser(ConverterUser.toEntity(mealDTO.getUserDTO()));
			meal.setNome(mealDTO.getNome());
			meal.setKcal(mealDTO.getKcal());
			meal.setTipo(mealDTO.getTipo());

			
	
		}
		return meal;
	}

	public static List<MealDTO> toListDTO(List<Meal> list) {
		List<MealDTO> listMealDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Meal meal : list) {
				listMealDTO.add(ConverterMeal.toDTO(meal));
			}
		}
		return listMealDTO;
	}

	public static List<Meal> toListEntity(List<MealDTO> listMealDTO) {
		List<Meal> list = new ArrayList<>();
		if (!listMealDTO.isEmpty()) {
			for (MealDTO mealDTO : listMealDTO) {
				list.add(ConverterMeal.toEntity(mealDTO));
			}
		}
		return list;
	}

}