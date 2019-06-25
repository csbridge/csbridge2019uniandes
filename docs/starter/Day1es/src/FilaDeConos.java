/**
 * Programa : FilaDeConos.
 * -----------------------
 * Llene la primera fila con conos. Supone que
 * Karel comienza en la esquina inferior izquierda.
 * De la pantalla, mirando hacia el este.
 */
public class FilaDeConos extends EsKarel {
	
	public void run () {
		while (frenteDespejado()) {
			ponerCono();
			moverse();
		}
		
		/* Esta línea es necesaria para colocar el 
		 * cono final. El numero de veces que Karel 
		 * se mueve es menos que el numero de veces
		 * Karel pone un cono (si el mundo tiene 
		 * cinco cuadrados de ancho, ponemos 5 conos 
		 * pero solo se mueven 4 veces)
		 */
		ponerCono();
	}
} 