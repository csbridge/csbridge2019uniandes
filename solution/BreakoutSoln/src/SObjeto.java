import java.awt.Color;

public interface SObjeto {
	public double getX();
	public double getY();
	public void cambiarColor(Color c);
	public void cambiarUbicacion(double i, double j);
	public void moverse(double dx, double dy);
	public double darAncho();
	public double darAltura();
	public void cambiarVisible(boolean visible);
	public boolean esVisible();
}
