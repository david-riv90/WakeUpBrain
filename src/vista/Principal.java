package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Principal extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


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
		btnActividad.setBounds(456, 41, 121, 33);
		contentPane.add(btnActividad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(44, 41, 121, 34);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 635, 331);
		contentPane.add(label);
	}
}
