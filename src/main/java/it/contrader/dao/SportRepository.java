
package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Sport;
import it.contrader.model.User;

public interface SportRepository extends CrudRepository<Sport, Integer> {

	public List<Sport> findAllByUser(User user);
}