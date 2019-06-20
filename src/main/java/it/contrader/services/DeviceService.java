package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDevice;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.DeviceRepository;
import it.contrader.dto.DeviceDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Device;
import it.contrader.model.User;

@Service
public class DeviceService {

	private final DeviceRepository deviceRepository;

	@Autowired

	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<DeviceDTO> getListaDeviceDTO() {
		return ConverterDevice.toListDTO((List<Device>) deviceRepository.findAll());

	}

	public DeviceDTO getDeviceDTOById(Integer id) {
		return ConverterDevice.toDTO(deviceRepository.findById(id).get());
	}

	public boolean insertDevice(DeviceDTO deviceDTO) {
		return deviceRepository.save(ConverterDevice.toEntity(deviceDTO)) != null;
	}

	public boolean updateDevice(DeviceDTO deviceDTO) {
		return deviceRepository.save(ConverterDevice.toEntity(deviceDTO)) != null;
	}

	public void deleteDeviceById(Integer id) {
		deviceRepository.deleteById(id);
	}

	public List<DeviceDTO> findDeviceDTOByUser(UserDTO userDTO) {

		final List<Device> listDevice = deviceRepository.findAllByUser(ConverterUser.toEntity(userDTO));
		final List<DeviceDTO> listDeviceDTO = new ArrayList<>();
		listDevice.forEach(i -> listDeviceDTO.add(ConverterDevice.toDTO(i)));
		return listDeviceDTO;
	}
}