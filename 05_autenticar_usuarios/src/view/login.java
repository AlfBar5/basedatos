package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Usuario;
import service.UsuarioService;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUser = new JLabel("USUARIO:");
		lbUser.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lbUser.setBounds(42, 28, 108, 39);
		contentPane.add(lbUser);
		
		JLabel lbPass = new JLabel("CONTRASEÑA:");
		lbPass.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lbPass.setBounds(42, 87, 108, 39);
		contentPane.add(lbPass);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
		txtUser.setBounds(173, 35, 147, 28);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Verdana Pro", Font.PLAIN, 13));
		txtPass.setColumns(10);
		txtPass.setBounds(173, 93, 147, 28);
		contentPane.add(txtPass);
		
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//instancio UsuarioService
				UsuarioService service = new UsuarioService(); 
				
				//instancio usuario con los datos que recibo del formulario
				Usuario user= new Usuario(txtUser.getText(), txtPass.getText());
				
				//si quiero referirme al this.objetoventana, tengo que referirme a la clase login: login.this
				if(service.autenticar(user)) {
					JOptionPane.showMessageDialog(login.this, "Usuario válido");
					
				}else {
					JOptionPane.showMessageDialog(login.this, "Usuario no válido");
				}
				
				
				
			}
		});
		
		
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setFont(new Font("Verdana Pro", Font.BOLD, 14));
		btnEntrar.setBounds(173, 145, 147, 28);
		contentPane.add(btnEntrar);
	}

}
