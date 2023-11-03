package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principal.ServiceEmpleados;
import view.adapters.TablaEmpleadosModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class jBuscarEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDepartamento;
	private JTable tbEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jBuscarEmpleados frame = new jBuscarEmpleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jBuscarEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepartamento = new JLabel("Nombre del Departamento:");
		lblDepartamento.setFont(new Font("Verdana", Font.BOLD, 13));
		lblDepartamento.setBounds(10, 12, 210, 26);
		contentPane.add(lblDepartamento);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setFont(new Font("Verdana", Font.BOLD, 12));
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(230, 11, 182, 31);
		contentPane.add(txtDepartamento);
		
		//SALIR
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cerrar esta ventana jNuevo
				jBuscarEmpleados.this.dispose();
			}
		});
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalir.setBounds(283, 227, 96, 23);
		contentPane.add(btnSalir);
		
		//BUSCAR POR DEPARTAMENTO
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llama a todos los empleados de un departamento, constructor sobrecargaro con un parámetro:
				tbEmpleados.setModel(new TablaEmpleadosModel(txtDepartamento.getText().toString()));
				
				
				
			}
		});
		btnBuscar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnBuscar.setBounds(266, 53, 120, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 87, 390, 129);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		
		
		
		//PARA QUE SE VEA LA VENTANA
		this.setVisible(true);
	}
}
