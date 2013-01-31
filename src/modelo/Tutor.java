package modelo;

import java.sql.SQLException;
import java.sql.Statement;

import dvx.error.Mensajes;

public class Tutor {

	private int id;
	private String nombre;
	private String apaterno;
	private String amaterno;
	
	SesionSqlite sesion_sqlite = new SesionSqlite();
	Statement comando = null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public Tutor()	{};
	
	/*
	 * INSERT INTO "main"."tutor" ("id_tutor","nombre","apaterno","amaterno") VALUES (?1,?2,?3,?4)
Parameters:
param 1 (text): 
param 2 (text): Felipe
param 3 (text): Ríos
param 4 (text): Miranda
	 */
	
	/**
	 * Inserta un tutor en BD
	 * @return True si la acción se realiza exitosamente, False en caso contrario
	 */
	public boolean insertar()	{
		boolean exito = true;
		if(this.sesion_sqlite.conectar())	{
			String query = 
				"INSERT INTO" +
				"	tutor(nombre, apaterno, amaterno)" +
				" VALUES('" + this.nombre + "','" + this.apaterno + "','" + this.amaterno + "')";
			try {
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg == 1)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			} catch (SQLException e) {
				Mensajes.mostrarError(e.getMessage(), "Insertar tutor");
			} finally	{
				//# Es importante cerrar estos objetos para evitar bloqueos en la tabla
				try {
					this.comando.close();
				} catch (SQLException e) {};
			}
		}
		return exito;
	}
}
