package espl;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public abstract class EsGraphics extends GraphicsProgram{

	private RandomGenerator rg = new RandomGenerator();

	public ArrayList<String> leerArchivo(String name) {
		try {
			Scanner input = new Scanner(new File(name));
			ArrayList<String> labelsList = new ArrayList<String>();
			while (input.hasNextLine()) {
				String line = input.nextLine();
				labelsList.add(line);
			}
			input.close();
			return labelsList;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* EsGraphics metodos. */
	public void agregar(SObjeto obj) {
		add((GObject)obj);
	}
	public void agregar(SObjeto obj, double x, double y) {
		add((GObject)obj, x, y);
	}
	public void quitar(SObjeto obj) { remove((GObject)obj); }
	public void quitarTodo() {removeAll();}
	
	public double darAncho() { return getWidth(); }
	public double darAlto() { return getHeight(); }
	public SObjeto darObjetoEn(double x, double y) {
		return (SObjeto)getElementAt(x, y);
	}
	
	public void cambiarFondo(Color c) {setBackground(c);}
	public void esperarClic() { waitForClick();}
	public void pausa(double ms) { pause(ms);}
	
	/* Listeners de raton. */
	public void agregarMouseListeners() {addMouseListeners();}

	public void mouseMovido(MouseEvento e) { /* overload */ }
	public void mouseArrastrado(MouseEvento e) { /* overload */ }
	public void mouseClickeado(MouseEvento e) { /* overload */ }
	public void mouseSoltado(MouseEvento e) { /* overload */ }
	public void mousePulsado(MouseEvento e) { /* overload */ }
	public void mouseSale(MouseEvento e) { /* overload */ }
	public void mouseEntra(MouseEvento e) { /* overload */ }
	
	public void mouseClicked(MouseEvent e) { 
		mouseClickeado(new MouseEvento(e)); 
	}
	public void mouseMoved(MouseEvent e) { 
		mouseMovido(new MouseEvento(e)); 
	}
	public void mouseDragged(MouseEvent e) { 
		mouseArrastrado(new MouseEvento(e)); 
	}
	public void mouseEntered(MouseEvent e) { 
		mouseEntra(new MouseEvento(e)); 
	}
	public void mouseExited(MouseEvent e) { 
		mouseSale(new MouseEvento(e)); 
	}
	public void mousePressed(MouseEvent e) { 
		mousePulsado(new MouseEvento(e)); 
	}
	public void mouseReleased(MouseEvent e) { 
		mouseSoltado(new MouseEvento(e)); 
	}

	public void agregarTeclaListeners() {addMouseListeners();}

	public void	teclaPulsada(KeyEvent e) { /* overload */ }
	public void	teclaSoltada(KeyEvent e) { /* overload */ }
	public void	teclaEspichada(KeyEvent e) { /* overload */ }

	public void	keyPressed(KeyEvent e) { teclaPulsada(e); }
	public void	keyReleased(KeyEvent e) { teclaSoltada(e); }
	public void	keyTyped(KeyEvent e) { teclaEspichada(e); }
	

	/* Cosas de EsConsole se necesita aqui tambien. */
	public void imprimir(String s) {
		println(s);
	}
	
	public void imprimir(double d) {println(d);}

	public void imprimir(int i) {
		println(i);
	}

	public void imprimirEnLinea(String s) {
		print(s);
	}
	
	public void imprimirEnLinea(double d) {
		print(d);
	}

	public void imprimirEnLinea(int i) {
		print(i);
	}
	
	public int intAleatorio() {
		return rg.nextInt();
	}
	
	public int intAleatorio(int max) {
		return rg.nextInt(max);
	}
	
	public int intAleatorio(int min, int max) {
		return rg.nextInt(min, max);
	}
	
	public double doubleAleatorio() {
		return rg.nextDouble();
	}
	
	public double doubleAleatorio(double min, double max) {
		return rg.nextDouble(min, max);
	}
	
	public Color colorAleatorio() {
		return rg.nextColor();
	}
	
	public boolean booleanAleatorio() {
		return rg.nextBoolean();
	}
	
	public boolean booleanAleatorio(double p) {
		return rg.nextBoolean(p);
	}
}
