package graphics;
import java.awt.Color;

public interface SObjeto {
	public double darX();
	public double darY();
	public void cambiarColor(Color c);
	public void cambiarUbicacion(double i, double j);
	public void moverse(double dx, double dy);
	public double darAncho();
	public double darAlto();
	public void cambiarVisible(boolean visible);
	public boolean estaVisible();
}
