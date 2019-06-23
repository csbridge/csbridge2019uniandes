import acm.graphics.GRect;

public class SRect extends GRect{

	public SRect(double w, double h) {
		super(w, h);
	}
	
	public SRect(double x, double y, double w, double h) {
		super(x, y, w, h);
	}

	public double darX() {
		return getX();
	}

	public double darY() {
		return getY();
	}

	public void moverse(int dx, int dy) {
		move(dx, dy);
	}

	public void cambiarRelleno(boolean b) {
		setFilled(b);
	}

}
