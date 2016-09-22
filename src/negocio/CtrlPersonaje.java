package negocio;

import data.DataPersonaje;
import entidades.Personaje;
import utils.ApplicationException;



public class CtrlPersonaje {
	
//Consultar	
	private static CtrlPersonaje ctrl;
	
	public static CtrlPersonaje getCtrl() {
		if(ctrl==null) {
			ctrl=new CtrlPersonaje();
		}
		return ctrl;
	}
	
	private int puntosInicio;
	private int maxDefensa;
	private int maxEvasion;
	
	private DataPersonaje dataPersonaje;
	
	public CtrlPersonaje() {
		dataPersonaje=new DataPersonaje();
		puntosInicio=200;
		maxDefensa=20;
		maxEvasion=80;
	}
	
	public int getPuntosInicio() {
		return puntosInicio;
	}
	
	public int getMaxDefensa() {
		return maxDefensa;
	}
	
	public int getMaxEvasion() {
		return maxEvasion;
	}

	public void add(Personaje p) throws ApplicationException {
		if(personajeValido(p)){
			dataPersonaje.add(p);
		}
	}
	
	public void update(Personaje p) throws ApplicationException {
		if(personajeValido(p)){
			dataPersonaje.update(p);
		}
	}
	
	public void delete(Personaje p) {
		dataPersonaje.delete(p);
	}
	
	private boolean personajeValido(Personaje p) throws ApplicationException {
		boolean valido=true;
		if(p.getNombre().trim().length() == 0) {
			valido=false;
			throw new ApplicationException("Debe ingresar un nombre");
		}
		if(valido && p.getVida()<1 || p.getEnergia()<1 || p.getDefensa()<1 || p.getEvasion()<1) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a los atributos deben ser mayores o iguales que 1");
		}
		if(valido && p.getDefensa()>maxDefensa) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a la defensa no pueden ser mayores que "+maxDefensa);
		}
		if(valido && p.getEvasion()>maxEvasion) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a la evasion no pueden ser mayores que "+maxEvasion);
		}
		int sumaPuntos=p.getVida()+p.getEnergia()+p.getDefensa()+p.getEvasion();
		if(sumaPuntos>p.getPuntosTotales()) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a los atributos superan la cantidad de puntos disponibles");
		}
		return valido;
	}
	
	public Personaje[] getPersonajes() {
		return dataPersonaje.getAll();
	}

}
