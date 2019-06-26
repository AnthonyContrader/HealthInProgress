package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DeviceDTO;

import it.contrader.model.Device;

/**
 * Questa classe implementa i metodi di conversione dell'entità User.
 *  
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see AbstractConverter
 *@see Converter
 */
@Component
public class DeviceConverter extends AbstractConverter<Device,DeviceDTO> {

	@Override
	public Device toEntity(DeviceDTO deviceDTO) {
		Device device = null;
		if (deviceDTO != null) {
			device = new Device(deviceDTO.getId(),deviceDTO.getNome());			
		}
		return device;
	}

	@Override
	public DeviceDTO toDTO(Device device) {
		DeviceDTO deviceDTO = null;
		if (device != null) {
			deviceDTO = new DeviceDTO(device.getId(),device.getNome());
			
		}
		return deviceDTO;
	}
}