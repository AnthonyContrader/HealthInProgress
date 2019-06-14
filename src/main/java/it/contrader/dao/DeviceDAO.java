package it.contrader.dao;

import it.contrader.model.Device;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAO {

	private final String QUERY_ALL = "select * from device";
	private final String QUERY_INSERT = "insert into device (nome) value (?)";
	private final String QUERY_READ = "select * from device where Iddevice=?";

	private final String QUERY_UPDATE = "UPDATE device SET nome=? WHERE Iddevice=?";
	private final String QUERY_DELETE = "delete from device where Iddevice=?";
	public DeviceDAO() {

	}

	public List<Device> getAllDevice() {
		List<Device> devicesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Device device;
			while (resultSet.next()) {
				int Iddevice = resultSet.getInt("Iddevice");
				String nome = resultSet.getString("nome");
				
				device = new Device(nome);
				device.setIddevice(Iddevice);
				devicesList.add(device);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devicesList;
	}

	public boolean insertDevice(Device device) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, device.getNome());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Device readDevice(Device device) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int Iddevice = device.getIddevice(); 
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, Iddevice);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String nome;
			
			Iddevice= resultSet.getInt("Iddevice"); 
			nome = resultSet.getString("nome");
			
			device = new Device(nome);
			device.setIddevice(Iddevice);
			device.setIddevice(resultSet.getInt("Iddevice"));

			return device;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateDevice(Device deviceToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (deviceToUpdate.getIddevice() == 0)
			return false;

		// User userRead = readUser(userToUpdate);
		// if (!userRead.equals(userToUpdate)) {
		try {
			// Fill the userToUpdate object
			/*
			if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
			 
				userToUpdate.setUser(userRead.getUsername());
			}
			if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) {
				userToUpdate.setPassword(userRead.getPassword());
			}
			if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
				userToUpdate.setUsertype(userRead.getUsertype());
			}
			
			*/
			// Update the user
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, deviceToUpdate.getNome());
			preparedStatement.setInt(2, deviceToUpdate.getIddevice());
			
			
			int a = preparedStatement.executeUpdate();
			if (a > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			return false;
		}
		//}

		//return false;

	}

	public boolean deleteDevice(Device device) {
		int Iddevice = device.getIddevice(); 
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, Iddevice);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}


}