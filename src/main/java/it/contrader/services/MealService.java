package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterMeal;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.MealRepository;
import it.contrader.dto.MealDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Meal;
import it.contrader.model.User;

@Service
public class MealService {

	private final MealRepository mealRepository;
	
	@Autowired

	public MealService(MealRepository mealRepository) {
		this.mealRepository = mealRepository;
	}
	
	public List<MealDTO> getListaMealDTO(){
		return ConverterMeal.toListDTO((List<Meal>) mealRepository.findAll());
		
	}
	
	public MealDTO getMealDTOById(Integer id) {
		return ConverterMeal.toDTO(mealRepository.findById(id).get());
	}

	
	public boolean insertMeal(MealDTO mealDTO) {
		return mealRepository.save(ConverterMeal.toEntity(mealDTO)) != null;
	}
	
	public boolean updateMeal(MealDTO mealDTO) {
		return mealRepository.save(ConverterMeal.toEntity(mealDTO)) != null;
	}
	
	public void deleteMealById(Integer id) {
		mealRepository.deleteById(id);
	}

	
	public List<MealDTO> findMealDTOByUser( UserDTO userDTO) {
		
		final List<Meal> listMeal = mealRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<MealDTO> listMealDTO = new ArrayList<>();
		listMeal.forEach(i -> listMealDTO.add(ConverterMeal.toDTO(i)));
		return listMealDTO;
	}
}