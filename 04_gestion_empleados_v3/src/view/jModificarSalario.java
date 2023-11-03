package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principal.ServiceEmpleados;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jModificarSalario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEmpleado;
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */
	
	/*
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jModificarSalario frame = new jModificarSalario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/

	/**
	 * Create the frame.
	 */
	
	//CONSTRUCTOR
	public jModificarSalario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubirSueldoEmpleado = new JLabel("SUBIR SUELDO EMPLEADO");
		lblSubirSueldoEmpleado.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblSubirSueldoEmpleado.setBounds(29, 25, 249, 17);
		contentPane.add(lblSubirSueldoEmpleado);
		
		JLabel lblNewLabel_1 = new JLabel("ID EMPLEADO:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(39, 74, 103, 24);
		contentPane.add(lblNewLabel_1);
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setColumns(10);
		txtIdEmpleado.setBounds(152, 71, 191, 33);
		contentPane.add(txtIdEmpleado);
		
		//SALIR
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cerrar esta ventana
				jModificarSalario.this.dispose();
				
				
			}
		});
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalir.setBounds(22, 197, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnEliminar = new JButton("MODIFICAR SALARIO");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//creamos la instancia //var es una forma de ahorrar poner el tipo (lo deduce del código del new) sustituye a PedidosService
				//var service = new ServiceEmpleados();
				ServiceEmpleados service = new ServiceEmpleados();			
				
				service.modificarSalario(Integer.parseInt(txtIdEmpleado.getText()), Double.parseDouble(txtSalario.getText()));
				jModificarSalario.this.dispose();
			}
		});
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnEliminar.setBounds(212, 197, 191, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel_1_1 = new JLabel("NUEVO SALARIO:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(39, 129, 103, 24);
		contentPane.add(lblNewLabel_1_1);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(152, 126, 191, 33);
		contentPane.add(txtSalario);
		
		//PARA QUE SE VEA LA VENTANA
				this.setVisible(true);
	}
	
	

}
