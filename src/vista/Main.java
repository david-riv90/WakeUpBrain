package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * En esta clase se encuentran todos los métodos que permiten la inicialización de la aplicación
 * @author Davex
 *
 */
public class Main {

	/**
	 * El método de entrada al programa
	 * @param args Contiene argumentos de inicialización
	 */
	public static void main(String[] args) {
		Login l = new Login();
		l.setVisible(true);
		
		
//		AgregarNiño v1 = new AgregarNiño();
//		v1.setVisible(true);
//		
//		PerfilNiño v2 = new PerfilNiño();
//		v2.setVisible(true);
		
		// <I> Código correcto conexión
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
//			// TODO Bloc catch généré automatiquement
//			e.printStackTrace();
//		}
	}

}
