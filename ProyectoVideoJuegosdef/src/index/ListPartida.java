package index;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Comparador1;
import clases.Partida;
import clases.Videojuego;
import operaciones.Operar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListPartida extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	private JTable table;
	private List <Partida>p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPartida frame = new ListPartida();
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
	public ListPartida() {
		setTitle("Menu partidas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 //Color JFrame
        this.getContentPane().setBackground(Color.pink);
		table = new JTable();
		//Click evento
	

		table.setBounds(24, 11, 377, 239);
		
		
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.setBounds(10, 11, 314, 205);
		contentPane.add(jscroll);
		
		
		//DefaultTableModel model = new DefaultTableModel(); editable
		
		//No editable
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) { 
		  		return false; 
			}
		};
		model.addColumn("Objeto");
		model.addColumn("IdPartida");
		model.addColumn("Jugador");
		model.addColumn("Videojuego");
		model.addColumn("Nivel");
		table.setModel(model);
		
		JButton Nuevo = new JButton("Nuevo");
		Nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaPartida np = new NuevaPartida(null);
				np.setVisible(true);
				if(np.isSiono()) {
					model.setNumRows(0);
					rellenarows();
				}
			}
		});
		Nuevo.setBounds(335, 25, 89, 23);
		contentPane.add(Nuevo);
		
		JButton Continuar = new JButton("Continuar Partida");
		Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Selecciona una partida");
				
				}else {
					File f = new File("src/ficheros/partidas.txt");
					List<Partida>p=Operar.leerFichero(f);
					Partida partida =(Partida) (table.getModel().getValueAt(table.getSelectedRow(), 0));
					NuevaPartida ng = new NuevaPartida(partida);
					ng.setVisible(true);
					model.setNumRows(0);
					rellenarows();
				}
				
			}
		});
		Continuar.setBounds(235, 227, 158, 23);
		contentPane.add(Continuar);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.removeColumn(table.getColumnModel().getColumn(0));
		rellenarows();
	}
	
	public void rellenarows() {
		File f = new File("src/ficheros/partidas.txt");
		p=Operar.leerFichero(f);
		
		for (int i=0;i<p.size();i++) {
			model.addRow(new Object[] {p.get(i),p.get(i).getIdPartida(),p.get(i).getJugador().getNombre(),p.get(i).getVideojuego().getNombre(),p.get(i).getNivel()});
			}
		
		
	}
}
