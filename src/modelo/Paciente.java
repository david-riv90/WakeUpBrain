package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dvx.bd.Entidad;
import dvx.error.Mensajes;

public class Paciente extends Entidad {
	
	// =============================== //
	// ======= << ATRIBUTOS >> ======= //
	// =============================== //
	
	private int id;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private Date fnacimiento;
	private int grado_primaria;
	private String diagnostico;
	private String observaciones;
	private int id_tutor;
	private int id_especialista;
	
	
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
	public Date getFnacimiento() {
		return fnacimiento;
	}
	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}
	public int getGrado_primaria() {
		return grado_primaria;
	}
	public void setGrado_primaria(int grado_primaria) {
		this.grado_primaria = grado_primaria;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getId_tutor() {
		return id_tutor;
	}
	public void setId_tutor(int id_tutor) {
		this.id_tutor = id_tutor;
	}
	public int getId_especialista() {
		return id_especialista;
	}
	public void setId_especialista(int id_especialista) {
		this.id_especialista = id_especialista;
	}

	private List<Map<String, Object>> listaPacientes;
	public List<Map<String, Object>> getListaPacientes() {
		return listaPacientes;
	}

	SesionSqlite sesion_sqlite = new SesionSqlite();
	Statement comando = null;
	// =================================== //
	// ======= << CONSTRUCTORES >> ======= //
	// =================================== //
	public Paciente()	{
		super();
	}

	// ============================= //
	// ======= << MÉTODOS >> ======= //
	// ============================= //
	/**
	 * Inserta un paciente en BD
	 * @return True si la acción se realiza exitosamente, False en caso contrario
	 */
	public boolean insertar()	{
		boolean exito = true;
		if(this.sesion_sqlite.conectar())	{
			String query = 
				"INSERT INTO " +
				"	paciente(nombre, apaterno, amaterno, fnacimiento, grado_primaria, diagnostico, observaciones, id_tutor, id_especialista) " +
				"VALUES(" +
				"	'" + this.nombre + "'" +
				"	,'" + this.apaterno + "'" +
				"	,'" + this.amaterno + "'" +
				"	,'" + this.fnacimiento + "'" +
				"	," + this.grado_primaria + ""	+
				"	,'" + this.diagnostico + "'" +
				"	,'" + this.observaciones + "'" +
				"	," + this.id_tutor + "" +
				"	," + this.id_especialista + "" +
				");";
			String query_id = "SELECT last_insert_rowid();";
			ResultSet rs = null;
			try {
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el número de líneas afectadas en BD
				this.comando.executeUpdate(query);
				//# Recuperar el último id creado para la transacción actual
				rs = this.comando.executeQuery(query_id);
				rs.next();
				int id_nuevo_registro = rs.getInt(1);
				if(id_nuevo_registro > 0)	{
					this.id = id_nuevo_registro;
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			} catch (SQLException e) {
				Mensajes.mostrarError(e.getMessage(), "Insertar paciente");
			} finally	{
				//# Es importante cerrar estos objetos para evitar bloqueos en la tabla
				try {
					this.comando.close();
					rs.close();
				} catch (SQLException e) {};
			}
		}
		return exito;
	}
	
	/**
	 * Modificar los datos de un paciente existente en Base de Datos
	 * @return True si la acción se realiza exitosamente, False en caso contrario
	 */
	public boolean modificar()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			try	{
				String query = 
					"UPDATE paciente SET" +
					"	nombre = '" + this.nombre + "'" +
					"	,apaterno = '" + this.apaterno + "'" +
					"	,amaterno = '" + this.amaterno + "'" +
					"	,fnacimiento = '" + this.fnacimiento + "'" +
					"	,grado_primaria = '" + this.grado_primaria + "'" +
					"	,diagnostico = '" + this.diagnostico + "'" +
					"	,observaciones = '" + this.observaciones + "'" +
					"	,id_tutor = '" + this.id_tutor + "'" +
					"	,id_especialista = '" + this.id_especialista + "' " +
					"WHERE id_tutor = " + this.id;
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el número de líneas afectadas en BD
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg > 0)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Modificar paciente");
			}finally	{
				//# Es importante cerrar estos objetos para evitar bloqueos en la tabla
				try {
					this.comando.close();
				} catch (SQLException e) {};
			}
		}
		return exito;
	}
	
	/**
	 * Elimina el registro en BD, que coincida con el valor del atributo id actual de esta clase
	 * @return True si la acción se realiza exitosamente, False en caso contrario
	 */
	public boolean eliminar()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			try	{
				String query = 
					"DELETE FROM paciente " +
					"WHERE id_paciente = " + this.id;
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el número de líneas afectadas en BD
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg > 0)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Eliminar paciente");
			}finally	{
				//# Es importante cerrar estos objetos para evitar bloqueos en la tabla
				try {
					this.comando.close();
				} catch (SQLException e) {};
			}
		}
		return exito;
	}
	
	/**
	 * Recupera la lista de pacientes presentes en BD y las guarda en una variable de la clase
	 * Los datos pueden ser recuperados usando el método: getListaTutores()
	 * @return True si la acción se realiza exitosamente, False en caso contrario
	 */
	public boolean listar_sqlite()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			ResultSet rs = null;
			try	{
				String query = 
					"SELECT " +
						"p.nombre" +
						",p.apaterno" +
						",p.amaterno" +
						",p.fnacimiento" +
						",p.grado_primaria" +
						",p.diagnostico" +
						",p.observaciones" +
						",t.nombre || ' ' || t.apaterno || ' ' || t.amaterno AS 'tutor'" +
						",e.nombre || ' ' || e.apaterno || ' ' || e.amaterno AS 'especialista' " +
					"FROM paciente p" +
					"JOIN especialista e ON p.id_especialista = e.id_especialista" +
					"JOIN tutor t ON p.id_tutor = t.id_tutor";
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el número de líneas afectadas en BD
				rs = this.comando.executeQuery(query);
				//#Recuperando los registros
				this.listaPacientes = new ArrayList<Map<String, Object>>();
				Map<String, Object> mpColumnas = null;
				while(rs.next())	{
					mpColumnas = new HashMap<>();
					//# Se recorren las columnas de la fila seleccionada en el ResultSet
					for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)	{
						mpColumnas.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
					}
					//# Se agrega la fila a la lista de la clase
					this.listaPacientes.add(mpColumnas);
				}
				exito = true;
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Listar pacientes");
			}finally	{
				//# Es importante cerrar estos objetos para evitar bloqueos en la tabla
				try {
					this.comando.close();
					rs.close();
				} catch (SQLException e) {};
			}
		}
		return exito;
	}
}
