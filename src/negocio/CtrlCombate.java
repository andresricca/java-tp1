package negocio;

import data.DataPersonaje;
import entidades.Personaje;
import utils.ApplicationException;

public class CtrlCombate {
	
	private DataPersonaje dataPersonaje;
	
	
	private Personaje jugador1;
	private Personaje jugador2;
	
	private Personaje jugadorAtaca;
	private Personaje jugadorRecibe;
	
	private boolean finCombate;
	
	public Personaje getJugador1() {
		return jugador1;
	}
	public Personaje getJugador2() {
		return jugador2;
	}
	
	public boolean getFinCombate() {
		return finCombate;
	}
	
	
	
	public CtrlCombate() {
		dataPersonaje=new DataPersonaje();
	}
	
	
	
	public void nuevoCombate(Personaje jugador1, Personaje jugador2) {
		//if(jugador1.equals(jugador2))
		this.jugador1=jugador1;
		this.jugador2=jugador2;
		jugadorAtaca=jugador1;
		jugadorRecibe=jugador2;
		finCombate=false;
	}
	
	private void cambiarTurno() {
		Personaje aux=jugadorAtaca;
		jugadorAtaca=jugadorRecibe;
		jugadorRecibe=aux;
	}
	
	public Personaje getTurno() {
		return jugadorAtaca;
	}
	
	public void atacar(int puntos) throws ApplicationException {
		if(finCombate) {
			throw new ApplicationException("El combate ha finalizado");
		}
		if(puntos>jugadorAtaca.getEnergiaRestante()) {
			throw new ApplicationException("Los puntos para el ataque superan la cantidad de puntos disponibles");
		}
		jugadorAtaca.realizarAtaque(puntos);
		jugadorRecibe.recibirAtaque(puntos);
		if(jugadorRecibe.getVidaRestante()<=0) {
			finCombate=true;
			jugadorAtaca.recibirPremio();
			dataPersonaje.update(jugadorAtaca);
		}
		if(!finCombate) {
			cambiarTurno();
		}
	}
	
	public void defender() throws ApplicationException {
		if(finCombate) {
			throw new ApplicationException("El combate ha finalizado");
		}
		jugadorAtaca.defiende();
		cambiarTurno();
	}

}
