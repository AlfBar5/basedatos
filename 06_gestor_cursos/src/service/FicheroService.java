package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Curso;

public class FicheroService {
	
	
	//método stream de cursos leer fichero json y guardar en stream
	private Stream<Curso> getCursos(){
		
		String ruta="c:\\temp\\cursos.json";
		Gson gson=new Gson();
		
		try(FileReader reader=new FileReader(ruta);){
			Curso[] cursos=gson.fromJson(reader, Curso[].class);
			return Arrays.stream(cursos);
			
		}
		
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	
	
	
	//método stream de cursos
	public List<Curso> cursos(){
		return getCursos() //Stream<Curso>
				.collect(Collectors.toList());
		
	
		
	}
	

	//comprobar si existe el curso
	//si no existe lo guardamos
	//comprobar si no existe el alumno
	////si no existe lo guardamos
	public void actualizarDatos() {
		
		//instancia de cursosService
		var CursosService= new CursosService();
		//instancia de alumnosService
		var AlumnosService = new AlumnosService();
		
		//por cada curso comprobamos si existe y lo grabamos
		//también metemos todos los alumnos que no existan ya
		cursos() //recorremos curso por curso
		.forEach(c->{
			if(!CursosService.existeCurso(c.getIdCurso())) {
				// si curso no está en BD se añade
				CursosService.guardarCurso(c);
			}
			
			
			//recorremos alumnos del curso que estamos recorriendo
			c.getAlumnos()
			.forEach(a->{
				//comprobamos si el alumno existe
				if(!AlumnosService.existeAlumno(a.getDni())) {
					//Metemos el idcurso al objeto Alumno, que en el json no lo tiene
					a.setIdCurso(c.getIdCurso());
					AlumnosService.guardarAlumno(a);
				}
			});
			
			
			
		});
		
		
	}
	
	
	
	
	
} 