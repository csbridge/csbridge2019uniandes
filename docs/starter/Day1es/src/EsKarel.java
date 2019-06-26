import java.awt.Color;

import stanford.karel.SuperKarel;

/**
 * CUIDADO: Por favor no cambiar este codigo.  No necesitas 
 * leer/modificar este archivo. Este archivo nos permite 
 * traducir las librerias de Karel a nombres de metodos en Español
 */
public abstract class EsKarel extends SuperKarel {

	
	/********************************************** 
	 *          código privado                    *
	 **********************************************/
	
	
	
	public void moverse() {
		move();
	}
	
	public void girarIzquierda() {
		turnLeft();
	}
	
	public void mediaVuelta() {
		turnAround();
	}
	
	public void ponerCono() {
		putBeeper();
	}
	
	public void recogerCono() {
		pickBeeper();
	}
	
	public void pintarEsquina(Color c) {
		paintCorner(c);
	}
	
	/** Conditions **/
	
	public boolean frenteDespejado() {
		return frontIsClear();
	}
	
	public boolean frenteBloqueado() {
		return frontIsBlocked();
	}
	
	public boolean izquierdaDespejada() {
		return leftIsClear();
	}
	
	public boolean izquierdaBloqueada() {
		return leftIsBlocked();
	}
	
	public boolean derechaDespejada() {
		return rightIsClear();
	}
	
	public boolean derechaBloqueada() {
		return rightIsBlocked();
	}
	
	public boolean conosPresentes() {
		return beepersPresent();
	}
	
	public boolean conosAusentes() {
		return noBeepersPresent();
	}
	
	public boolean bolsaSinConos() {
		return noBeepersInBag();
	}
	
	public boolean bolsaConConos() {
		return beepersInBag();
	}
	
	public boolean rumboNorte() {
		return facingNorth();
	}
	
	public boolean sinRumboNorte() {
		return notFacingNorth();
	}
	
	public boolean rumboEste() {
		return facingEast();
	}
	
	public boolean sinRumboEste() {
		return notFacingEast();
	}
	
	public boolean rumboSur() {
		return facingSouth();
	}
	
	public boolean sinRumboSur() {
		return notFacingSouth();
	}
	
	public boolean rumboOeste() {
		return facingWest();
	}
	
	public boolean sinRumboOeste() {
		return notFacingWest();
	}
	
	public boolean aleatorio() {
		return random();
	}
	
	public boolean aleatorio(double p) {
		return aleatorio(p);
	}

	public boolean colorEsquinaEs(Color c) {
		return cornerColorIs(c);
	}
	
}
