package index;

import java.awt.Color;
import java.awt.EventQueue;
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

import clases.Comparador1;
import clases.Videojuego;
import operaciones.Operar;

public class GameMenu extends JFrame {

	private JPanel contentPane;
	private JButton Nuevo;
	private JButton Modificar;
	private JButton Borrar;
	private DefaultTableModel model;
	private JTable table;
	private List <Videojuego>v;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMenu frame = new GameMenu();
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
	public GameMenu() {
		setTitle("Menu VideoJuego");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 //Color JFrame
        this.getContentPane().setBackground(Color.orange);
		
		table = new JTable();
		//Click evento
	

		table.setBounds(24, 11, 377, 239);
		
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.setBounds(10, 11, 314, 239);
		contentPane.add(jscroll);
		
		
		//DefaultTableModel model = new DefaultTableModel(); editable
		
		//No editable
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) { 
		  		return false; 
			}
		};
		model.addColumn("Objeto");
		model.addColumn("IdVideojuego");
		model.addColumn("Nombre");
		model.addColumn("Niveles");
		model.addColumn("Dificultad");
		table.setModel(model);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.removeColumn(table.getColumnModel().getColumn(0));
		
		rellenarows();
		
		
		Nuevo = new JButton("Nuevo");
		Nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewGame vj = new NewGame (null);
				vj.setVisible(true);
					if(vj.isSiono()) {
							model.setNumRows(0);
							rellenarows();
						
					}
				
			}
		});
		Nuevo.setBounds(335, 26, 89, 23);
		contentPane.add(Nuevo);
		
		Modificar = new JButton("Modificar");
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Selecciona un usuario");
				
				}else {
					
					Videojuego video =(Videojuego) (table.getModel().getValueAt(table.getSelectedRow(), 0));
					NewGame ng = new NewGame(video);
					ng.setVisible(true);
					model.setNumRows(0);
					rellenarows();
				}
				
			}
		});
		Modificar.setBounds(335, 176, 89, 23);
		contentPane.add(Modificar);
		
		Borrar = new JButton("Borrar");
		Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()!=-1)
				{
					if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Estás seguro de que quieres borrar?","Borrar curso",JOptionPane.YES_NO_OPTION))
					{
						Videojuego video =(Videojuego) (table.getModel().getValueAt(table.getSelectedRow(), 0));
						model.removeRow(table.getSelectedRow());
						File f= new File("src/ficheros/videojuegos.txt");
						v.remove(video);
						if(f.exists()) {
							f.delete();
						}
						for (int i=0;i<v.size();i++) {
							Operar.guardarFichero(v.get(i), f);
						}
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecciona un usuario");
				}
				
			}
		});
		Borrar.setBounds(334, 227, 89, 23);
		contentPane.add(Borrar);
		
		
		
	}
	public void rellenarows() {
		File f = new File("src/ficheros/videojuegos.txt");
		v=Operar.leerFichero(f);
		Collections.sort(v,new Comparador1());
		for (int i=0;i<v.size();i++) {
			model.addRow(new Object[] {v.get(i),v.get(i).getIdVideojuego(),v.get(i).getNombre(),v.get(i).getNivel(),v.get(i).getDificultad()});
		}
	}
}
