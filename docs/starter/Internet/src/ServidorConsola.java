import acm.program.*;
import stanford.cs106.net.*;
import javax.swing.*;
import java.awt.event.*;

public class ServidorConsola extends ConsoleProgram implements SimpleServerListener {
	
	public void init() {	
		// Escucha peticiones y nos notifica cuando las recibimos
		SimpleServer servidor = new SimpleServer(this, 8080);
		servidor.start();
	}
	
	// Este metodo es llamado cuando recibimos una peticion
	public Object requestMade(Request peticion) {
		String comando = peticion.getCommand();
		if (comando.equals("imprimir")) {
			String mensaje = peticion.getParam("texto");
			println(mensaje);
			return "Mensaje recibido: " + mensaje;
		}
		return "Comando desconocido: " + comando;
	}
}
