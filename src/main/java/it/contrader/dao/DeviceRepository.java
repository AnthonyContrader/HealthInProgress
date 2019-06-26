
package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Device;
import it.contrader.model.Ingredient;
import it.contrader.model.User;

public interface DeviceRepository extends CrudRepository<Device, Integer> {

	//public List<Device> findAllByUser(User user);
	Device findById(long id);
}