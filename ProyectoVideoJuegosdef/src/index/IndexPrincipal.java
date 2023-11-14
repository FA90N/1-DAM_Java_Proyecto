package index;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Jugador;
import operaciones.Operar;

public class IndexPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexPrincipal frame = new IndexPrincipal();
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

        
       

   
	public IndexPrincipal() {

		setTitle("Videojuego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 227);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnJugadores = new JMenu("Jugadores");
		menuBar.add(mnJugadores);
		
		JMenuItem Nuevo = new JMenuItem("Nuevo");
		Nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewPlayer fnuevo = new NewPlayer();
				fnuevo.setVisible(true);
			}
		});
		mnJugadores.add(Nuevo);
		
		JMenuItem Listado = new JMenuItem("Listado");
		Listado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPlayer flistado = new ListPlayer();
				flistado.setVisible(true);
			}
		});
		mnJugadores.add(Listado);
		
		JMenuItem Reset = new JMenuItem("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("src/ficheros/partidas.txt");
				if(f.exists()) {
					f.delete();
				}
				
				File fi = new File ("src/ficheros/jugador.txt");
				List<Jugador>j=Operar.leerFichero(fi);
				if(fi.exists()) {
					fi.delete();
				}
				
				for (Jugador ju:j) {
					ju.inicializar();
					operaciones.Operar.guardarFichero(ju,fi);
				}
				
				JOptionPane.showMessageDialog(IndexPrincipal.this, "Reseteado correctamente");
			}
		});
		mnJugadores.add(Reset);
		
		JMenu mnVideojuegos = new JMenu("Videojuegos");
		mnVideojuegos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		menuBar.add(mnVideojuegos);
		
		JMenuItem GameMenu = new JMenuItem("GameMenu");
		GameMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameMenu mv = new GameMenu();
				mv.setVisible(true);
			}
		});
		mnVideojuegos.add(GameMenu);
		
		JMenuItem masjugado = new JMenuItem("Mas Jugado");
		masjugado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Masjugado mj= new Masjugado();
				mj.setVisible(true);
				
			}
		});
		mnVideojuegos.add(masjugado);
		
		JMenu mnPartidas = new JMenu("Partidas");
		mnPartidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListPartida p = new ListPartida();
				p.setVisible(true);
				
			}
		});
		menuBar.add(mnPartidas);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		menuBar.add(mnSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setBackground(Color.pink);
	}

}
