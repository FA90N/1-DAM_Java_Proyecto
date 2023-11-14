package index;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Comparador;
import clases.Jugador;
import operaciones.Operar;

public class ListPlayer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnBorrar;
	private JButton btnDetalleD;
	private JButton btnDetalleF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPlayer frame = new ListPlayer();
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
	public ListPlayer() {
		setTitle("Listado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 536, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 //Color JFrame
        this.getContentPane().setBackground(Color.yellow);
		
		table = new JTable();
		//Click evento
	

		table.setBounds(24, 11, 377, 239);
		
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.setBounds(24, 11, 478, 198);
		contentPane.add(jscroll);
		
		//DefaultTableModel model = new DefaultTableModel(); editable
		
		//No editable
		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) { 
		  		return false; 
			}
		};

		model.addColumn("IdJugadores");
		model.addColumn("Nombre");
		model.addColumn("Apodo");
		model.addColumn("Puntos");
		table.setModel(model);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrar.setBounds(46, 234, 112, 39);
		contentPane.add(btnCerrar);
		table.removeColumn(table.getColumnModel().getColumn(0));
		
		File f=new File("src/ficheros/jugador.txt");
		List<Jugador> jugador=Operar.leerFichero(f);
			for(int i=0;i<jugador.size();i++) {
			model.addRow(new Object[]{jugador.get(i).getIdJugador(),jugador.get(i).getNombre(),jugador.get(i).getApodo(),jugador.get(i).getPuntos()});
			}
		
		
		
		
		
		
		
	}
}
