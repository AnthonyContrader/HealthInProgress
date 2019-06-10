package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.MealDTO;
import it.contrader.model.Meal;

public class ConverterMeal {

	public static MealDTO toDTO(Meal meal) {
	     MealDTO mealDTO = null;
		if (meal != null) {
			mealDTO = new MealDTO(meal.getPiatto(), meal.getKcal());
			mealDTO.setIdpiatti(meal.getIdpiatti());
			mealDTO.setPiatto(meal.getPiatto());
			mealDTO.setKcal(meal.getKcal());
		
		}
		return mealDTO;
		

		
		
	}

	public static Meal toEntity(MealDTO mealDTO) {
		Meal meal = null;
		if (mealDTO != null) {
			meal = new Meal();
			meal.setIdpiatti(mealDTO.getIdpiatti());
			meal.setPiatto(mealDTO.getPiatto());
			meal.setKcal(mealDTO.getKcal());
			
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
