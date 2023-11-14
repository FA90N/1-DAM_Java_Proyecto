package clases;

import java.util.Comparator;

public class Comparador1 implements Comparator<Videojuego>{

	@Override
	public int compare(Videojuego o1, Videojuego o2) {
		if(o1.getNombre().compareTo(o2.getNombre())>1) {
			return 1;
		}else if(o1.getNombre().compareTo(o2.getNombre())<1) {
			return -1;
		}
		return 0;
		
		
	}

}
