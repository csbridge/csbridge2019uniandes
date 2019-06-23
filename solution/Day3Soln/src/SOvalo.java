import acm.graphics.GOval;

public class SOvalo extends GOval{

	public SOvalo(double w, double h) {
		super(w, h);
	}
	
	public SOvalo(double x, double y, double w, double h) {
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
