package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dvx.error.Mensajes;

public class SesionSqlite {
	/**
	 * El driver específico para manipular BD's con SQLite
	 */
	private static String driver = "org.sqlite.JDBC";
	
	/**
	 * Ubicación de la BD
	 */
	private static String url = "bd/wakeupbrain.sqlite";
	
	/**
	 * Prefijo para saber el tipo de BD
	 */
	private static String url_prefix = "jdbc:sqlite:";
	
	/**
	 * Objeto que encapsula la conexión
	 */
	private Connection con = null;
	
	/**
	 * Establece la conexión a base de datos
	 * @return True si la conexión se realiza correctamente, False en caso contrario
	 */
	public boolean conectar()	{
		boolean exito = false;
		try	{
			if(null == this.con || con.isClosed())	{
				// Cargar driver
				Class.forName(SesionSqlite.driver);
				// Conexión
				this.con = DriverManager.getConnection(SesionSqlite.url_prefix + SesionSqlite.url);
			}
			exito = true;
		}catch(SQLException ex)	{
			Mensajes.mostrarError(ex.getMessage(), "Conectar");
		}catch(ClassNotFoundException ex)	{
			Mensajes.mostrarError(ex.getMessage(), "Conectar");
		}
		return exito;
	}
	
	/**
	 * Cierra la conexión con la BD
	 * @return True si no hubo error al desconectar, False en caso contrario
	 */
	public boolean desconectar()	{
		boolean exito = false;
		try	{
			if(con != null && !con.isClosed())	{
				con.close();
				exito = true;
			}
		}catch(SQLException ex)	{
			Mensajes.mostrarError(ex.getMessage(), "Desconectar");
		}
		return exito;
	}
	
	/**
	 * Recuperar la conexión a BD
	 * @return
	 */
	public Connection getConexion()	{
		return this.con;
	}
}
