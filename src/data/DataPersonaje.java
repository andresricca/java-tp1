package data;

import java.sql.*;
import java.util.ArrayList;

import entidades.Personaje;
import utils.ApplicationException;



public class DataPersonaje {
	
	public void add(Personaje p) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into personajes(nombre, vida, energia, defensa, evasion, puntosTotales)"+
					" values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
						
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());
			stmt.execute();
			
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()) {
				p.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException ae) {
			ae.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public void update(Personaje p) {
		PreparedStatement stmt=null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
					"update personajes set nombre=?, vida=?, energia=?, defensa=?, evasion=?, puntosTotales=?"+
					" where id=?");
			
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());
			stmt.setInt(7, p.getId());
			stmt.execute();
					
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from personajes where id=?");
			
			stmt.setInt(1, p.getId());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public Personaje[] getAll() {
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, vida, energia, defensa, evasion, puntosTotales from personajes");
			
			rs=stmt.executeQuery();	
			
			if(rs!=null) {
				while(rs.next()){
					Personaje p=new Personaje();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setVida(rs.getInt("vida"));
					p.setEnergia(rs.getInt("energia"));
					p.setDefensa(rs.getInt("defensa"));
					p.setEvasion(rs.getInt("evasion"));
					p.setPuntosTotales(rs.getInt("puntosTotales"));
					
					personajes.add(p);
				}
			}		

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		}
		
		return personajes.toArray(new Personaje[personajes.size()]);
	}
	
}
