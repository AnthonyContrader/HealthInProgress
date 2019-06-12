package it.contrader.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.fabric.xmlrpc.base.Array;


import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;


public class LoginDAO {

    private final String QUERY_LOGIN = "select * from user where nome = ? and password = ?";
    
    /**
     * 
     * @param username
     * @param password
     * @return the type of user of null if nothing is found
     */
    public String login (String nome, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, nome);
            statement.setString(2, password);
            String tipo=null;
            ResultSet rs;
            if(statement.executeQuery().next()) {
            	rs = statement.executeQuery();
            	rs.next();
            	tipo = rs.getString("tipo");
            }
            
            return tipo;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }
}
