package funcion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Funcion {
	
	public static boolean correcto (String s) {
		
		try {
			Integer.parseInt(s);
				return true;	
		}catch (Exception e) {
			
		}
		return false;
	}
	
	
	public static int generadorNum(File f) {
		int id=0;
		if(f.exists())
		{
			//lo abro y cuento cuantos objetos tiene
			ObjectInputStream ois=null;
			int cont=0;
			try {
				ois = new ObjectInputStream(new FileInputStream(f));
				Object aux=null;
				do
				{
					try {
						aux = ois.readObject();
						cont++;
					}
					catch (EOFException e) {
						aux=null;
					}
				}while (aux!=null);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					ois.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			id = cont;
		}
		return (id+1);
	}

}
