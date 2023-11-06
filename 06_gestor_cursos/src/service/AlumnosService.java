package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Alumno;

public class AlumnosService {
	
	// DATOS DE CONEXIÓN BD mySQL
	String cadenaCon="jdbc:mysql://localhost:3306/formacion";
	String user="root";
	String pwd="root";
	
	
	//metodo comprobar si existe el alumno ya en la base de datos
	public boolean existeAlumno(String dni) {
			
			try(Connection con=DriverManager.getConnection(cadenaCon,this.user,pwd)){
				
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
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
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
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
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
	
	
	
	
	
	
	
	
}

