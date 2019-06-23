
public class FilaDeConos extends EsKarel {
	
	public void run() {
		while(frenteDespejado()) {
			ponerCono();
			moverse();
		}
		ponerCono();
	}

}
