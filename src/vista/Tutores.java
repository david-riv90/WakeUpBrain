package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dvx.error.Mensajes;
import dvx.gui.JControles;
import dvx.gui.MiGrid;
import dvx.gui.MiGridColumna;

import modelo.Tutor;
import javax.swing.SwingConstants;

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

	Tutor bdTutor = new Tutor();
	
	MiGrid grdTutores = null;
	private JLabel lblId_valor;
	private JButton btnCancelarEdicion;



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
		setBounds(100, 100, 450, 500);
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
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblApelidoPaterno = new JLabel("Apelido Paterno");
		lblApelidoPaterno.setForeground(Color.BLUE);
		lblApelidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setForeground(Color.BLUE);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblBienvenido.setForeground(Color.MAGENTA);
		lblBienvenido.setBackground(Color.MAGENTA);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 22));

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		txtApPaterno = new JTextField();
		txtApPaterno.setColumns(10);

		txtApMaterno = new JTextField();
		txtApMaterno.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(Color.PINK);

		btnModificar = new JButton("Modificar");
		btnModificar.setVisible(false);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setVisible(false);
		
		btnCancelarEdicion = new JButton("Cancelar edici\u00F3n");
		btnCancelarEdicion.setVisible(false);
		
		//# Grid
		MiGridColumna[] columnas = {
				new MiGridColumna("id_tutor", "ID")
				,new MiGridColumna("nombre", "Nombre")
				,new MiGridColumna("apaterno", "Apellido paterno")
				,new MiGridColumna("amaterno", "Apellido materno")
		};
		
		grdTutores = new MiGrid();
		grdTutores.setTitulo("Tutores");
		grdTutores.setColumnas(columnas);
//		grdTutores.setColorFondo(new Color(0, 0, 0));
		if(this.bdTutor.listar())	{
			grdTutores.setContenido(this.bdTutor.getListaTutores());
		}
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.BLUE);
		lblID.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblId_valor = new JLabel("");
		lblId_valor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId_valor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		//# Coloca los controles
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(lblBienvenido))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnIngresar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnModificar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnEliminar)
									.addGap(10)
									.addComponent(btnCancelarEdicion))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblApellidoMaterno)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtApMaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblApelidoPaterno)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtApPaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNombre)
											.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblId_valor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtNombre, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(grdTutores, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBienvenido)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblId_valor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblID, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApelidoPaterno)
						.addComponent(txtApPaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidoMaterno)
						.addComponent(txtApMaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIngresar)
						.addComponent(btnModificar)
						.addComponent(btnEliminar)
						.addComponent(btnCancelarEdicion))
					.addGap(18)
					.addComponent(grdTutores, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
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
				if(bdTutor.insertar() && bdTutor.listar())	{
					grdTutores.setContenido(bdTutor.getListaTutores());
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
					} catch (Exception e1) {
						Mensajes.mostrarError(e1.getMessage(), "Cargar datos");
					}
					
					lblBienvenido.setText("Editando");
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
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bdTutor.setId(Integer.parseInt(lblId_valor.getText()));
				bdTutor.setNombre(txtNombre.getText());
				bdTutor.setApaterno(txtApPaterno.getText());
				bdTutor.setAmaterno(txtApMaterno.getText());
				if(bdTutor.modificar() && bdTutor.listar())	{
					grdTutores.setContenido(bdTutor.getListaTutores());
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(Tutores.this, "¿Deseas realmente eliminar el registro?"))	{
					bdTutor.setId(Integer.parseInt(lblId_valor.getText()));
					if(bdTutor.eliminar() && bdTutor.listar())	{
						grdTutores.setContenido(bdTutor.getListaTutores());
					}
				}
			}
		});
	}
}
