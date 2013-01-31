package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;


public class PerfilEspecialista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilEspecialista frame = new PerfilEspecialista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PerfilEspecialista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(49, 56, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(49, 100, 83, 14);
		contentPane.add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(49, 139, 83, 14);
		contentPane.add(lblApellidoMaterno);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(49, 179, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(49, 216, 64, 14);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(150, 53, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 97, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 136, 111, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 176, 109, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 213, 111, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(97, 271, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(239, 271, 89, 23);
		contentPane.add(btnModificar);
		
		JLabel lblNuevoEspecialista = new JLabel("Nuevo Especialista");
		lblNuevoEspecialista.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNuevoEspecialista.setBounds(97, 11, 133, 23);
		contentPane.add(lblNuevoEspecialista);
	}
}
