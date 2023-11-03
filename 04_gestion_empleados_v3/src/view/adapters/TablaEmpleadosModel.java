package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Empleado;
import principal.ServiceEmpleados;

public class TablaEmpleadosModel extends AbstractTableModel {

	List<Empleado> empleados;
	
	
	//definimos el número de columnas como constante
	final int COLS=5;
	private int column;
	
	
	
	
	
	
	//constructor sobrecargado con un parámetro
	//carga los empleados por departamento
	public TablaEmpleadosModel(String departamento) {
			empleados= new ServiceEmpleados().buscarEmpleadosDepartamento(departamento);
	}
	
	
	//para que salgan los métodos de abajo
		///Botón derecho sobre el código
		//source/override/implement methods
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return empleados.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLS;
	}

	


	@Override
	public String getColumnName(int column) {
		//funciona en java 17
		return switch(column) {
			case 0->"idEmpleado";
			case 1->"Nombre";
			case 2->"Email";
			case 3->"Departamento";
			case 4->"Salario";
			default->"Indeterminada";
			};
	}

	
	
	@Override
	public Object getValueAt(int row, int column) {
		
		switch(column){
		 case 0:
		 	return empleados.get(row).getIdEmpleado();
		 case 1:
		 	return empleados.get(row).getNombre();
		 case 2:
		 	return empleados.get(row).getEmail();
		 case 3:
			 	return empleados.get(row).getDepartamento();
		 case 4:
			 	return empleados.get(row).getSalario();
		 default:
		 	return null;
		 }
		
	}
	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		switch(column){
		 case 0:
		 	return String.class;
		 case 1:
		 	return String.class;
		 case 2:
			 return String.class;
		 case 3:
			 return String.class;
		 case 4:
		 	return Double.class;
		 default:
		 	return null;
		 }
	}
	
	
	

}
