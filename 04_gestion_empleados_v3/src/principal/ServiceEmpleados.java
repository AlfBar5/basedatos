package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Empleado;

public class ServiceEmpleados {

	
	
	// DATOS DE CONEXIÓN BD mySQL
	String cadenaCon="jdbc:mysql://localhost:3306/empresa";
	String user="root";
	String pwd="root";
	
	
	//Método para insertar empleado en bd mysql
	public boolean insertarEmpleado(Empleado empleado) {
		
		//Empleado empleado = new Empleado("Alberto","albert@ert.es","ventas",1700);
		
		
		//declaramos una variable de tipo connection
		//con el try con recursos no hace falta poner la línea de cierre de conexión con.close();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
				
			//OPCIÓN 1 , la mejor
			//Ejecutar con PreparedStatement // ponemos tantas ? como parámetros tengan que llegar
			String sql="insert into empleados(nombre,email,departamento,salario) values(?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql); //la sql se va preparando, pero no se lanza aquí la query
			//Sustituimos parámetros por valores con el método setTipodeDato
			st.setString(1,empleado.getNombre());
			st.setString(2,empleado.getEmail());
			st.setString(3,empleado.getDepartamento());
			st.setDouble(4,empleado.getSalario());
			st.execute(); //aquí se ejecuta

			return true;
			
			
			/* OPCIÓN 2
				//Ejecutar consulta con objeto Statement. Ejecuta una instrucción sql
				String sql="insert into empleados (nombre,email,departamento,salario) "; //dejar espacio en blanco
				sql+="values('"+empleado.getNombre()+"','"+empleado.getEmail()+"','"+empleado.getDepartamento()+"',"+empleado.getSalario()+")";
				//Se crea el objeto statement
				Statement st=con.createStatement(); // se eimporta java.sql.statement
				//ejecutamos
				st.execute(sql);
				//mensaje
				System.out.println("Empleado añadido");
				return true;
				
			*/
				
			}
			catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
				//cerramos la conexión
				//con.close();
				
		
		
		
	}
	
	
	
	//Eliminar empleados por email
	public boolean eliminarEmpleado(String email) {
		
		
		
		//con el try con recursos no hace falta poner la línea de cierre de conexión con.close();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
						
			//OPCIÓN 1 , la mejor
			//Ejecutar con PreparedStatement // ponemos tantas ? como parámetros tengan que llegar
			String sql="delete from empleados where email=?";
			PreparedStatement st=con.prepareStatement(sql); //la sql se va preparando, pero no se lanza aquí la query
			//Sustituimos parámetros por valores con el método setTipodeDato
			
			st.setString(1,email);
			
			st.execute(); //aquí se ejecuta

			return true;
	
						
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
						
			
	}
	
	
	
	//modificar salario de empleado. Se recibe el idEmpleado y el nuevo salario
	public boolean modificarSalario(int idEmpleado, double salario) {
		
		//con el try con recursos no hace falta poner la línea de cierre de conexión con.close();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
								
			//OPCIÓN 1 , la mejor
			//Ejecutar con PreparedStatement // ponemos tantas ? como parámetros tengan que llegar
			String sql="update empleados set salario=? where idEmpleado=?";
			PreparedStatement st=con.prepareStatement(sql); //la sql se va preparando, pero no se lanza aquí la query
			//Sustituimos parámetros por valores con el método setTipodeDato
					
			st.setDouble(1,salario);
			st.setInt(2,idEmpleado);
					
			st.execute(); //aquí se ejecuta

			return true;
			
								
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
										
		
		
	}
	
	
	//buscar empleados por departamento
	public List<Empleado> buscarEmpleadosDepartamento(String departamento){
		
		List<Empleado> empleados=new ArrayList<>();
		
		//con el try con recursos no hace falta poner la línea de cierre de conexión con.close();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){
										
				//Ejecutar consulta con objeto Statement. Ejecuta una instrucción sql
				String sql="select * from empleados where departamento=? "; //dejar espacio en blanco
								
				//Se crea el objeto statement
				PreparedStatement st=con.prepareStatement(sql); //la sql se va preparando, pero no se lanza aquí la query
				st.setString(1,departamento);
				
				//no se usa el execute. Es más cómodo usar el executequery
				ResultSet rs=st.executeQuery();
				
				//bucle while para mostrar nombres con formato .next
				//accedemos por nombre de columna (aunque también se puede acceder por posición de columna
				//mientras existan filas en el resultset
				while(rs.next()) {
					//crear arraylist de objetos empleados
					empleados.add(new Empleado(rs.getInt("idEmpleado"),
							rs.getString("nombre"),
							rs.getString("email"),
							rs.getString("departamento"),
							rs.getDouble("salario")							
							));
					
				}
	
										
		}
		catch(SQLException ex) {
			ex.printStackTrace();
					
		}
		
		return empleados;
		
	}
	
	
}
