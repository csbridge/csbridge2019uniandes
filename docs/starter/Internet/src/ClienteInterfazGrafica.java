import acm.program.*;
import stanford.cs106.net.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class ClienteInterfazGrafica extends ConsoleProgram {
	
	private static final String HOST = "https://4688f07a.ngrok.io";
	
	JTextField userX;
	JTextField userY;
	JTextField userAncho;
	JTextField userAlto;
	
	Color color;
	
	// The client object we use to send Requests over the Internet
	private SimpleClient client;
	
	public void init() {
		client = new SimpleClient(HOST);
		color = Color.BLACK;
		
		// Add interactors
		add(new JLabel("x: "), NORTH);
		userX = new JTextField(5);
		add(userX, NORTH);
		
		add(new JLabel("y: "), NORTH);
		userY = new JTextField(5);
		add(userY, NORTH);
		
		add(new JLabel("ancho: "), NORTH);
		userAncho = new JTextField(5);
		add(userAncho, NORTH);
		
		add(new JLabel("alto: "), NORTH);
		userAlto = new JTextField(5);
		add(userAlto, NORTH);
		
		add(new JButton("elige un color"), NORTH);
		
		add(new JButton("SRect"), SOUTH);
		add(new JButton("SOvalo"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("elige un color")) {
			Color chosenColor = JColorChooser.showDialog(this, "Elige un color", Color.BLACK);
			if (chosenColor != null) {
				color = chosenColor;
			}
			return;
		}
		
		// When the user clicks a button, send a new Request with our vote.
		Request request = new Request(command);
		double x, y, width, height;
		try {
			x = Double.parseDouble(userX.getText());
		} catch (Exception e) {
			println("Coordenada x es invalida. Reemplazando con 0");
			x = 0;
		}
		try {
			y = Double.parseDouble(userY.getText());
		} catch (Exception e) {
			println("Coordenada y es invalida. Reemplazando con 0");
			y = 0;
		}
		try {
			width = Double.parseDouble(userAncho.getText());
		} catch (Exception e) {
			println("Ancho es invalido. Reemplazando con 50");
			width = 50;
		}
		try {
			height = Double.parseDouble(userAlto.getText());
		} catch (Exception e) {
			println("Alto es invalido. Reemplazando con 50");
			height = 50;
		}
		
		request.addParam("x", "" + x);
		request.addParam("y", "" + y);
		request.addParam("width", "" + width);
		request.addParam("height", "" + height);
		
		int red = color == null ? 0 : color.getRed();
		int green = color == null ? 0 : color.getGreen();
		int blue = color == null ? 0 : color.getBlue();
		
		request.addParam("red", "" + red);
		request.addParam("green", "" + green);
		request.addParam("blue", "" + blue);
		
		String response = client.makeRequest(request);
		println(response);
	}
}
