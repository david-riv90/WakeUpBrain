package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * En esta clase se encuentran todos los m�todos que permiten la inicializaci�n de la aplicaci�n
 * @author Davex
 *
 */
public class Main {

	/**
	 * El m�todo de entrada al programa
	 * @param args Contiene argumentos de inicializaci�n
	 */
	public static void main(String[] args) {
		Login l = new Login();
		l.setVisible(true);
		
		
//		AgregarNi�o v1 = new AgregarNi�o();
//		v1.setVisible(true);
//		
//		PerfilNi�o v2 = new PerfilNi�o();
//		v2.setVisible(true);
		
		// <I> C�digo correcto conexi�n
//		try {
//			Class.forName("org.sqlite.JDBC");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		Connection conexion = null;
//		try {
//			conexion = DriverManager.getConnection("jdbc:sqlite:bd/wakeupbrain.sqlite");
//			System.out.println("Base de datos encontrada");
//		} catch (SQLException e) {
//			// TODO Bloc catch g�n�r� automatiquement
//			e.printStackTrace();
//		}
	}

}
