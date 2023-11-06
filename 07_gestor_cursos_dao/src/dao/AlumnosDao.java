package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import helpers.ConnectionLocator;
import model.Alumno;


//Para importar el método y ahorrar código, ver primer try
import static helpers.ConnectionLocator.getConnection;


public class AlumnosDao {
	
	// DATOS DE CONEXIÓN BD mySQL
	
	
	
	//metodo comprobar si existe el alumno ya en la base de datos
	public boolean existeAlumno(String dni) {
			
		//try con recursos
			//try(Connection con=ConnectionLocator.getConnection()){
			try(Connection con=getConnection()){
				
				String sql="select * from alumnos where dni=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, dni);
				
				ResultSet rs= ps.executeQuery();
									
				//devuelve true si hay algo en el next()
				return rs.next();
				
				
			}catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
			
			
			
	}
	
	
	//guardar un alumno
	public boolean guardarAlumno(Alumno alumno) {
		try(Connection con=getConnection();){
			String sql="insert into alumnos (dni,idCurso,nombre,edad,nota) values (?,?,?,?,?)";
			//se crea el preparestatement a partir de la sql
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			//sustituimos parámetros por valores
					ps.setString(1,  alumno.getDni());
					ps.setInt(2,  alumno.getIdCurso());
					ps.setString(3,  alumno.getNombre());
					ps.setInt(4,  alumno.getEdad());
					ps.setDouble(5,  alumno.getNota());
			ps.execute();
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
	//guardar una lista de alumnos
	public boolean guardarAlumnos(List<Alumno> alumnos) {
		try(Connection con=getConnection();){
			String sql="insert into alumnos (dni,idCurso,nombre,edad,nota) values (?,?,?,?,?)";
			//se crea el preparestatement a partir de la sql
			PreparedStatement ps=con.prepareStatement(sql);
			for(Alumno alumno:alumnos) {
				//sustituimos parámetros por valores
				ps.setString(1, alumno.getDni());
				ps.setInt(2, alumno.getIdCurso());
				ps.setString(3, alumno.getNombre());
				ps.setInt(4, alumno.getEdad());
				ps.setDouble(5, alumno.getNota());
				
				ps.execute();
			}
			return true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
	//Método para sacar todos los alumnos
	public List<Alumno> alumnos(){
		List<Alumno> alumnos=new ArrayList<>();
		try(Connection con=getConnection();){				
			String sql="select * from alumnos";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getString("dni"),
							rs.getInt("idCurso"),
							rs.getString("nombre"),
							rs.getInt("edad"),
							rs.getDouble("nota")
							
						));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();		
		}
		return alumnos;
	}
	
	
	//Método para sacar los alumnos de un curso específico
	public List<Alumno> alumnos(int curso){
		List<Alumno> alumnos=new ArrayList<>();
		try(Connection con=getConnection();){				
			String sql="select * from alumnos where idCurso=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, curso);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				alumnos.add(new Alumno(rs.getString("dni"),
						rs.getInt("idCurso"),
						rs.getString("nombre"),
						rs.getInt("edad"),
						rs.getDouble("nota")
						
					));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();		
		}
		return alumnos;
	}
	
	
	////Método eliminar alumno por dni. Lógica patrón DAO. Solo ejecutamos query
	public boolean eliminarAlumno(String dni) {
		
		
			
			try(Connection con=getConnection();){
				String sql="delete from alumnos where dni=?";
				//se crea el preparestatement a partir de la sql
				PreparedStatement ps=con.prepareStatement(sql);
				//sustituimos parámetros por valores
				//sustituimos parámetros por valores
						ps.setString(1, dni);
						
				ps.execute();
				return true;
				
			}
			catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
			
		
		
	}
	
	
	
}

