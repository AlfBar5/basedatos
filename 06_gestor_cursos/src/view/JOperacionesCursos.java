package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.FicheroService;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOperacionesCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOperacionesCursos frame = new JOperacionesCursos();
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
	public JOperacionesCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 162, 30);
		contentPane.add(menuBar);
		
		JMenu menuC = new JMenu("Menú Cursos");
		menuBar.add(menuC);
		
		JMenuItem menuActualizar = new JMenuItem("Actualizar Cursos");
		menuActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciar FicheroService
				FicheroService service=new FicheroService();
				service.actualizarDatos();
				
			}
		});
		menuC.add(menuActualizar);
		
		JMenuItem menuConsulta = new JMenuItem("Consultar Cursos");
		menuC.add(menuConsulta);
	}
}
