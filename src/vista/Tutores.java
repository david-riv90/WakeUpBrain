package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Telefono;
import modelo.Tutor;
import dvx.error.Mensajes;
import dvx.gui.JControles;
import dvx.gui.MiGrid;
import dvx.gui.MiGridColumna;

public class Tutores extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JLabel lblBienvenido = new JLabel("Bienvenido");
	
	private JTextField txtNombre;
	private JTextField txtApPaterno;
	private JTextField txtApMaterno;
	JButton btnIngresar;
	JButton btnModificar;
	JButton btnEliminar;
	
	private JComboBox<String> cmbTipoTelefono;
	private JButton btnAgregarTelefono;
	private JTextField txtTelefono;

	Tutor bdTutor = new Tutor();
	Telefono bdTelefono = new Telefono();
	
	MiGrid grdTutores = null;
	private JLabel lblId_valor;
	private JButton btnCancelarEdicion;
	MiGrid grdTelefonos = null;



	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					Tutor frame = new Tutor();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public Tutores() {
		setBounds(100, 100, 488, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//# Colocar controles
		this.colocarControles();
		//# Asignar los eventos de los controles
		this.asignarEventos();
	}

	/**
	 * Coloca los controles en el lugar que les corresponde e inicializa
	 * sus propiedades
	 */
	private void colocarControles()	{
		//# Agregar controles
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setSize(new Dimension(0, 25));
		lblNombre.setBounds(15, 100, 56, 17);
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblApelidoPaterno = new JLabel("Apelido Paterno");
		lblApelidoPaterno.setSize(new Dimension(0, 25));
		lblApelidoPaterno.setBounds(15, 160, 110, 17);
		lblApelidoPaterno.setForeground(Color.BLUE);
		lblApelidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setSize(new Dimension(0, 25));
		lblApellidoMaterno.setBounds(15, 220, 116, 17);
		lblApellidoMaterno.setForeground(Color.BLUE);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(15, 16, 449, 27);

		lblBienvenido.setForeground(Color.MAGENTA);
		lblBienvenido.setBackground(Color.MAGENTA);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 22));

		txtNombre = new JTextField();
		txtNombre.setBounds(15, 128, 168, 21);
		txtNombre.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtNombre.setColumns(10);

		txtApPaterno = new JTextField();
		txtApPaterno.setBounds(15, 188, 168, 21);
		txtApPaterno.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtApPaterno.setColumns(10);

		txtApMaterno = new JTextField();
		txtApMaterno.setBounds(15, 248, 168, 21);
		txtApMaterno.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtApMaterno.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(15, 293, 124, 23);
		btnIngresar.setBackground(Color.PINK);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(97, 293, 92, 23);
		btnModificar.setVisible(false);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(199, 293, 92, 23);
		btnEliminar.setVisible(false);
		
		btnCancelarEdicion = new JButton("Cancelar edici\u00F3n");
		btnCancelarEdicion.setBounds(301, 293, 140, 23);
		btnCancelarEdicion.setVisible(false);
		
		//# Grid
		MiGridColumna[] columnas = {
				new MiGridColumna("id_tutor", "ID")
				,new MiGridColumna("nombre", "Nombre")
				,new MiGridColumna("apaterno", "Apellido paterno")
				,new MiGridColumna("amaterno", "Apellido materno")
		};
		
		grdTutores = new MiGrid();
		grdTutores.setBounds(15, 327, 449, 122);
		grdTutores.setTitulo("Tutores");
		grdTutores.setColumnas(columnas);
