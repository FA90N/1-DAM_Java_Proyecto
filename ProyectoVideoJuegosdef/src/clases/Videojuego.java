package clases;

import java.io.Serializable;

public class Videojuego implements Serializable{
	//Atributos
	private int idVideojuego;
	private String nombre;
	private int nivel;
	private String dificultad;
	//Constructores
	public Videojuego(int idVideojuego, String nombre, int nivel, String dificultad) {
		
		this.idVideojuego = idVideojuego;
		this.nombre = nombre;
		this.nivel = nivel;
		this.dificultad = dificultad;
	}
	
	public Videojuego() {
		
	}

	//Getters and Setters
	public int getIdVideojuego() {
		return idVideojuego;
	}
	public void setIdVideojuego(int idVideojuego) {
		this.idVideojuego = idVideojuego;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	//To String
	@Override
	public String toString() {
		return "idVideojuego=" + idVideojuego + ", nombre=" + nombre + ", nivel=" + nivel + ", dificultad="
				+ dificultad ;
	}

	@Override
	public boolean equals(Object obj) {
		Videojuego vi= (Videojuego) obj;
		if(this.idVideojuego==vi.idVideojuego) {
			return true;
		}
		return false;
	}
	
	
	
	
}
