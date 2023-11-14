package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import clases.Videojuego;
import funcion.Funcion;
import operaciones.Operar;

public class NewGame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean siono = false;

	public boolean isSiono() {
		return siono;
	}

	public void setSiono(boolean siono) {
		this.siono = siono;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewGame dialog = new NewGame(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewGame(Videojuego v) {
		setTitle("Nuevos Videojuegos");
		setModal(true);
		setBounds(100, 100, 326, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.PINK);
		{
			JLabel Nombre = new JLabel("Nombre");
			Nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			Nombre.setBounds(10, 11, 77, 26);
			contentPanel.add(Nombre);
		}

		JLabel Niveles = new JLabel("Niveles");
		Niveles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Niveles.setBounds(10, 59, 77, 26);
		contentPanel.add(Niveles);

		JLabel Dificultad = new JLabel("Dificultad");
		Dificultad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dificultad.setBounds(10, 109, 77, 26);
		contentPanel.add(Dificultad);

		JTextPane textnombre = new JTextPane();
		textnombre.setBounds(97, 11, 138, 26);
		contentPanel.add(textnombre);

		JComboBox comboNivel = new JComboBox();
		comboNivel
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboNivel.setBounds(97, 63, 38, 22);
		contentPanel.add(comboNivel);

		JComboBox comboDificultad = new JComboBox();
		comboDificultad.setModel(new DefaultComboBoxModel(new String[] { "Baja", "Media", "Alta" }));
		comboDificultad.setBounds(97, 113, 63, 22);
		contentPanel.add(comboDificultad);
		
		if(v!=null){
			String ni=v.getNivel()+"";
			textnombre.setText(v.getNombre());
			comboNivel.setSelectedItem(ni);
			comboDificultad.setSelectedItem(v.getDificultad());
			
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Guardar = new JButton("Guardar");

				Guardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if (!textnombre.getText().trim().equalsIgnoreCase("")) {
							File f = new File("src/ficheros/videojuegos.txt");
							int n = Funcion.generadorNum(f);
							String nombre = textnombre.getText();
							int nivel = Integer.parseInt((String) comboNivel.getSelectedItem());
							String dificultad = (String) comboDificultad.getSelectedItem();
							if(v!=null) {
								
								v.setNombre(nombre);
								v.setDificultad(dificultad);
								v.setNivel(nivel);
								List<Videojuego>video=Operar.leerFichero(f);
								int n1=video.indexOf(v);
								video.set(n1, v);
								f.delete();
								for(int i=0;i<video.size();i++) {
									Operar.guardarFichero(video.get(i), f);
								}
								
							}else {
								Videojuego v = new Videojuego(n, nombre, nivel, dificultad);
								Operar.guardarFichero(v, f);
								JOptionPane.showMessageDialog(NewGame.this, "Guardado correctamente");
								setSiono(true);
								
							}
							dispose();

						} else {
							JOptionPane.showMessageDialog(NewGame.this, "Introduzca El nombre");
							setSiono(false);
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
}
