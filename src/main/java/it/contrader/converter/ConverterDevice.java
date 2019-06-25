 
package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DeviceDTO;
import it.contrader.dao.SportRepository;
import it.contrader.model.Device;

public class ConverterDevice {

	public static DeviceDTO toDTO(Device device) {
		DeviceDTO deviceDTO = null;
		if (device != null) {
			deviceDTO = new DeviceDTO();
		
			deviceDTO.setId(device.getId());
			deviceDTO.setNome(device.getNome());
			deviceDTO.setUserDTO(ConverterUser.toDTO(device.getUser()));
		

		}
		return deviceDTO;
	}

	public static Device toEntity(DeviceDTO deviceDTO) {
		Device device = null;
		if (deviceDTO != null) {
			device = new Device();
			device.setId(deviceDTO.getId());
			device.setUser(ConverterUser.toEntity(deviceDTO.getUserDTO()));
			device.setNome(deviceDTO.getNome());


			
	
		}
		return device;
	}

	public static List<DeviceDTO> toListDTO(List<Device> list) {
		List<DeviceDTO> listDeviceDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Device device : list) {
				listDeviceDTO.add(ConverterDevice.toDTO(device));
			}
		}
		return listDeviceDTO;
	}

	public static List<Device> toListEntity(List<DeviceDTO> listDeviceDTO) {
		List<Device> list = new ArrayList<>();
		if (!listDeviceDTO.isEmpty()) {
			for (DeviceDTO deviceDTO : listDeviceDTO) {
				list.add(ConverterDevice.toEntity(deviceDTO));
			}
		}
		return list;
	}

}