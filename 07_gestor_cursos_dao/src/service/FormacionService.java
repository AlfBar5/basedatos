package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.CursosJsonDao;
import model.Alumno;
import model.Curso;

public class FormacionService {

	
	
	

	//comprobar si existe el curso
	//si no existe lo guardamos
	//comprobar si no existe el alumno
	////si no existe lo guardamos
	public void actualizarDatos() {
		
		//instancia de cursosService
		var CursosDao= new CursosDao();
		//instancia de alumnosService
		var AlumnosDao = new AlumnosDao();
		
		//por cada curso comprobamos si existe y lo grabamos
		//también metemos todos los alumnos que no existan ya
		var jsonDao = new CursosJsonDao();
		jsonDao.cursos() //recorremos curso por curso
		.forEach(c->{
			if(!CursosDao.existeCurso(c.getIdCurso())) {
				// si curso no está en BD se añade
				CursosDao.guardarCurso(c);
			}
			
			
			//recorremos alumnos del curso que estamos recorriendo
			c.getAlumnos()
			.forEach(a->{
				//comprobamos si el alumno existe
				if(!AlumnosDao.existeAlumno(a.getDni())) {
					//Metemos el idcurso al objeto Alumno, que en el json no lo tiene
					a.setIdCurso(c.getIdCurso());
					AlumnosDao.guardarAlumno(a);
				}
			});
			
			
			
		});
		
		
	}
	
	
	//Lista de curso. Llamamos al método CursosDao
	public List<Curso> listadoCursos(){
		//crear una instacia de CursosDao
		var cursosDao= new CursosDao();
		return cursosDao.cursos();
		
	}
	
	
	
	
	//método de lista de alumnos. Si pasan un 0, significa que pinto todos
	public List<Alumno> alumnosCurso(int idCurso){
		//Instanciamos un alumnosDao
		var alumnosDao= new AlumnosDao();
		
		/*
		if(idCurso == 0) {
			return alumnosDao.alumnos();
		}
		return alumnosDao.alumnos(idCurso);
		
		*/
		
		//con operador ternario. Esto es lo mismo que el if else de arriba:
		return  idCurso==0?alumnosDao.alumnos(): alumnosDao.alumnos(idCurso);
		
	}
	
	
	
	
	
	
	////Método eliminar alumno por dni. Lógina de negocio. Capa Service
	public boolean eliminarAlumno(String dni) {
		
		AlumnosDao alumnosdao = new AlumnosDao();
		
		if(!alumnosdao.existeAlumno(dni)) {
			
				
			return false;
						
		}
		return alumnosdao.eliminarAlumno(dni);
		
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

