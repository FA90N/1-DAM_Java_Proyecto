package index;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.masClase;
import operaciones.Operar;

public class Masjugado extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Masjugado frame = new Masjugado();
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
	public Masjugado() {
		setTitle("Videojuego MasJugado de 2 de marzo de 2023 ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.yellow);
		table = new JTable();
		//Click evento
	

		table.setBounds(24, 11, 377, 239);
		
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.setBounds(10, 11, 414, 181);
		contentPane.add(jscroll);
		//DefaultTableModel model = new DefaultTableModel(); editable
		
		//No editable
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) { 
		  		return false; 
			}
		};
		model.addColumn("Objeto");
		model.addColumn("VideoJuegos");
		model.addColumn("NºJugadores");
		
		table.setModel(model);
		
		JButton Cerrar = new JButton("Cerrar");
		Cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		Cerrar.setBounds(160, 203, 108, 36);
		contentPane.add(Cerrar);
		table.removeColumn(table.getColumnModel().getColumn(0));
		
		File f=new File("src/ficheros/masjugado.txt");
		List<masClase> mc=Operar.leerFichero(f);
			for(int i=0;i<mc.size();i++) {
			model.addRow(new Object[]{mc.get(i),mc.get(i).getVideojuego().getNombre(),mc.get(i).getNumJugador()});
			}
		
		
		
		
		
	}
}
