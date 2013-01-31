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
		
		JButton btnEspecialista = new JButton("ESPECIALISTA");
		btnEspecialista.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnEspecialista.setBounds(240, 40, 153, 34);
		contentPane.add(btnEspecialista);
		
		JButton btnActividad = new JButton("ACTIVIDAD");
		btnActividad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnActividad.setBounds(240, 175, 121, 33);
		contentPane.add(btnActividad);
		
		JComboBox<?> comboBox = new JComboBox<>();
		comboBox.setBounds(44, 41, 121, 34);
		contentPane.add(comboBox);
		
		btnTutor = new JButton("TUTORES");
		btnTutor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnTutor.setBounds(240, 85, 153, 34);
		contentPane.add(btnTutor);
		
		btnAgregarPaciente = new JButton("AGREGAR PACIENTE");
		btnAgregarPaciente.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnAgregarPaciente.setBounds(240, 130, 176, 34);
		contentPane.add(btnAgregarPaciente);
		
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
