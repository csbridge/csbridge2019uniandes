

/**
 * SumarNumeros
 * -----
 * Escriba un programa que lea en 10 enteros 
 * del usuario y luego genere la suma de los 
 * valores ingresados
 */
public class SumarNumeros extends EsConsole {

	public void run() {
		setFont("courier-24");
		imprimir("Introduce 10 números. Te mostraré la suma");
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			int value = leerInt("Por favor ingrese un entero: ");
			sum += value;
		}
		imprimir("");
		imprimir("La suma es: " + sum);
	}

}
