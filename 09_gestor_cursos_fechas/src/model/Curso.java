package model;


import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data


public class Curso {
	
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private LocalDate fechaInicio;
	
	//necesario para leer los alumnos del json y guardarlos en una lista
	private List<Alumno> alumnos;
	
	
	/*
	//constructor sobrecarga con 3 parámetros (sin idCurso)
	public Curso(String nombre, int duracion, double precio) {
		super();
		this.nombre= nombre;
		this.duracion= duracion;
		this.precio = precio;
		
	}
	*/

	//para que se vea el objeto producto y no el objeto hashmodel
	//CAm:  
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return curso;
		}
	
	
}



