package operaciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import clases.Jugador;
import clases.ObjectOutputStreamPropia;
import funcion.Funcion;

public class Operar {
	
	public static void guardarFichero (Object o, File f) {

		ObjectOutputStream oos=null;
		try {
			if(f.exists())
				oos = new ObjectOutputStreamPropia(new FileOutputStream(f,true));
			else
				oos = new ObjectOutputStream(new FileOutputStream(f,true));
	
			oos.writeObject(o);
			
		}catch(Exception e){
	
		}finally {
			try {
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static List leerFichero (File f) {
		
		List objeto = new ArrayList();
		ObjectInputStream ois = null;
		Object aux = null;
		if(f.exists()) {
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			do{
				
				try {
					aux = ois.readObject();
					objeto.add(aux);
				}catch (EOFException e) {
					aux=null;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}while (aux!=null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
			
	return objeto;
}

}
