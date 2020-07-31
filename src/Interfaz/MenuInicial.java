package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class MenuInicial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuInicial dialog = new MenuInicial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuInicial() {
		setResizable(false);
		setBounds(100, 100, 349, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(97, 8, 66, 66);
		label.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagenes/esfera2048.png")));
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(100, 43, 0, 0);
		contentPanel.add(label_1);
		
		JLabel lblNombreDeUsuario = new JLabel("USUARIO:");
		lblNombreDeUsuario.setBounds(97, 88, 66, 14);
		lblNombreDeUsuario.setFont(new Font("Georgia", Font.ITALIC, 12));
		contentPanel.add(lblNombreDeUsuario);
		
		textUser = new JTextField();
		textUser.setBounds(175, 85, 86, 20);
		contentPanel.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setBounds(70, 122, 93, 14);
		lblContrasea.setFont(new Font("Georgia", Font.ITALIC, 12));
		contentPanel.add(lblContrasea);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(246, 91, 0, 0);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(251, 91, 0, 0);
		contentPanel.add(label_4);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(175, 119, 86, 20);
		contentPanel.add(passwordField);
		
		JLabel lblbtree = new JLabel("-BTree");
		lblbtree.setForeground(new Color(0, 51, 204));
		lblbtree.setFont(new Font("Georgia", Font.BOLD, 29));
		lblbtree.setBounds(163, 24, 123, 38);
		contentPanel.add(lblbtree);
		{
			JButton btnIngresar = new JButton("Ingresar");
			btnIngresar.setBounds(127, 151, 93, 23);
			contentPanel.add(btnIngresar);
			btnIngresar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//busca username y pass y compara
					
						Tablero frame= new Tablero();
						frame.setVisible(true);
						setVisible(false);
						dispose();
			
					
				}
			});
			btnIngresar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnIngresar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
			btnRegistrarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					RegistroUsuario a = new RegistroUsuario();
					a.setVisible(true);
					dispose();
				}
			});
			btnRegistrarUsuario.setActionCommand("OK");
			buttonPane.add(btnRegistrarUsuario);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}
}