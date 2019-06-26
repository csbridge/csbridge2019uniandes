
public class GameShow extends EsConsole {

	public void run() {
		//1. Pedirle el numero de puerta al usuario
		int puerta = leerInt("Escoge una puerta: ");
		while(puerta < 1 || puerta > 3) {
			imprimir("Escoge una puerta entre 1 y 3");
			puerta = leerInt("Escoge una puerta: ");
		}

		//Logica del juego
		int premio = 3;
		if(puerta == 1) {
			premio = 2 + 9 / 10 * 100;
		} else if(puerta == 2) {
			boolean open = premio == 3;
			if(open) {
				premio = premio + 7;
			}
		} else {
			premio = premio + 1;
		}

		println("You win " + premio + ",000 pesos");
	}

}
