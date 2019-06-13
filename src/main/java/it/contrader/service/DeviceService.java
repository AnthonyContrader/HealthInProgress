package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.DeviceConverter;
import it.contrader.converter.ConverterMeal;
import it.contrader.dao.DeviceDAO;
import it.contrader.dao.MealDAO;
import it.contrader.dto.DeviceDTO;
import it.contrader.dto.MealDTO;
import it.contrader.model.Device;

public class DeviceService {
	
	private DeviceDAO deviceDAO;
	
	public DeviceService() {
		this.deviceDAO = new DeviceDAO();
	}

	
	public List<DeviceDTO> getAllDevices() {

		List<Device> list = deviceDAO.getAllDevice();
		List<DeviceDTO> listDTO = new ArrayList<>();

		for (Device device : list) {
			listDTO.add(DeviceConverter.toDTO(device));
		}

		return listDTO;
	}
	

	public DeviceDTO readDevice(DeviceDTO deviceDTO) {
		return DeviceConverter.toDTO(this.deviceDAO.readDevice(DeviceConverter.toEntity(deviceDTO)));
	}
	
	public boolean updateDevice(DeviceDTO deviceDTO) {
		return this.deviceDAO.updateDevice(DeviceConverter.toEntity(deviceDTO));
		
}
	
	public boolean deleteDevices (DeviceDTO deviceDTO) {
		return this.deviceDAO.deleteDevice(DeviceConverter.toEntity(deviceDTO));
		
}
	
	public boolean insertDevices (DeviceDTO devicesDTO) {
		return this.deviceDAO.insertDevice(DeviceConverter.toEntity(devicesDTO));
	
}
	
	
}
	
