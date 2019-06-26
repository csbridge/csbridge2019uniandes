/**
 * Luna
 * -----
 * Convierte el peso en la tierra en peso en la luna.
 */
public class Luna extends EsConsole {

	public void run() {
		setFont("courier-24");
		double weight = leerDouble("Entra un peso en la tierra: ");
		double moonWeight = weight * .165;
		imprimir("Tu peso en la luna es: " + moonWeight);
	}

}
