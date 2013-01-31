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
	
	public boolean login()	{
		boolean exito = false;
		String query = "SELECT COUNT(*) FROM especialista" +
					" WHERE usuario = '" + this.usuario + "' AND contrasenia = '" + this.contrasenia + "'";
		if(this.sesion_sqlite.conectar())	{
			try {
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				Mensajes.mostrarDebug(query);
				this.comando.executeQuery(query);
				
				ResultSet rs = this.comando.getResultSet();
//				rs.next();
				int n = rs.getInt(0);
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
