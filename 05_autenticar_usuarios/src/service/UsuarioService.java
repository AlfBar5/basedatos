package service;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


import model.Usuario;


public class UsuarioService {

	// DATOS DE CONEXIÓN BD mySQL
		String cadenaCon="jdbc:mysql://localhost:3306/empresa";
		String user="root";
		String pwd="root";
	
	
		
	
	//le paso objeto Usuario línea completa de json
	//con this.user estamos refiriendonos a la user de arriba de la clase
	public boolean autenticar(Usuario user) {
		try(Connection con=DriverManager.getConnection(cadenaCon,this.user,pwd)){
			String sql="select * from usuarios where password=? and usuario=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsuario());
			ResultSet rs= ps.executeQuery();
			
			/*
			//cuando se lance la consulta hay dos posibilidades, o que haya una fila o que no haya fila
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			*/
			
			//devuelve true si hay algo en el next()
			return rs.next();
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
				
		
	}

	
	// método que nos devuelve un user a partir de su nombre de usuario
	public Usuario getUser(String usuario) {
		
		//Usuario usu = new Usuario();
		
		//con el try con recursos no hace falta poner la línea de cierre de conexión con.close();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
										
				//Ejecutar consulta con objeto Statement. Ejecuta una instrucción sql
				String sql="select * from usuarios where usuario=? "; //dejar espacio en blanco
								
				//Se crea el objeto statement
				PreparedStatement st=con.prepareStatement(sql); //la sql se va preparando, pero no se lanza aquí la query
				st.setString(1,usuario);
				
				//no se usa el execute. Es más cómodo usar el executequery
				ResultSet rs=st.executeQuery();
				
				if(rs.next()) {
					//return usu(user,rs.getString("password"));
					return new Usuario(usuario,rs.getString("password"));
				}else {
					return null;
				}
	
										
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return(null);		
		}
		
		
		
		
	}
	
	
	
	
	
}
