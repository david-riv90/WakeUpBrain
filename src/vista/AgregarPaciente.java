package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Especialista;
import modelo.Tutor;

import com.toedter.calendar.JDateChooser;

import dvx.gui.JComboBoxElement;

public class AgregarPaciente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtAP;
	private JTextField txtAM;
	private JDateChooser txtF_Nacimiento;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblTutor;
	private JLabel lblObservaciones;
	private JTextField txtDomicilio;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblDiagnostico;
	private JComboBox<JComboBoxElement> cmbTutor;
	private JLabel lblEspecialista;
	private JComboBox<JComboBoxElement> cmbEspecialista;

	JTextArea txtObservaciones;
	JTextArea txtDiagnostico;

	Tutor bdTutores = new Tutor();
	Especialista bdEspecialistas = new Especialista();

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

		txtF_Nacimiento = new JDateChooser();
		txtF_Nacimiento.setBounds(182, 176, 206, 28);
		contentPane.add(txtF_Nacimiento);

		lblNewLabel = new JLabel("Grado Escolar:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 217, 132, 28);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Domicilio:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 256, 122, 28);
		contentPane.add(lblNewLabel_1);

		lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblTutor.setBounds(23, 299, 65, 28);
		contentPane.add(lblTutor);

		lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblObservaciones.setBounds(520, 174, 126, 28);
		contentPane.add(lblObservaciones);

		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(182, 258, 206, 28);
		contentPane.add(txtDomicilio);
		txtDomicilio.setColumns(10);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnAgregar.setBackground(new Color(50, 205, 50));
		btnAgregar.setBounds(283, 481, 105, 36);
		contentPane.add(btnAgregar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnModificar.setBackground(new Color(219, 112, 147));
		btnModificar.setBounds(427, 481, 105, 36);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(30, 144, 255));
		btnEliminar.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnEliminar.setBounds(553, 481, 105, 36);
		contentPane.add(btnEliminar);

		txtObservaciones = new JTextArea();
		txtObservaciones.setLineWrap(true);
		txtObservaciones.setWrapStyleWord(true);
		JScrollPane area_observaciones = new JScrollPane(txtObservaciones);
		area_observaciones.setBounds(520, 209, 379, 96);
		contentPane.add(area_observaciones);

		lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblDiagnostico.setBounds(520, 57, 102, 28);
		contentPane.add(lblDiagnostico);

		txtDiagnostico = new JTextArea();
		txtDiagnostico.setLineWrap(true);
		txtDiagnostico.setWrapStyleWord(true);
		JScrollPane area_diagnostico = new JScrollPane(txtDiagnostico);
		area_diagnostico.setBounds(520, 86, 379, 81);
		contentPane.add(area_diagnostico);

		cmbTutor = new JComboBox<>();
		cmbTutor.setBounds(182, 299, 206, 25);
		String query_t = 
				"SELECT id_tutor, nombre || ' ' || apaterno || ' ' || amaterno AS 'tutor'" +
						"FROM tutor";
		if(this.bdTutores.listar_sqlite(query_t))	{
			cmbTutor.removeAllItems();
			for(JComboBoxElement elem : bdTutores.getJComboBoxElements_sqlite("id_tutor", "tutor"))	{
				cmbTutor.addItem(elem);
			}
		}
		contentPane.add(cmbTutor);

		lblEspecialista = new JLabel("Especialista:");
		lblEspecialista.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblEspecialista.setBounds(23, 338, 122, 28);
		contentPane.add(lblEspecialista);

		cmbEspecialista = new JComboBox<>();
		cmbEspecialista.setBounds(182, 341, 206, 25);
		String query_esp =
				"SELECT id_especialista, nombre || ' ' || apaterno || ' ' || amaterno AS 'especialista'" +
						"FROM especialista";
		if(this.bdEspecialistas.listar_sqlite(query_esp))	{
			cmbEspecialista.removeAllItems();
			for(JComboBoxElement elem : bdEspecialistas.getJComboBoxElements_sqlite("id_especialista", "especialista"))	{
				cmbEspecialista.addItem(elem);
			}
		}

		contentPane.add(cmbEspecialista);

		JSpinner txtGrado = new JSpinner();
		txtGrado.setBounds(323, 215, 65, 30);
		contentPane.add(txtGrado);

		//# Asignación de eventos de los controles
		this.asignarEventos();
	}

	/**
	 * Se asignan los eventos de cada control de la ventana
	 */
	private void asignarEventos()	{
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
	}
}