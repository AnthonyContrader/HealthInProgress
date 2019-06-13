package it.contrader.converter;

import it.contrader.dto.DeviceDTO;
import it.contrader.model.Device;

/**
 * Il converter si occupa di "convertire" un model in un dto e viceversa
 *
 */
public class DeviceConverter {

	/**
	 * Converte un NodesDTO in Nodes
	 */
	public static Device toEntity(DeviceDTO deviceDTO) {

		Device device = null;
		if (deviceDTO != null) {
			device = new Device(deviceDTO.getNome());

			if (deviceDTO.getIddevice() != 0)
				device.setIddevice(deviceDTO.getIddevice());
		}
		
		
		return device;
	}

	/**
	 * Converte un Nodes in NodesDTO
	 */

	public static DeviceDTO toDTO(Device device) {

		DeviceDTO deviceDTO = null;
		if (device != null) {
			deviceDTO = new DeviceDTO(device.getNome());
			deviceDTO.setIddevice(device.getIddevice());
		}

		return deviceDTO;
	}

}
