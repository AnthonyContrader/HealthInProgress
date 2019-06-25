
package it.contrader.dao;

import java.util.List;

import org.hibernate.ejb.HibernateQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;



import java.util.List;



import javax.transaction.Transactional;
import javax.websocket.Session;

import it.contrader.model.Meal;
import it.contrader.model.User;

public interface MealRepository extends CrudRepository<Meal, Integer> {

	public List<Meal> findAllByUser(User user);

	
	
}