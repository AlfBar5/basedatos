package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploInsercion {

	public static void main(String[] args) {
		
		// DATOS DE CONEXIÓN BD mySQL
		String cadenaCon="jdbc:mysql://localhost:3306/empresa";
		String user="root";
		String pwd="root";
		//declaramos una variable de tipo connection
		//con el try con recursos no hace falta poner la línea de cierre de conexión con.close();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
		
		//Ejecutar consulta con objeto Statement. Ejecuta una instrucción sql
		String sql="insert into empleados (nombre,email,departamento,salario) "; //dejar espacio en blanco
		sql+="values('paco','paquito@gmail.com','informática',1600)";
		
		//Se crea el objeto statement
		Statement st=con.createStatement(); // se eimporta java.sql.statement
		//ejecutamos
		st.execute(sql);
		//mensaje
		System.out.println("Empleado añadido");
		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		//cerramos la conexión
		//con.close();
		
		//Con PrepareStatement
		

	}

}
