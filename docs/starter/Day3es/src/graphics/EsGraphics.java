package graphics;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public abstract class EsGraphics extends GraphicsProgram{

	private RandomGenerator rg = new RandomGenerator();

	/* Agregar y quitar. */
	public void agregar(SObjeto obj) {
		add((GObject)obj);
	}
	
	public void agregar(SObjeto obj, double x, double y) {
		add((GObject)obj, x, y);
	}
	
	public void quitar(SObjeto obj) {
		remove((GObject)obj);
	}
	
	public void quitarTodo() {
		removeAll();
	}

	public void cambiarFondo(Color c) {
		setBackground(c);
	}
	
	/* Listeners de raton. */
	public void mouseClicked(MouseEvent e) { mouseClickeado(e); }
	public void mouseClickeado(MouseEvent e) { /* overload */ }
	public void mouseMoved(MouseEvent e) { mouseMovido(e); }
	public void mouseMovido(MouseEvent e) { /* overload */ }
	public void mouseDragged(MouseEvent e) { mouseArrastrado(e); }
	public void mouseArrastrado(MouseEvent e) { /* overload */ }
	public void mouseEntered(MouseEvent e) { mouseEntra(e); }
	public void mouseEntra(MouseEvent e) { /* overload */ }
	public void mouseExited(MouseEvent e) { mouseSale(e); }
	public void mouseSale(MouseEvent e) { /* overload */ }
	public void mousePressed(MouseEvent e) { mousePulsado(e); }
	public void mousePulsado(MouseEvent e) { /* overload */ }
	public void mouseReleased(MouseEvent e) { mouseSoltado(e); }
	public void mouseSoltado(MouseEvent e) { /* overload */ }

	public void esperarClic() {
		waitForClick();
	}
	
	public void agregarMouseListeners() {
		addMouseListeners();
	}

	/* Ancho y alto. */
	public double darAncho() { return getWidth(); }
	public double darAlto() { return getHeight(); }
	
	public SObjeto darObjetoA(double x, double y) {
		return (SObjeto)getElementAt(x, y);
	}
	
	/* pausa */
	public void pausa(double ms) {
		pause(ms);
	}

	/* Cosas de EsConsole se necesita aqui tambien. */
	public void imprimir(String s) {
		println(s);
	}
	
	public void imprimir(double d) {
		println(d);
	}

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
