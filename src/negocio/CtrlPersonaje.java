package negocio;

import data.DataPersonaje;
import entidades.Personaje;
import utils.ApplicationException;



public class CtrlPersonaje {
	
	private static CtrlPersonaje ctrl;
	
	public static CtrlPersonaje getCtrl() {
		if(ctrl==null) {
			ctrl=new CtrlPersonaje();
		}
		return ctrl;
	}
	
	
	
	private DataPersonaje dataPersonaje;

	public CtrlPersonaje() {
		dataPersonaje=new DataPersonaje();
	}

	public void add(Personaje p) throws ApplicationException {
		if(p.isValid()){
			dataPersonaje.add(p);
		}
	}
	
	public void update(Personaje p) throws ApplicationException {
		if(p.isValid()){
			dataPersonaje.update(p);
		}
	}
	
	public void delete(Personaje p) throws ApplicationException {
		dataPersonaje.delete(p);
	}
	
	public Personaje[] getPersonajes() throws ApplicationException {
		return dataPersonaje.getAll();
	}

}
