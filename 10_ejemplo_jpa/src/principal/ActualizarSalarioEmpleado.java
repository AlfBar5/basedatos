package principal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ActualizarSalarioEmpleado {

	public static void main(String[] args) {


		// Creamos la conexion al EntityManager, como si fuese la conexión a la base de datos
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em= factory.createEntityManager();
		
		
		//declaramos variables de la query
		double factor =1.1;
		String dep="ventas";
		
		
		
		
		String jpql = "update Empleado e set e.salario=e.salario*?1 where e.departamento=?2";

		//Declaramos query, no typerQuery (HAY QUE IMPORTAR la query  de javax.persistence.Query)
		Query q=em.createQuery(jpql);
		
		//Sustituir parámetros
		q.setParameter(1, factor);
		q.setParameter(2, dep);
		
		//declaramos transacción
		EntityTransaction tx = em.getTransaction();
		
		//Abrimos transacción
		tx.begin();
		
		//ejecutar transacción 
		//q.executeUpdate();
		//Este método devuelve el número (res) de cuántas entidades (registros de la tabla) se han actualizado
		int res=q.executeUpdate();
		//commit
		tx.commit();
		
		
		System.out.println("Se actualizadon ="+res+" empleados");
		
	}

}
