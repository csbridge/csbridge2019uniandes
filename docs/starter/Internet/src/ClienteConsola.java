import acm.program.*;
import stanford.cs106.net.*;
import java.awt.event.*;
import javax.swing.*;

public class ClienteConsola extends ConsoleProgram {
	
	// La direccion del programa servidor
	private static final String HOST = "https://4688f07a.ngrok.io";
	
	public void init() {
		SimpleClient cliente = new SimpleClient(HOST);
		
		while (true) {
			String linea = getLine("Que quieres decir? ");
			Request peticion = new Request("imprimir");
			peticion.addParam("texto", linea);
			println(cliente.makeRequest(peticion));
		}
	}
}
