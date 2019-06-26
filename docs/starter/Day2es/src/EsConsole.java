import java.awt.Color;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * CUIDADO: Por favor no cambiar este codigo.  No necesitas 
 * leer/modificar este archivo. Este archivo nos permite 
 * traducir las librerias a nombres de metodos en Español
 */
public abstract class EsConsole extends ConsoleProgram{

	private RandomGenerator rg = new RandomGenerator();
	
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

	public int leerBoolean(String prompt) {
		return readBoolean(prompt);
	}
	
	public int leerInt(String prompt) {
		return readInt(prompt);
	}
	
	public double leerDouble(String prompt) {
		return readDouble(prompt);
	}

	public String leerLinea(String prompt) {
		return readLine(prompt);
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

