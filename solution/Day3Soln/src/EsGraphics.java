import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class EsGraphics extends GraphicsProgram{

	private RandomGenerator rg = new RandomGenerator();

	public void agregar(GObject obj) {
		add(obj);
	}
	
	public void agregar(GObject obj, double x, double y) {
		add(obj, x, y);
	}
	
	public double darAncho() {
		return getWidth();
	}
	
	public double darAltura() {
		return getHeight();
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
