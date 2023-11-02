package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Empleado;
import principal.ServiceEmpleados;

class TestServiceEmpleados {

	ServiceEmpleados service;
	
	@BeforeEach
	void setUp() throws Exception {
		
		service=new ServiceEmpleados();
	}

	@Test
	void testInsertarEmpleado() {
		
		
		//assertTrue(service.insertarEmpleado(new Empleado(0,"Alfonso","alfonso@ert.es","contabilidad",1400)));
		
		////constructor con 4 parámetros del model (sin idEmpleado)
		//assertTrue(service.insertarEmpleado(new Empleado("Lucio","lucio@ert.es","contabilidad",1200)));
	}

	
	@Test
	void testeliminarEmpleado() {
		
		//assertTrue(service.eliminarEmpleado("lucio@ert.es"));
		
	}
	
	
	@Test
	void testmodificarSalario() {
		
		assertTrue(service.modificarSalario(8,2400));
		
	}
	
}
