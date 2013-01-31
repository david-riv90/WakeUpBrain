package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Principal extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnTutor;
	JButton btnAgregarPaciente;

	/**
	 * Create the frame.
	 */
	public Principal() {
		//# Evitar la modificación del tamaño de la ventana por parte del usuario
		this.setResizable(false);
		setBounds(100, 100, 651, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* CODIGO ANTERIOR*/
//		JButton btnEspecialista = new JButton("ESPECIALISTA");
//		btnEspecialista.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
//		btnEspecialista.setBounds(240, 40, 153, 34);
//		contentPane.add(btnEspecialista);
//		
//		JButton btnActividad = new JButton("ACTIVIDAD");
//		btnActividad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
//		btnActividad.setBounds(240, 175, 121, 33);
//		contentPane.add(btnActividad);
//		
//		JComboBox<?> comboBox = new JComboBox<>();
//		comboBox.setBounds(44, 41, 121, 34);
//		contentPane.add(comboBox);
//		
//		btnTutor = new JButton("TUTORES");
//		btnTutor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
//		btnTutor.setBounds(240, 85, 153, 34);
//		contentPane.add(btnTutor);
//		
//		btnAgregarPaciente = new JButton("AGREGAR PACIENTE");
//		btnAgregarPaciente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
//		btnAgregarPaciente.setBounds(240, 130, 176, 34);
//		contentPane.add(btnAgregarPaciente);
		/* CODIGO ANTERIOR*/
		
//		getContentPane().setLayout(null);
		
		JLabel lblWakeupbrain = new JLabel("WakeUpBrain");
		lblWakeupbrain.setForeground(new Color(51, 102, 0));
		lblWakeupbrain.setBackground(new Color(255, 255, 51));
		lblWakeupbrain.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		lblWakeupbrain.setBounds(212, 44, 192, 56);
		getContentPane().add(lblWakeupbrain);
		
//		JComboBox<String> comboBox_5 = new JComboBox<>();
//		comboBox_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//		comboBox_5.setModel(new DefaultComboBoxModel<String>(new String[] {"Ni\u00F1o", "Agregar Ni\u00F1o", "Perfil Ni\u00F1o"}));
//		comboBox_5.setBounds(67, 148, 110, 36);
//		getContentPane().add(comboBox_5);
		
		JButton btnEspecialista = new JButton("Especialista");
		btnEspecialista.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnEspecialista.setBounds(175, 147, 116, 36);
		getContentPane().add(btnEspecialista);
		
		JButton btnIrALa = new JButton("Ir a la actividad");
		btnIrALa.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnIrALa.setBounds(337, 147, 143, 36);
		getContentPane().add(btnIrALa);
		
		btnTutor = new JButton("Tutores");
		btnTutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnTutor.setBounds(175, 200, 116, 36);
		getContentPane().add(btnTutor);
		
		btnAgregarPaciente = new JButton("Agregar paciente");
		btnAgregarPaciente.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnAgregarPaciente.setBounds(337, 200, 171, 36);
		contentPane.add(btnAgregarPaciente);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\GitHub\\WakeUpBrain\\img\\paisaje.jpg"));
		lblNewLabel.setBounds(0, 0, 645, 341);
		getContentPane().add(lblNewLabel);
		getContentPane().setBackground(new Color(51, 153, 204));
		getContentPane().setForeground(new Color(255, 0, 153));
		
		//# Asignar eventos a los controles
		this.asignarEventos();
	}
	
	private void asignarEventos()	{
		btnTutor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tutores t = new Tutores();
				t.setModalityType(ModalityType.APPLICATION_MODAL);
				t.setVisible(true);
			}
		});
		
		btnAgregarPaciente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AgregarPaciente ap = new AgregarPaciente();
				ap.setModalityType(ModalityType.APPLICATION_MODAL);
				ap.setVisible(true);
			}
		});
	}
}
