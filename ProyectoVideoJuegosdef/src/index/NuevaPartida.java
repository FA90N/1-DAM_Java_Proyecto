package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Jugador;
import clases.Partida;
import clases.Videojuego;
import clases.masClase;
import funcion.Funcion;
import operaciones.Operar;

public class NuevaPartida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int n=0;
	private boolean siono=false;
	private Videojuego video;
	private boolean finalizado=false;

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public boolean isSiono() {
		return siono;
	}

	public void setSiono(boolean siono) {
		this.siono = siono;
	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			NewPartida dialog = new NewPartida(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public NuevaPartida(Partida p) {
		setBounds(100, 100, 375, 274);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.orange);
		setModal(true);
		
		JLabel Jugador = new JLabel("Jugador");
		Jugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		Jugador.setBounds(41, 30, 90, 26);
		contentPanel.add(Jugador);
		
		JLabel Videojuego = new JLabel("Videojuego");
		Videojuego.setFont(new Font("Tahoma", Font.BOLD, 14));
		Videojuego.setBounds(41, 73, 90, 26);
		contentPanel.add(Videojuego);
		
		JComboBox cBjugador = new JComboBox();
		cBjugador.setBounds(156, 34, 90, 22);
		contentPanel.add(cBjugador);
		File fj = new File("src/ficheros/jugador.txt");
		List <Jugador> j = Operar.leerFichero(fj);
		for(int i=0;i<j.size();i++) {
			cBjugador.addItem(j.get(i).getNombre());
		}
		
		JComboBox cBvideo = new JComboBox();
		cBvideo.setBounds(156, 77, 90, 22);
		contentPanel.add(cBvideo);
		File fv = new File("src/ficheros/videojuegos.txt");
		List <Videojuego> v = Operar.leerFichero(fv);
		for (int i=0;i<v.size();i++) {
			cBvideo.addItem(v.get(i).getNombre());
		}

		
		JLabel estado = new JLabel("");
		estado.setBounds(41, 110, 141, 22);
		contentPanel.add(estado);
		
		if(p!=null) {
			cBjugador.setSelectedItem(p.getJugador().getNombre());
			cBvideo.setSelectedItem(p.getVideojuego().getNombre());
			setN(p.getNivel());
			estado.setText("Estas en el nivel " + n);
			cBvideo.setEnabled(false);
			cBjugador.setEnabled(false);
				
		}
			
		
		JButton Jugar = new JButton("Jugar");
		Jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cBjugador.getSelectedItem()!=null && cBvideo.getSelectedItem()!=null) {
				if(p!=null && p.getNivel()==p.getVideojuego().getNivel()) {
					j.get(cBjugador.getSelectedIndex()).setPuntos(10);
					terminar(p);
					setFinalizado(true);
						
				}else {
					
						if(n>=0 && n!=v.get(cBvideo.getSelectedIndex()).getNivel()) {
							n++;
							if(p!=null) {
								n=p.getNivel()+1;
								estado.setText("Estas en el nivel " + n);
								cBvideo.setEnabled(false);
								cBjugador.setEnabled(false);
								j.get(cBjugador.getSelectedIndex()).setPuntos(1);
								p.setNivel(n);
							
							}else {
								estado.setText("Estas en el nivel " + n);
								cBvideo.setEnabled(false);
								cBjugador.setEnabled(false);
								j.get(cBjugador.getSelectedIndex()).setPuntos(1);
						}
					}else {
						j.get(cBjugador.getSelectedIndex()).setPuntos(10);
						finalizado(v.get(cBvideo.getSelectedIndex()));
					}
				}
				
				reescribirjugador(j.get(cBjugador.getSelectedIndex()),fj);
				
			}else {
				JOptionPane.showMessageDialog(NuevaPartida.this, "Rellena los elementos primero");
			}
			}

			

			
		});
		Jugar.setFont(new Font("Tahoma", Font.BOLD, 13));
		Jugar.setBounds(42, 143, 89, 23);
		contentPanel.add(Jugar);
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Guardar = new JButton("Guardar");
				Guardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					if(finalizado==false) {
						if(cBjugador.getSelectedItem()!=null && cBvideo.getSelectedItem()!=null) {
						guardar(p,j.get(cBjugador.getSelectedIndex()),v.get(cBvideo.getSelectedIndex()));
						
						}else {
						JOptionPane.showMessageDialog(NuevaPartida.this, "Rellena los elementos primero");
						}
					
					}else {
						
						dispose();
					}
					
					}
				});
				Guardar.setActionCommand("OK");
				buttonPane.add(Guardar);
				getRootPane().setDefaultButton(Guardar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		
		}
	
	}
	
	protected void guardar(Partida p, Jugador ju, Videojuego vi) {
		File fp = new File("src/ficheros/partidas.txt");
		int id = Funcion.generadorNum(fp);
	
		
		if(p!=null) {
			p.setNivel(n);
			p.setJugador(ju);
			p.setVideojuego(vi);
			List<Partida>part=Operar.leerFichero(fp);
			int num= part.indexOf(p);
			part.set(num, p);
			fp.delete();
			for(int i=0;i<part.size();i++) {
				Operar.guardarFichero(part.get(i), fp);
				}
		}else {
			
			Partida partida = new Partida(id,ju,vi,n);
			Operar.guardarFichero(partida, fp);
	
			setSiono(true);
		}
		JOptionPane.showMessageDialog(NuevaPartida.this, "Guardado correctamente");
		dispose();
		
	}

	private void finalizado(Videojuego v) {
		JOptionPane.showMessageDialog(NuevaPartida.this, "Enhorabuena has superado " + v.getNombre());
		setFinalizado(true);
		File fm = new File("src/ficheros/masjugado.txt");
		masClase ms = new masClase(v,1);
		if(fm.exists()) {
			List <masClase> lista = Operar.leerFichero(fm);
			fm.delete();
			
			boolean b=false;
			
			for(int i=0;i<lista.size();i++) {
				if(lista.get(i).getVideojuego().getNombre().equalsIgnoreCase(v.getNombre())) {
					lista.get(i).sumaJuga();
					b=true;
				}
				
				Operar.guardarFichero(lista.get(i), fm);
			}
			
			if(b==false)
			Operar.guardarFichero(ms, fm);
			
			
		}else {
			
			Operar.guardarFichero(ms, fm);
		}
		dispose();
		
	}
	
	public void terminar(Partida p) {
		JOptionPane.showMessageDialog(NuevaPartida.this, "Enhorabuena has superado " + p.getVideojuego().getNombre());
		File fm = new File("src/ficheros/masjugado.txt");
		masClase ms = new masClase(p.getVideojuego(),1);
		if(fm.exists()) {
			List <masClase> lista = Operar.leerFichero(fm);
			fm.delete();
			
			boolean b=false;
			
			for(int i=0;i<lista.size();i++) {
				if(lista.get(i).getVideojuego().getNombre().equalsIgnoreCase(p.getVideojuego().getNombre())) {
					lista.get(i).sumaJuga();
					b=true;
				}
				
				Operar.guardarFichero(lista.get(i), fm);
			}
			
			if(b==false)
			Operar.guardarFichero(ms, fm);
			
			
		}else {
			
			Operar.guardarFichero(ms, fm);
		}
		
		File par= new File("src/ficheros/partidas.txt");
		List <Partida>parti = Operar.leerFichero(par);
		parti.remove((Object)p);
		par.delete();
		for(int i=0;i<parti.size();i++) {
			Operar.guardarFichero(parti.get(i), par);
		}
		dispose();
	}

	
	public void reescribirjugador(Jugador j,File f) {
		List <Jugador> player = Operar.leerFichero(f);
		f.delete();
		int n=player.indexOf(j);
		player.set(n, j);
		for(int i=0;i<player.size();i++) {
			
			Operar.guardarFichero(player.get(i), f);
		}
		
	}
	
}
