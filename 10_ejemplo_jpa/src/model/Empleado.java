package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="empleados") //le damos el nombre de la tabla. El motor de persistencia se encarga de los insert, delete, etc

public class Empleado {
	//Ponemos estas dos anotaciones en el campo PrimaryKey. La segunda es que el campo es AutoIncremental
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	
	private String nombre;
	private String email;
	private String departamento;
	private double salario;
	
	
	
	
	

}
