package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Empleado;

public class EliminarEmpleado {

	public static void main(String[] args) {
		// Creamos la conexion al EntityManager, como si fuese la conexión a la base de datos
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em= factory.createEntityManager();
		
		//eliminar empleado código 5
		//primero lo buscamos
		Empleado emple=em.find(Empleado.class, 5);
		
		if(emple!=null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(emple);
			tx.commit();
			System.out.println("Empleado eliminado");
		}else {
			System.out.println("Empleado no existe");
		}
		
		

	}

}
