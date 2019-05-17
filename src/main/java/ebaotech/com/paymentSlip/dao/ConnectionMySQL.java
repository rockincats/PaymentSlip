package ebaotech.com.paymentSlip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

	public static String status = "Não conectou...";

	public ConnectionMySQL() {

	}

	public static java.sql.Connection getConnectionMySQL() {

		Connection connection = null;

		try {

			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost";
			String mydatabase = "ebao";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";
			String password = "denil123";
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				status = "STATUS--->Conectado com sucesso!";
			} else {
				status = "STATUS--->Não foi possivel realizar conexão";
			}

			return connection;

		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}

	public static String statusConnection() {
		return status;
	}

	public static boolean closeConnection() {
		try {
			ConnectionMySQL.getConnectionMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static java.sql.Connection restartConnection() {
		closeConnection();
		return ConnectionMySQL.getConnectionMySQL();
	}
}