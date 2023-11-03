package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jMenuEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jMenuEmpleados frame = new jMenuEmpleados();
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
	public jMenuEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 130, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENÚ EMPLEADOS");
		menuBar.add(mnNewMenu);
		
		
		////MENÚ NUEVO EMPLEADO
		JMenuItem menuNuevo = new JMenuItem("Nuevo Empleado");
		menuNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new jNuevo();
				
			}
		});
		mnNewMenu.add(menuNuevo);
		
		
		////MENÚ MODIFICAR SALARIO
		JMenuItem menuSubirSalario = new JMenuItem("Modificar salario");
		menuSubirSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new jModificarSalario();
			}
		});
		mnNewMenu.add(menuSubirSalario);
		
		
		////MENÚ ELIMINAR EMPLEADO
		JMenuItem menuEliminar = new JMenuItem("Eliminar Empleado");
		menuEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new jEliminar();
			}
		});
		mnNewMenu.add(menuEliminar);
		
		
		
		
		//SALIR
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp=JOptionPane.showConfirmDialog(jMenuEmpleados.this, "¿Desea salir?", "Alerta", JOptionPane.YES_NO_OPTION);
				if(resp==JOptionPane.YES_OPTION) {
					 JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR EL PROGRAMA");
					 jMenuEmpleados.this.dispose();
				        
				}else{
					//si dice que no, no hago nada
				}
				
			}
		});
		btnSalir.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		btnSalir.setBounds(10, 211, 89, 23);
		contentPane.add(btnSalir);
	}
}
