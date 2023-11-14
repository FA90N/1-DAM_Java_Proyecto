package clases;

import java.util.Comparator;

public class Comparador implements Comparator<Jugador>{

	@Override
	public int compare(Jugador o1, Jugador o2) {
		
		if(o1.getPuntos()>=o2.getPuntos()) {
			return -1;
		}else if(o1.getPuntos()<=o2.getPuntos()) {
			return 1;
		}
		
		return 0;
	}

}
