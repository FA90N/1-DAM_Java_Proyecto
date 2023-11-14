package clases;

import java.io.Serializable;

public class Jugador implements Serializable{
	//Atributos
	private int idJugador;
	private String nombre;
	private String apodo;
	private int puntos;
	//Constructor
	public Jugador(int idJugador,String nombre, String apodo) {
	
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.apodo = apodo;
		this.puntos = 0;
	}
	
	public Jugador() {
		this.puntos = 0;
	}
	//Metodos
	public void inicializar () {
		this.puntos=0;
	}
	
	public void sumarPuntos (int p) {
		this.puntos=this.puntos+p;
	}
	//Getter and Setters
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = this.puntos+puntos;
	}
	//To String
	@Override
	public String toString() {
		return "idJugador=" + idJugador + ", apodo=" + apodo + ", puntos=" + puntos;
	}

	@Override
	public boolean equals(Object obj) {
		Jugador juga= (Jugador)obj;
		if(this.idJugador==juga.idJugador) {
			return true;
		}
		return false;
	}
	
	
	

}
