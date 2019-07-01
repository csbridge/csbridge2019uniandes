package espl;

import java.awt.Component;
import java.awt.event.MouseEvent;

public class MouseEvento {

	private MouseEvent e = null;
	
	public MouseEvento(MouseEvent toCopy) {
		e = toCopy;
	}
	
	public int darX() {
		return e.getX();
	}
	
	public int darY() {
		return e.getY();
	}
	
	public MouseEvent darEvent() {
		return e;
	}

}
