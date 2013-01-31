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

public class Especialista extends Entidades {
	
	private String usuario;
	private String contrasenia;
	
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
	
	SesionSqlite sesion_sqlite = new SesionSqlite();
	Statement comando = null;
	
	private List<Map<String, Object>> listaEspecialistas;
	public List<Map<String, Object>> getListaEspecialistas() {
		return listaEspecialistas;
	}
	
	/**
	 * Verifica la existencia en BD del usuario que intenta utilizar la aplicación
	 * @return True si el usuario existe, False en caso contrario
	 */
	public boolean login()	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			String query = 
					"SELECT COUNT(*) FROM especialista" +
					" WHERE usuario = '" + this.usuario + "' AND contrasenia = '" + this.contrasenia + "'";
			ResultSet rs = null;
			try {
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				rs = this.comando.executeQuery(query);
				rs.next();
				int n = rs.getInt(1);
				if(n == 1)	{
					exito = true;
				}
			} catch (SQLException e) {
				Mensajes.mostrarError(e.getMessage(), "login");
			} finally	{
				//# Es importante cerrar estos objetos para evitar bloqueos en la tabla
				try {
					rs.close();
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
	public boolean listar_sqlite(String _query)	{
		boolean exito = false;
		if(this.sesion_sqlite.conectar())	{
			ResultSet rs = null;
			try	{
				String query = _query.isEmpty() || null == _query ? "SELECT * FROM especialista" : _query;
				this.comando = this.sesion_sqlite.getConexion().createStatement();
				//# executeUpdate devuelve el número de líneas afectadas en BD
				rs = this.comando.executeQuery(query);
				//#Recuperando los registros
				this.listaEspecialistas = new ArrayList<Map<String, Object>>();
				Map<String, Object> mpColumnas = null;
				while(rs.next())	{
					mpColumnas = new HashMap<>();
					//# Se recorren las columnas de la fila seleccionada en el ResultSet
					for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)	{
						mpColumnas.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
					}
					//# Se agrega la fila a la lista de la clase
					this.listaEspecialistas.add(mpColumnas);
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
	
	/**
	 * Obtener los JComboBoxElements para rellenar un JComboBox
	 * @param _campoValor
	 * @param _campoMostrado
	 * @return
	 */
	public JComboBoxElement[] getJComboBoxElements_sqlite(String _campoValor, String _campoMostrado)	{
		JComboBoxElement[] cmbElements = new JComboBoxElement[this.listaEspecialistas.size()];
		
		Iterator<Map<String, Object>> it_filas = this.listaEspecialistas.iterator();
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
