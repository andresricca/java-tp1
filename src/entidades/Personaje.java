package entidades;

import utils.ApplicationException;



public class Personaje {
	
	private static int puntosInicio=200;
	private static int maxDefensa=20;
	private static int maxEvasion=80;
	
	private int id;
	private String nombre;
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	private int puntosTotales;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public int getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	
	
	public Personaje() {
		this.puntosTotales=puntosInicio;
	}
	
	
	public boolean isValid() throws ApplicationException {
		boolean valido=true;
		if(nombre.length()==0) {
			valido=false;
			throw new ApplicationException("Debe ingresar un nombre");
		}
		if(valido && vida<1 || energia<1 || defensa<1 || evasion<1) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a los atributos deben ser mayores o iguales que 1");
		}
		if(valido && defensa>maxDefensa) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a la defensa no pueden ser mayores que "+maxDefensa);
		}
		if(valido && evasion>maxEvasion) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a la evasion no pueden ser mayores que "+maxEvasion);
		}
		if(vida+energia+defensa+evasion>puntosTotales) {
			valido=false;
			throw new ApplicationException("Los puntos asignados a los atributos superan la cantidad de puntos disponibles");
		}
		return valido;
	}
	
	
	@Override
	public String toString() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object p) {
		return p instanceof Personaje && ((Personaje) p).getId() == this.getId();		
	}

	
	
}
