package clases;

import java.io.Serializable;
import java.util.List;

public class Partida implements Serializable{
	private int idPartida;
	private Jugador jugador;
	private Videojuego videojuego;
	private int nivel;
	
	public Partida(int idPartida, Jugador jugador, Videojuego videojuego, int nivel) {
		super();
		this.idPartida = idPartida;
		this.jugador = jugador;
		this.videojuego = videojuego;
		this.nivel = nivel;
	}
	


	public int getIdPartida() {
		return idPartida;
	}


	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}


	


	public Jugador getJugador() {
		return jugador;
	}



	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}



	public Videojuego getVideojuego() {
		return videojuego;
	}



	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}



	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	@Override
	public String toString() {
		return "Partida [idPartida=" + idPartida + ", jugador=" + jugador + ", videojuego=" + videojuego + ", nivel="
				+ nivel + "]";
	}



	@Override
	public boolean equals(Object obj) {
		Partida pa= (Partida) obj;
		if(this.idPartida==pa.idPartida) {
			return true;
		}
		return false;
	}
	
	

	
	
	
}
