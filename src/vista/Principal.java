package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
