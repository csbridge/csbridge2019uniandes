import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class EsGraphics extends GraphicsProgram{

	private RandomGenerator rg = new RandomGenerator();

	public void agregar(SObjeto obj) {
		add((GObject)obj);
	}
	
	public void quitar(SObjeto obj) {
		remove((GObject)obj);
	}
	
	public void quitarTodo() {
		removeAll();
	}
	
	public void mouseMoved(MouseEvent e) {
		ratonMovido(e);
	}
	
	public void ratonMovido(MouseEvent e) {
		// to overload
	}
	
	public void agregar(GObject obj, double x, double y) {
		add(obj, x, y);
	}
	
	public void esperarClic() {
		waitForClick();
	}
	
	public void agregarMouseListeners() {
		addMouseListeners();
	}
	
	public double darAncho() {
		return getWidth();
	}
	
	public double darAltura() {
		return getHeight();
	}
	
	public SObjeto darObjectoA(double x, double y) {
		return (SObjeto)getElementAt(x, y);
	}
	
	public void imprimir(String s) {
		println(s);
	}
	
	public void pausa(double ms) {
		pause(ms);
	}

	public void imprimir(double d) {
		println(d);
	}

	public int leerInt(String prompt) {
		return readInt(prompt);
	}

	public double leerDouble(String prompt) {
		return readDouble(prompt);
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
