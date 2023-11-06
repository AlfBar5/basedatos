package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helpers.ConnectionLocator;
import model.Curso;

//Para importar el método y ahorrar código
import static helpers.ConnectionLocator.getConnection;


public class CursosDao {
	
	
	// DATOS DE CONEXIÓN BD mySQL
	
	
		
	
	
	//metodo comprobar si existe curso ya en la base de datos
	public boolean existeCurso(int idCurso) {
		
		try(Connection con=getConnection()){
			String sql="select * from cursos where idCurso=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idCurso);
			
			ResultSet rs= ps.executeQuery();
								
			//devuelve true si hay algo en el next()
			return rs.next();
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}
	
	
	
	
	
	
	

	//método volcar datos del json en la base de datos formacion
	public boolean guardarCurso(Curso curso) {
		
		
		try(Connection con=getConnection();){
		
			//Ejecutar con PreparedStatement // ponemos tantas ? como parámetros tengan que llegar
			String sql="insert into cursos(idCurso,curso,duracion,precio) values(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql); //la sql se va preparando, pero no se lanza aquí la query
			//Sustituimos parámetros por valores con el método setTipodeDato
			st.setInt(1, curso.getIdCurso());
			st.setString(2,curso.getCurso());
			st.setInt(3,curso.getDuracion());
			st.setDouble(4,curso.getPrecio());
			
			st.execute(); //aquí se ejecuta
			return true;
			
		//getCursos()
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	
	//Método para ver todos los cursos para rellenar el combobox
	public List<Curso> cursos(){
		
		
		List<Curso> cursos=new ArrayList<>();
		
		try(Connection con=getConnection()){
			String sql="select * from cursos";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ResultSet rs= ps.executeQuery();
								
			while(rs.next()) {
				//crear arraylist de objetos empleados
				cursos.add(new Curso(rs.getInt("idCurso"),
						rs.getString("curso"),
						rs.getInt("duracion"),
						rs.getDouble("precio"),
						null //lista de alumnos nula							
						));
				
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		
		return cursos;
	}


		
				
	
	
	

}
