package vista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Especialista;
import dvx.error.Mensajes;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnEnviar; 
//	private JPasswordField passwordField;
	Especialista esp = new Especialista();

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Iris\\Pictures\\Imagen1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsuario.setLabelFor(this);
		lblUsuario.setBounds(91, 66, 70, 21);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasea.setBounds(64, 131, 89, 20);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(150, 65, 195, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(150, 130, 195, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(173, 200, 113, 34);
		contentPane.add(btnEnviar);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblLogin.setBounds(183, 0, 61, 28);
		contentPane.add(lblLogin);
		
//		passwordField = new JPasswordField();
//		passwordField.setBounds(150, 68, 6, 20);
//		contentPane.add(passwordField);
		this.asignarEventos();
		
	}
	
	/**
	 * Se asignan los eventos de cada control
	 */
	private void asignarEventos()	{
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				esp.setUsuario(textField.getText());
				esp.setContrasenia(new String(textField_1.getPassword()));
				if(esp.login())	{
					Mensajes.mostrarDebug("Loggeado");
				}else	{
					Mensajes.mostrarError("Usuario y/o contraseña incorrectos", "Wake Up Brain");
				}
			}
		});
	}
	
}
