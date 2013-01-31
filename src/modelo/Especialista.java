package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dvx.error.Mensajes;

public class Especialista {
	
	private String usuario;
	private String contrasenia;

	SesionSqlite sesion_sqlite = new SesionSqlite();
	Statement comando = null;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	/**
	 * Verifica la existencia en BD del usuario que intenta utilizar la aplicación
	 * @return True si el usuario existe, False en caso contrario
	 */
	public boolean login()	{
		boolean exito = false;
		String query = "SELECT COUNT(*) FROM especialista" +
					" WHERE usuario = '" + this.usuario + "' AND contrasenia = '" + this.contrasenia + "'";
		if(this.sesion_sqlite.conectar())	{
			try {
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				Mensajes.mostrarDebug(query);
				ResultSet rs = this.comando.executeQuery(query);
				rs.next();
				int n = rs.getInt(1);
				if(n == 1)	{
					exito = true;
				}
			} catch (SQLException e) {
				Mensajes.mostrarError(e.getMessage(), "login");
			}
		}
		return exito;
	}
}
