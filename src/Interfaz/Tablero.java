package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;

public class Tablero extends JFrame {

	private JPanel contentPane;
	int y=272;
	int x=48;
	int v=2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MenuInicial a = new MenuInicial();
					a.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		NodoGrafico prueba= new NodoGrafico(v);

		prueba.labelNodo.setBounds(y,x,prueba.tamano,prueba.tamano);

		contentPane.add(prueba.labelNodo);
		
		
		JButton btnNewButton_1 = new JButton("Otro boton pues");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prueba.setValor(prueba.getValor()*2);
			}
		});
		
		JButton btnNewButton = new JButton("Un boton");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				y=y+10;
				x=x+10;
				prueba.labelNodo.setBounds(y,x,prueba.tamano,prueba.tamano);

			}
		});
		
		btnNewButton.setBounds(32, 79, 164, 96);
		contentPane.add(btnNewButton);
		btnNewButton_1.setBounds(29, 299, 203, 96);
		contentPane.add(btnNewButton_1);
		
		JButton btnRegistroUser = new JButton("registro user");
		btnRegistroUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroUsuario a = new RegistroUsuario();
				a.setVisible(true);
			}
		});
		btnRegistroUser.setBounds(276, 90, 115, 61);
		contentPane.add(btnRegistroUser);
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setLocation(-29, -13);
		lblNewLabel.setSize(6686, 5030);
		lblNewLabel.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/fondo2.jpg")));
		
		

		contentPane.add(lblNewLabel);
	}
}
