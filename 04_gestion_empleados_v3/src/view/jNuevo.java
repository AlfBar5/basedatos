package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Empleado;
import principal.ServiceEmpleados;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jNuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtDepartamento;
	private JTextField txtSalario;

	

	/**
	 * Create the frame.
	 */
	public jNuevo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNombre.setBounds(29, 11, 120, 26);
		contentPane.add(lblNombre);
		
		JLabel lblEnail = new JLabel("Email:");
		lblEnail.setFont(new Font("Verdana", Font.BOLD, 13));
		lblEnail.setBounds(29, 68, 120, 26);
		contentPane.add(lblEnail);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setFont(new Font("Verdana", Font.BOLD, 13));
		lblDepartamento.setBounds(29, 125, 120, 26);
		contentPane.add(lblDepartamento);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Verdana", Font.BOLD, 13));
		lblSalario.setBounds(29, 182, 120, 26);
		contentPane.add(lblSalario);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		txtNombre.setBounds(177, 10, 182, 31);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(177, 63, 182, 31);
		contentPane.add(txtEmail);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setFont(new Font("Verdana", Font.BOLD, 12));
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(177, 120, 182, 31);
		contentPane.add(txtDepartamento);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Verdana", Font.BOLD, 12));
		txtSalario.setColumns(10);
		txtSalario.setBounds(177, 177, 182, 31);
		contentPane.add(txtSalario);
		
		//SALIR
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cerrar esta ventana jNuevo
				jNuevo.this.dispose();
				
			}
		});
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalir.setBounds(53, 227, 96, 23);
		contentPane.add(btnSalir);
		
		
		//GUARDAR NUEVO EMPLEADO
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//creamos la instancia //var es una forma de ahorrar poner el tipo (lo deduce del código del new) sustituye a PedidosService
				//var service = new ServiceEmpleados();
				ServiceEmpleados service = new ServiceEmpleados();			
				
				service.insertarEmpleado(new Empleado(txtNombre.getText(),txtEmail.getText(),txtDepartamento.getText(),Double.parseDouble(txtSalario.getText())));
				
				//después de guardar llevamos el cursos al input text de producto
				txtNombre.requestFocus(); //manda el foco a un input text
			}
		});
		btnGuardar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGuardar.setBounds(304, 228, 120, 23);
		contentPane.add(btnGuardar);
		
		
		//PARA QUE SE VEA LA VENTANA
		this.setVisible(true);
		
	}
}
