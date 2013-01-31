package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import modelo.Tutor;

public class Tutores extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApPaterno;
	private JTextField txtApMaterno;
	JButton btnIngresar;
	JButton btnModificar;
	JButton btnEliminar;

	
	
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
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblApelidoPaterno = new JLabel("Apelido Paterno");
		lblApelidoPaterno.setForeground(Color.BLUE);
		lblApelidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setForeground(Color.BLUE);
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
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
		
		btnEliminar = new JButton("Eliminar");
		
		JTextArea textArea = new JTextArea();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(163)
					.addComponent(lblBienvenido)
					.addContainerGap(137, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnIngresar)
								.addGap(27)
								.addComponent(btnModificar)
								.addGap(27)
								.addComponent(btnEliminar)
								.addGap(81))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblApellidoMaterno)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtApMaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNombre)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblApelidoPaterno)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtApPaterno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(144, Short.MAX_VALUE))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBienvenido)
					.addGap(59)
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
						.addComponent(btnEliminar))
					.addGap(18)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		//# Asignar los eventos de los controles
		this.asignarEventos();
	}
	
	/**
	 * Se asignan los eventos de cada control de la ventana
	 */
	private void asignarEventos()	{
		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tutor t = new Tutor();
				t.setNombre(txtNombre.getText());
				t.setApaterno(txtApPaterno.getText());
				t.setAmaterno(txtApMaterno.getText());
				t.insertar();
			}
		});
	}
}
