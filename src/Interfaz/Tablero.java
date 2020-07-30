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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero frame = new Tablero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		
		JButton btnNodo = new JButton("");
		btnNodo.setBackground(Color.BLACK);
		btnNodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Hola");
			}
		});
		btnNodo.setBounds(134, 74, 70, 66);
		btnNodo.setBorderPainted(false);
		btnNodo.setBorder(null);


		contentPane.add(btnNodo);
		
		JLabel labelNodo = new JLabel("");
		labelNodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("AAAAAAAAAAA");
			}
		});
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/esfera2.png")));
		labelNodo.setBounds(272, 48, 70, 66);
		contentPane.add(labelNodo);
	}
}
