package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Data


public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	private String email;
	private String departamento;
	private double salario;
	
	
	//constructor sobrecarga con 4 parámetros (sin idEmpleado)
	public Empleado(String nombre, String email, String departamento, double salario) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.departamento = departamento;
		this.salario = salario;
	}
	
	
	
	

}
