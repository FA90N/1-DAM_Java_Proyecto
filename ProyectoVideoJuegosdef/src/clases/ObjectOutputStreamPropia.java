package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamPropia extends ObjectOutputStream {
	
	public ObjectOutputStreamPropia(OutputStream out) throws IOException {
		super(out);
	}

	protected void writeStreamHeader() throws IOException	{
		// No hacer nada.	
	}

}
