package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dvx.bd.Entidades;
import dvx.error.Mensajes;
import dvx.gui.JComboBoxElement;

public class Tutor extends Entidades {

	// =============================== //
	// ======= << ATRIBUTOS >> ======= //
	// =============================== //
	private int id;
	private String nombre;
	private String apaterno;
	private String amaterno;
	
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
	
	private List<Map<String, Object>> listaTutores;
	public List<Map<String, Object>> getListaTutores() {
		return listaTutores;
	}

	SesionSqlite sesion_sqlite = new SesionSqlite();
	Statement comando = null;

	// =================================== //
	// ======= << CONSTRUCTORES >> ======= //
	// =================================== //
	public Tutor()	{};
	
	
	// ============================= //
	// ======= << M�TODOS >> ======= //
	// ============================= //
	/**
	 * Inserta un tutor en BD
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean insertar()	{
		boolean exito = true;
		if(this.sesion_sqlite.conectar())	{
			String query = 
				"INSERT INTO" +
				"	tutor(nombre, apaterno, amaterno)" +
				" VALUES('" + this.nombre + "','" + this.apaterno + "','" + this.amaterno + "');";
			String query_id = " SELECT last_insert_rowid();";
			ResultSet rs = null;
			try {
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				this.comando.executeUpdate(query);
				//# Recuperar el �ltimo id creado para la transacci�n actual
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
				Mensajes.mostrarError(e.getMessage(), "Insertar tutor");
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
	 * Modificar los datos de un tutor existente en Base de Datos
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean modificar()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			try	{
				String query = 
					"UPDATE tutor SET" +
					"	nombre = '" + this.nombre + "'" +
					"	,apaterno = '" + this.apaterno + "'" +
					"	,amaterno = '" + this.amaterno + "'" +
					"WHERE id_tutor = " + this.id;
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg > 0)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Modificar tutor");
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
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean eliminar()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			try	{
				String query = 
					"DELETE FROM tutor " +
					"WHERE id_tutor = " + this.id;
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg > 0)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Eliminar tutor");
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
	 * Recupera la lista de tutores presentes en BD y las guarda en una variable de la clase
	 * Los datos pueden ser recuperados usando el m�todo: getListaTutores()
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean listar_sqlite(String _query)	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			ResultSet rs = null;
			try	{
//				String query = "SELECT * FROM tutor";
				String query = _query.isEmpty() || null == _query ? "SELECT * FROM tutor" : _query;
				
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				rs = this.comando.executeQuery(query);
				//#Recuperando los registros
				this.listaTutores = new ArrayList<Map<String, Object>>();
				Map<String, Object> mpColumnas = null;
				while(rs.next())	{
					mpColumnas = new HashMap<>();
					//# Se recorren las columnas de la fila seleccionada en el ResultSet
					for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)	{
						mpColumnas.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
					}
					//# Se agrega la fila a la lista de la clase
					this.listaTutores.add(mpColumnas);
				}
				exito = true;
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Listar tutores");
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
	
	/**
	 * Obtener los JComboBoxElements para rellenar un JComboBox
	 * @param _campoValor
	 * @param _campoMostrado
	 * @return
	 */
	public JComboBoxElement[] getJComboBoxElements_sqlite(String _campoValor, String _campoMostrado)	{
		JComboBoxElement[] cmbElements = new JComboBoxElement[this.listaTutores.size()];
		
		Iterator<Map<String, Object>> it_filas = this.listaTutores.iterator();
		Map<String, Object> fila = null;
		int nElemento = 0;
		JComboBoxElement elem = null;
		while(it_filas.hasNext())	{
			fila = it_filas.next();
			try	{
				if(fila.containsKey(_campoValor))	{
					elem = new JComboBoxElement();
					elem.setValor(fila.get(_campoValor));
					elem.setValorMostrado((String) fila.get(_campoMostrado));
					cmbElements[nElemento] = elem;
				}else	{
					throw new ClassCastException("El campo valor [" + _campoValor + "] no existe dentro de la tabla [" + super.tabla_nombre + "]");
				}
			}catch(ClassCastException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Entidades getJcomboBoxElements()");
			}finally	{
				nElemento++;
			}
		}
		return cmbElements;
	}
}
