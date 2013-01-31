package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dvx.error.Mensajes;

public class SesionSqlite {
	/**
	 * El driver espec�fico para manipular BD's con SQLite
	 */
	private static String driver = "org.sqlite.JDBC";
	
	/**
	 * Ubicaci�n de la BD
	 */
	private static String url = "bd/wakeupbrain.sqlite";
	
	/**
	 * Prefijo para saber el tipo de BD
	 */
	private static String url_prefix = "jdbc:sqlite:";
	
	/**
	 * Objeto que encapsula la conexi�n
	 */
	private Connection con = null;
	
	/**
	 * Establece la conexi�n a base de datos
	 * @return True si la conexi�n se realiza correctamente, False en caso contrario
	 */
	public boolean conectar()	{
		boolean exito = false;
		try	{
			if(null == this.con || con.isClosed())	{
				// Cargar driver
				Class.forName(SesionSqlite.driver);
				// Conexi�n
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
	 * Cierra la conexi�n con la BD
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
	 * Recuperar la conexi�n a BD
	 * @return
	 */
	public Connection getConexion()	{
		return this.con;
	}
}
