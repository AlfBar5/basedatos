package principal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Empleado;

public class BusquedaEmpleado {

	public static void main(String[] args) {

		// Creamos la conexion al EntityManager, como si fuese la conexión a la base de datos
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("ejemploPU");
		EntityManager em= factory.createEntityManager();
		
		//búsqueda empleado cuyo código sea 5. Es una búsqueda por primary key
		//MÉTODO find, le decimos el tipo de la entidad (a qué clase pertenece) y devuelve la entidad entera, en este caso el objeto Empleado
		Empleado empleado=em.find(Empleado.class, 5);		

		if(empleado!=null) {
			System.out.println(empleado.getNombre());
		}else {
			System.out.println("Empleado no existe");
			
		}
		
		
		
		System.out.println("------------------------------");
		
		
		//BUSCAR EMPLEADO DE DEPARTAMENTO VENTAS LENGUAJE JPQL
		String dep ="ventas";
		
		//Creamos el jpql. Son nombre de ENTIDADES (NO DE TABLAS)
		// ?1 -- el nñumero indica la posición del parámetro
		String jpql ="select e from Empleado e where e.departamento=?1";
		//creamos el typedQuery. Le damos el jpql y le decimos en tipo de opjeto que tiene que devolver -- Empleado
		TypedQuery<Empleado> tq= em.createQuery(jpql, Empleado.class);
		tq.setParameter(1, dep);
		
		List<Empleado> emps = tq.getResultList();
		
		emps.forEach(e->System.out.println(e.getNombre()));
		
	}

}
