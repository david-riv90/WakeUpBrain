package vista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Especialista;
import dvx.error.Mensajes;
import java.awt.Dimension;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JButton btnEnviar; 
	private JLabel lblNewLabel_2;
	
//	private JPasswordField passwordField;
	Especialista esp = new Especialista();

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Iris\\Pictures\\Imagen1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 505, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblUsuario.setLabelFor(this);
		lblUsuario.setBounds(120, 92, 70, 21);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblContrasea.setBounds(93, 147, 89, 20);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField("admin");
		txtUsuario.setBounds(179, 91, 195, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasenia = new JPasswordField("pass");
		txtContrasenia.setBounds(179, 146, 195, 26);
		contentPane.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(179, 196, 113, 34);
		contentPane.add(btnEnviar);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setSize(new Dimension(50, 50));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\GitHub\\WakeUpBrain\\img\\Principal~1.png"));
		lblNewLabel_2.setBounds(0, 0, 500, 316);
		contentPane.add(lblNewLabel_2);
		
		this.asignarEventos();
		
	}
	
	/**
	 * Se asignan los eventos de cada control de la ventana
	 */
	private void asignarEventos()	{
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				esp.setUsuario(txtUsuario.getText());
				esp.setContrasenia(new String(txtContrasenia.getPassword()));
				if(!esp.login())	{
					Mensajes.mostrarError("Usuario y/o contraseña incorrectos", "Wake Up Brain");
				}else	{
					//# Se da acceso a la aplicación
					Principal p = new Principal();
					//# Evitar el uso de la ventana padre
					p.setModalityType(ModalityType.APPLICATION_MODAL);
					p.setVisible(true);
				}
			}
		});
	}
	
}
