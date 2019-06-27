
/**
 * Nimm
 * -----
 * Ejecuta una version para dos jugadores del 
 * antiguo juego de Nimm.
 */
public class Nimm extends EsConsole {

	public void run() {
		setFont("courier-12");
		solution();
	}
	
	private void reto2() {
		int numStones = 20;
		int playerTurn = 1;
		while(numStones > 0) {
			imprimir("Quedan " + numStones + " piedras");
			int v = leerInt("Jugador " + playerTurn + " le gustaría quitar 1 o 2 piedras? ");
			numStones -= v;
			if(playerTurn == 1) {
				playerTurn = 2;
			} else {
				playerTurn = 1;
			}
			imprimir("");
		}
		imprimir("Juego terminado");
	}

	public void run() {
		int numStones = 20;
		while(numStones > 0) {
			imprimir("Quedan " + numStones + " piedras");
			int v = leerInt("Le gustaría quitar 1 o 2 piedras? ");
			numStones -= v;
			imprimir("");
		}
		imprimir("Juego terminado");
	}

	private void solution() {
		int numStones = 20;
		int playerTurn = 1;
		while(numStones > 0) {
			imprimir("Quedan " + numStones + " piedras");
			int v = leerInt("Jugador " + playerTurn + " le gustaría quitar 1 o 2 piedras? ");
			while(v < 1 || v > 2 || v > numStones) {
				v = leerInt("Por favor ingrese 1 o 2: ");
			}
			numStones -= v;
			if(playerTurn == 1) {
				playerTurn = 2;
			} else {
				playerTurn = 1;
			}
			imprimir("");
		}
		imprimir("Jugador " + playerTurn + " gana!");
	}

}