//		grdTutores.setColorFondo(new Color(0, 0, 0));
		if(this.bdTutor.listar_sqlite(""))	{
			grdTutores.setContenido(this.bdTutor.getListaTutores());
		}
		
		JLabel lblID = new JLabel("ID");
		lblID.setSize(new Dimension(0, 25));
		lblID.setBounds(15, 69, 64, 20);
		lblID.setForeground(Color.BLUE);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblId_valor = new JLabel("");
		lblId_valor.setBounds(53, 69, 124, 20);
		lblId_valor.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_valor.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JPanel panel = new JPanel();
		panel.setBounds(210, 72, 254, 203);
		panel.setBorder(new TitledBorder(null, "Tel\u00E9fonos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		cmbTipoTelefono = new JComboBox<String>();
		cmbTipoTelefono.setEnabled(false);
		cmbTipoTelefono.setBounds(10, 27, 116, 21);
		panel.add(cmbTipoTelefono);
		cmbTipoTelefono.setModel(new DefaultComboBoxModel<String>(new String[] {"M\u00F3vil", "Trabajo", "Casa"}));
		cmbTipoTelefono.setToolTipText("Casa");
		cmbTipoTelefono.setFont(new Font("Dialog", Font.PLAIN, 11));
		cmbTipoTelefono.setEditable(true);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(10, 59, 163, 21);
		panel.add(txtTelefono);
		txtTelefono.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtTelefono.setColumns(10);
		
		btnAgregarTelefono = new JButton("+");
		btnAgregarTelefono.setEnabled(false);
		btnAgregarTelefono.setBounds(183, 58, 41, 23);
		panel.add(btnAgregarTelefono);
		btnAgregarTelefono.setFont(new Font("Dialog", Font.PLAIN, 11));
		contentPane.setLayout(null);
		contentPane.add(grdTutores);
		contentPane.add(btnIngresar);
		contentPane.add(btnModificar);
		contentPane.add(btnEliminar);
		contentPane.add(btnCancelarEdicion);
		contentPane.add(lblBienvenido);
		contentPane.add(lblApellidoMaterno);
		contentPane.add(txtApMaterno);
		contentPane.add(lblApelidoPaterno);
		contentPane.add(txtApPaterno);
		contentPane.add(lblNombre);
		contentPane.add(lblID);
		contentPane.add(lblId_valor);
		contentPane.add(txtNombre);
		contentPane.add(panel);
		
		grdTelefonos = new MiGrid();
		grdTelefonos.setEnabled(false);
		columnas = new MiGridColumna[]{
				new MiGridColumna("tipo", "Tipo")
				,new MiGridColumna("numero", "Teléfono")
		};
		grdTelefonos.setMinimumSize(new Dimension(234, 101));
		grdTelefonos.setBounds(10, 91, 234, 101);
		grdTelefonos.setColumnas(columnas);
		panel.add(grdTelefonos);
	}

	/**
	 * Se asignan los eventos de cada control de la ventana
	 */
	private void asignarEventos()	{
		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bdTutor.setNombre(txtNombre.getText());
				bdTutor.setApaterno(txtApPaterno.getText());
				bdTutor.setAmaterno(txtApMaterno.getText());
				if(bdTutor.insertar() && bdTutor.listar_sqlite(""))	{
					grdTutores.setContenido(bdTutor.getListaTutores());
					lblId_valor.setText(String.valueOf(bdTutor.getId()));
					
					cmbTipoTelefono.setEnabled(true);
					txtTelefono.setEnabled(true);
					btnAgregarTelefono.setEnabled(true);
					grdTelefonos.setEnabled(true);
					//# Se asigna el id del tutor a la instancia de telefono
					bdTelefono.setId_tutor(bdTutor.getId());
				}
			}
		});
		
		btnAgregarTelefono.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bdTelefono.setNumeroNuevo(txtTelefono.getText());
				bdTelefono.setTipo(cmbTipoTelefono.getSelectedItem().toString());
				if(bdTelefono.insertar() && bdTelefono.listar_sqlite())	{
					grdTelefonos.setContenido(bdTelefono.getListaTelefonos());
				}
			}
		});
		
		grdTutores.getTable().setCellSelectionEnabled(false);
		grdTutores.getTable().setRowSelectionAllowed(true);
		ListSelectionModel modo_seleccion = grdTutores.getTable().getSelectionModel();
		modo_seleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modo_seleccion.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int fila_seleccionada = grdTutores.getSelectedRow();
				if(fila_seleccionada > -1)	{
					btnIngresar.setVisible(false);
					
					btnModificar.setVisible(true);
					btnEliminar.setVisible(true);
					btnCancelarEdicion.setVisible(true);
					
					try {
						lblId_valor.setText(grdTutores.getValueAt(fila_seleccionada, "id_tutor").toString());
						txtNombre.setText(grdTutores.getValueAt(fila_seleccionada, "nombre").toString());
						txtApPaterno.setText(grdTutores.getValueAt(fila_seleccionada, "apaterno").toString());
						txtApMaterno.setText(grdTutores.getValueAt(fila_seleccionada, "amaterno").toString());
						//# Se asigna el id del tutor a la instancia de telefono y se cargan los telefonos
						bdTelefono.setId_tutor(Integer.parseInt(lblId_valor.getText()));
						if(bdTelefono.listar_sqlite())	{
							grdTelefonos.setContenido(bdTelefono.getListaTelefonos());
						}
					} catch (Exception e1) {
						Mensajes.mostrarError(e1.getMessage(), "Cargar datos");
					}
					
					lblBienvenido.setText("Editando");
					
					cmbTipoTelefono.setEnabled(true);
					txtTelefono.setEnabled(true);
					btnAgregarTelefono.setEnabled(true);
					grdTelefonos.setEnabled(true);
				}
			}
		});
		
		btnCancelarEdicion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnIngresar.setVisible(true);
				
				btnModificar.setVisible(false);
				btnEliminar.setVisible(false);
				btnCancelarEdicion.setVisible(false);
				
				JControles.limpiarTexts(new Component[]{txtNombre, txtApPaterno, txtApMaterno, lblId_valor});
				
				lblBienvenido.setText("Nuevo tutor");
				
				cmbTipoTelefono.setEnabled(false);
				txtTelefono.setEnabled(false);
				btnAgregarTelefono.setEnabled(false);
				bdTelefono.setId_tutor(0);
				bdTelefono.listar_sqlite();
				grdTelefonos.setContenido(bdTelefono.getListaTelefonos());
				grdTelefonos.setEnabled(false);
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bdTutor.setId(Integer.parseInt(lblId_valor.getText()));
				bdTutor.setNombre(txtNombre.getText());
				bdTutor.setApaterno(txtApPaterno.getText());
				bdTutor.setAmaterno(txtApMaterno.getText());
				if(bdTutor.modificar() && bdTutor.listar_sqlite(""))	{
					grdTutores.setContenido(bdTutor.getListaTutores());
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(Tutores.this, "¿Deseas realmente eliminar el registro?"))	{
					bdTutor.setId(Integer.parseInt(lblId_valor.getText()));
					if(bdTutor.eliminar() && bdTutor.listar_sqlite(""))	{
						JControles.limpiarTexts(new Component[]{txtNombre, txtApPaterno, txtApMaterno, lblId_valor});
						btnIngresar.setVisible(true);
						
						btnModificar.setVisible(false);
						btnEliminar.setVisible(false);
						btnCancelarEdicion.setVisible(false);
						
						cmbTipoTelefono.setEnabled(false);
						txtTelefono.setEnabled(false);
						btnAgregarTelefono.setEnabled(false);
						bdTelefono.setId_tutor(0);
						bdTelefono.listar_sqlite();
						grdTelefonos.setContenido(bdTelefono.getListaTelefonos());
						grdTelefonos.setEnabled(false);
						
						grdTutores.setContenido(bdTutor.getListaTutores());
					}
				}
			}
		});
	}
}
