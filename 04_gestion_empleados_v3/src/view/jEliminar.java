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

public class jEliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jEliminar frame = new jEliminar();
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
	public jEliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELIMINAR EMPLEADO");
		lblNewLabel.setBounds(36, 27, 158, 17);
		lblNewLabel.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(75, 98, 65, 24);
		contentPane.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(154, 95, 191, 33);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cerrar esta ventana jNuevo
				jEliminar.this.dispose();
				
			}
		});
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalir.setBounds(29, 199, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnEliminar = new JButton("ELIMINAR EMPLEADO");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//creamos la instancia //var es una forma de ahorrar poner el tipo (lo deduce del código del new) sustituye a PedidosService
				//var service = new ServiceEmpleados();
				ServiceEmpleados service = new ServiceEmpleados();			
				
				service.eliminarEmpleado(txtEmail.getText());
				jEliminar.this.dispose();
				
			}
		});
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnEliminar.setBounds(219, 199, 191, 23);
		contentPane.add(btnEliminar);
		
		
		//PARA QUE SE VEA LA VENTANA
		this.setVisible(true);
		
	}


	
}
