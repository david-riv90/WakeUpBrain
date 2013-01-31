package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dvx.bd.Entidades;
import dvx.error.Mensajes;

public class Telefono extends Entidades {

	// =============================== //
	// ======= << ATRIBUTOS >> ======= //
	// =============================== //
	private int id_tutor;
	private String tipo;
	private String numeroOriginal;
	private String numeroNuevo;
	public int getId_tutor() {
		return id_tutor;
	}
	public void setId_tutor(int id_tutor) {
		this.id_tutor = id_tutor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumeroOriginal() {
		return numeroOriginal;
	}
	public void setNumeroOriginal(String numeroOriginal) {
		this.numeroOriginal = numeroOriginal;
	}
	public String getNumeroNuevo() {
		return numeroNuevo;
	}
	public void setNumeroNuevo(String numero) {
		this.numeroNuevo = numero;
	}
	
	SesionSqlite sesion_sqlite = new SesionSqlite();
	Statement comando = null;
	
	List<Map<String, Object>> listaTelefonos = null;
	public List<Map<String, Object>> getListaTelefonos() {
		return listaTelefonos;
	}
	// =================================== //
	// ======= << CONSTRUCTORES >> ======= //
	// =================================== //
	public Telefono(){};

	// ============================= //
	// ======= << M�TODOS >> ======= //
	// ============================= //
	/**
	 * Agrega un tel�fono para el tutor que se est� editando
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean insertar()	{
		boolean exito = true;
		if(this.sesion_sqlite.conectar())	{
			String query = 
				"INSERT INTO" +
				"	telefono(id_tutor, numero, tipo)" +
				" VALUES('" + this.id_tutor + "','" + this.numeroNuevo + "','" + this.tipo + "')";
			try {
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg > 0)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			} catch (SQLException e) {
				Mensajes.mostrarError(e.getMessage(), "Agregar tel�fono");
			} finally	{
				//# Es importante cerrar estos objetos para evitar bloqueos en la tabla
				try {
					this.comando.close();
				} catch (SQLException e) {};
			}
		}
		return exito;
	}
	
	/**
	 * Modificar el n�mero de tel�fono de un tutor
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean modificar()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			try	{
				String query = 
					"UPDATE telefono SET" +
					"	id_tutor = '" + this.id_tutor + "'" +
					"	,numero = '" + this.numeroNuevo + "'" +
					"	,tipo = '" + this.tipo + "'" +
					"WHERE id_tutor = '" + this.id_tutor + "' AND numero = '" + this.numeroOriginal + "'";
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg > 0)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Modificar tel�fono");
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
	 * Elimina un n�mero telef�nico de un tutor
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean eliminar()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			try	{
				String query = 
					"DELETE FROM telefono " +
					"WHERE id_tutor = '" + this.id_tutor + "' AND numero = '" + this.numeroOriginal + "'";
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				int num_reg = this.comando.executeUpdate(query);
				
				if(num_reg > 0)	{
					exito = true;
				}else	{
					throw new SQLException("Los cambios no han podido ser guardados");
				}
			}catch(SQLException ex)	{
				Mensajes.mostrarError(ex.getMessage(), "Eliminar tel�fono");
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
	 * Recupera la lista de tel�fonos de un tutor
	 * Los datos pueden ser recuperados usando el m�todo: getListaTutores()
	 * @return True si la acci�n se realiza exitosamente, False en caso contrario
	 */
	public boolean listar_sqlite()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			ResultSet rs = null;
			try	{
				String query = 
					"SELECT tipo, numero FROM telefono " +
					"WHERE id_tutor = " + this.id_tutor;
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el n�mero de l�neas afectadas en BD
				rs = this.comando.executeQuery(query);
				//#Recuperando los registros
				this.listaTelefonos = new ArrayList<Map<String, Object>>();
				Map<String, Object> mpColumnas = null;
				while(rs.next())	{
					mpColumnas = new HashMap<>();
					//# Se recorren las columnas de la fila seleccionada en el ResultSet
					for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)	{
						mpColumnas.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
					}
					//# Se agrega la fila a la lista de la clase
					this.listaTelefonos.add(mpColumnas);
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
}
