package br.com.rafaelsonego.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection;
	private static String pathDataDase = "C:\\Users\\rafae\\OneDrive\\Documentos\\GitHub\\MockitoJUnit\\mockitoJunit\\src\\main\\resources\\db\\database\\databaseTest";
	private static String URL = "jdbc:hsqldb:file:" + pathDataDase;
	private static String user = "SA";
	private static String password = "";
	
	public static Connection getConnection() {
        try {
        	if(connection == null || connection.isClosed()){
        		connection = DriverManager.getConnection(URL, user, password);	
        	}
        	return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
