package index;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Jugador;
import funcion.Funcion;

public class NewPlayer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textapodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewPlayer dialog = new NewPlayer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewPlayer() {
		setTitle("Nuevo Jugador");
		setModal(true);
		setBounds(100, 100, 339, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.yellow);
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNombre.setBounds(10, 38, 105, 31);
			contentPanel.add(lblNombre);
		}
		
		textnombre = new JTextField();
		textnombre.setBounds(95, 40, 149, 31);
		contentPanel.add(textnombre);
		textnombre.setColumns(10);
		
		textapodo = new JTextField();
		textapodo.setBounds(95, 97, 149, 31);
		contentPanel.add(textapodo);
		textapodo.setColumns(10);
		
		JLabel lblApodo = new JLabel("Apodo");
		lblApodo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApodo.setBounds(10, 95, 77, 31);
		contentPanel.add(lblApodo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton guardar = new JButton("Guardar");
				buttonPane.add(guardar);
				guardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!textnombre.getText().trim().equalsIgnoreCase("") && !textapodo.getText().trim().equalsIgnoreCase("")) {
							File f= new File("src/ficheros/jugador.txt");
							int n=Funcion.generadorNum(f);
							Jugador j = new Jugador(n,textnombre.getText(), textapodo.getText());
							operaciones.Operar.guardarFichero(j,f);
							JOptionPane.showMessageDialog(NewPlayer.this, "Guardado correctamente");
							textnombre.setText("");
							textapodo.setText("");
							
						}else {
							JOptionPane.showMessageDialog(NewPlayer.this, "Introduzca datos correctos");
							
						}
						
						
					}
				});
				getRootPane().setDefaultButton(guardar);
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
