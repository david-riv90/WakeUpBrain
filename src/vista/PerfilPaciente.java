package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PerfilPaciente extends JFrame {

	private JPanel contentPane;
	private JTable tblLista;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PerfilPaciente frame = new PerfilPaciente();
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
	public PerfilPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tblLista = new JTable();
		tblLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido Paterno", "Apellido Materno", "Fecha de Nacimiento", "Grado Escolar", "Domicilio", "Telefono", "Tutor", "Observaciones"
			}
		));
		tblLista.getColumnModel().getColumn(1).setPreferredWidth(97);
		tblLista.getColumnModel().getColumn(2).setPreferredWidth(97);
		tblLista.getColumnModel().getColumn(3).setPreferredWidth(110);
		tblLista.getColumnModel().getColumn(4).setPreferredWidth(81);
		tblLista.getColumnModel().getColumn(7).setPreferredWidth(64);
		tblLista.getColumnModel().getColumn(8).setPreferredWidth(93);
		tblLista.setBounds(53, 51, 459, 211);
		contentPane.add(tblLista);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(120, 273, 104, 35);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(234, 273, 104, 35);
		contentPane.add(btnModificar);
		
		JButton btnDesabilitar = new JButton("Deshabilitar");
		btnDesabilitar.setBounds(359, 273, 98, 35);
		contentPane.add(btnDesabilitar);
		
		JLabel lblListaDePerfiles = new JLabel("Lista de perfiles");
		lblListaDePerfiles.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblListaDePerfiles.setBounds(197, 11, 205, 29);
		contentPane.add(lblListaDePerfiles);
	}
}
