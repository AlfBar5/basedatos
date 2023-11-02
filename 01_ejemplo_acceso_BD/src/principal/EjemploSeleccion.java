package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploSeleccion {

	public static void main(String[] args) {

		// DATOS DE CONEXIÓN BD mySQL
		String cadenaCon="jdbc:mysql://localhost:3306/empresa";
		String user="root";
		String pwd="root";
		//declaramos una variable de tipo connection
		//con el try con recursos no hace falta poner la línea de cierre de conexión con.close();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
				
			//Ejecutar consulta con objeto Statement. Ejecuta una instrucción sql
			String sql="select nombre from empleados "; //dejar espacio en blanco
							
			//Se crea el objeto statement
			Statement st=con.createStatement(); // se importa java.sql.statement
			//no se usa el execute. Es más cómodo usar el executequery
			ResultSet rs=st.executeQuery(sql);
			
			//bucle while para mostrar nombres con formato .next
			//accedemos por nombre de columna (aunque también se puede acceder por posición de columna
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
			
				
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		

	}

}
