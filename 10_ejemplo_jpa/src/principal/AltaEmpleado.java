package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class AltaEmpleado {

	public static void main(String[] args) {
		// Creamos la conexion al EntityManager, como si fuese la conexión a la base de datos
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em= factory.createEntityManager();
		
		
		//instanciamos objeto empleado y le damos datos
		Empleado empleado=new Empleado(0, "hibernate", "hiber@gmail.com", "I+D", 2000);
		
		//Creamos Transacción
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		//alta empleado
		em.persist(empleado);
		
		//Confirmamos las transacción
		tx.commit();

	}

}
