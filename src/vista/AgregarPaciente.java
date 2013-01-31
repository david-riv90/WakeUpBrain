package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AgregarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtAP;
	private JTextField txtAM;
	private JTextField txtF_Nacimiento;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblTelefono;
	private JLabel lblTutor;
	private JLabel lblObservaciones;
	private JTextField txtGrado;
	private JTextField txtDomicilio;
	private JTextField txtTutor;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField txtTelefono;
	private JTable table;
	private JLabel lblDiagnostico;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AgregarPaciente frame = new AgregarPaciente();
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
	public AgregarPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblE = new JLabel("Ingrese los datos del ni\u00F1o");
		lblE.setBackground(Color.PINK);
		lblE.setToolTipText("");
		lblE.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblE.setBounds(276, 11, 296, 36);
		contentPane.add(lblE);
		
		JLabel lblNom = new JLabel("Nombre:");
		lblNom.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNom.setBounds(23, 62, 78, 19);
		contentPane.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(182, 58, 206, 28);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblApellidoPaterno.setBounds(23, 92, 132, 28);
		contentPane.add(lblApellidoPaterno);
		
		txtAP = new JTextField();
		txtAP.setBounds(182, 97, 206, 28);
		contentPane.add(txtAP);
		txtAP.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblApellidoMaterno.setBounds(23, 131, 132, 36);
		contentPane.add(lblApellidoMaterno);
		
		txtAM = new JTextField();
		txtAM.setBounds(182, 136, 206, 28);
		contentPane.add(txtAM);
		txtAM.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblFechaDeNacimiento.setBounds(23, 170, 164, 36);
		contentPane.add(lblFechaDeNacimiento);
		
		txtF_Nacimiento = new JTextField();
		txtF_Nacimiento.setBounds(182, 176, 206, 28);
		contentPane.add(txtF_Nacimiento);
		txtF_Nacimiento.setColumns(10);
		
		lblNewLabel = new JLabel("Grado Escolar:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 217, 132, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Domicilio:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 256, 122, 28);
		contentPane.add(lblNewLabel_1);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblTelefono.setBounds(23, 357, 105, 28);
		contentPane.add(lblTelefono);
		
		lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblTutor.setBounds(23, 299, 65, 28);
		contentPane.add(lblTutor);
		
		lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblObservaciones.setBounds(520, 174, 126, 28);
		contentPane.add(lblObservaciones);
		
		txtGrado = new JTextField();
		txtGrado.setBounds(182, 217, 206, 28);
		contentPane.add(txtGrado);
		txtGrado.setColumns(10);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(182, 258, 206, 28);
		contentPane.add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		txtTutor = new JTextField();
		txtTutor.setBounds(182, 301, 206, 28);
		contentPane.add(txtTutor);
		txtTutor.setColumns(10);
		
		JButton btnAgragar = new JButton("Agregar");
		btnAgragar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAgragar.setBackground(new Color(50, 205, 50));
		btnAgragar.setBounds(283, 481, 105, 36);
		contentPane.add(btnAgragar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setBackground(new Color(219, 112, 147));
		btnModificar.setBounds(427, 481, 105, 36);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(30, 144, 255));
		btnEliminar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminar.setBounds(553, 481, 105, 36);
		contentPane.add(btnEliminar);
		
		JList list = new JList();
		list.setBounds(216, 340, 122, -13);
		contentPane.add(list);
		
		JComboBox cbxTelefono = new JComboBox();
		cbxTelefono.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		cbxTelefono.setEditable(true);
		cbxTelefono.setToolTipText("Casa");
		cbxTelefono.setModel(new DefaultComboBoxModel(new String[] {"Movil", "Casa", "Tarbajo"}));
		cbxTelefono.setBounds(181, 357, 116, 28);
		contentPane.add(cbxTelefono);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(512, 361, 41, 25);
		contentPane.add(btnNewButton);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(324, 359, 163, 28);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(634, 131, 265, 96);
		contentPane.add(formattedTextField);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Numero", "Tipo"
			}
		));
		table.setBounds(182, 396, 350, 74);
		contentPane.add(table);
		
		lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblDiagnostico.setBounds(520, 57, 102, 28);
		contentPane.add(lblDiagnostico);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(634, 33, 265, 81);
		contentPane.add(formattedTextField_1);
	}
}