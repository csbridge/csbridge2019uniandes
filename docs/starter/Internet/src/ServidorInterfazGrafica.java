/* File: Trivia.java
 * -----------------
 * This file is the server program for a Trivia game. It listens
 * for votes coming in over the network via Requests, and counts
 * up the votes it receives. It allows the user of this program
 * to reset the votes (by posting a new question) and display
 * the votes.
 */

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;
import stanford.cs106.net.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class ServidorInterfazGrafica extends GraphicsProgram implements SimpleServerListener {
	
	public void init() {
		// Listens for requests and notifies us when we receive a Request
		SimpleServer servidor = new SimpleServer(this, 8080);
		servidor.start();
		addMouseListeners();
	}
	
	// This method is called whenever a request is received.
	public Object requestMade(Request request) {
		double x, y, width, height;
		try {
			x = Double.parseDouble(request.getParam("x"));
			y = Double.parseDouble(request.getParam("y"));
			width = Double.parseDouble(request.getParam("width"));
			height = Double.parseDouble(request.getParam("height"));
		} catch (Exception e) {
			return "Argumento(s) invalido(s).";
		}
		int red = Integer.parseInt((request.getParam("red")));
		int green = Integer.parseInt((request.getParam("green")));
		int blue = Integer.parseInt((request.getParam("blue")));
		
		String command = request.getCommand();
		GObject obj;
		if (command.equals("SRect")) {
			obj = new GRect(x, y, width, height);
			((GRect)obj).setFilled(true);
		} else if (command.equals("SOvalo")) {
			obj = new GOval(x, y, width, height);
			((GOval)obj).setFilled(true);
		} else {
			return "Comando desconocido.";
		}
		obj.setColor(new Color(red, green, blue));
		add(obj);
		return "Exito";
	}
	
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		GObject obj = getElementAt(x, y); 
		if (obj != null) {
			remove(obj);
		}
	}
}
