package clases;

import java.io.Serializable;

public class masClase implements Serializable{
	private Videojuego videojuego;
	private int numJugador;
	public masClase(Videojuego videojuego, int numJugador) {
		this.videojuego = videojuego;
		this.numJugador = numJugador;
	}
	public masClase() {
		
	}
	public Videojuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	public int getNumJugador() {
		return numJugador;
	}
	
	public void setNumJugador(int numJugador) {
		this.numJugador = numJugador;
	}
	@Override
	public String toString() {
		return "videojuego=" + videojuego + ", numJugador=" + numJugador;
	}
	
	public void sumaJuga() {
		this.numJugador=this.numJugador+1;
	}
	
	
	
	

}
