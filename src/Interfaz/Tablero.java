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
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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

	private int convertInt(String a){
	
	int foo;
	try {
	   foo = Integer.parseInt(a);
	}
	catch (NumberFormatException e)
	{
	   foo = 0;
	}
	return foo;
	}
	
	public Tablero() {
		JLabel lblHighScore = new JLabel("HIGH SCORE");
		setTitle("2048 GANG TIME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNodo = new JLabel("");
		
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/esfera2.png")));
		labelNodo.setBounds(38, 541, 66, 66);
		contentPane.add(labelNodo);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 102, 582, 409);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSumaM = new JLabel("SUMA M\u00C1XIMA");
		lblSumaM.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblSumaM.setBounds(28, 29, 124, 19);
		contentPane.add(lblSumaM);
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblScore.setBounds(145, 29, 124, 19);
		contentPane.add(lblScore);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(123, 104, 238));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 48, 89, 43);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("0");
		JLabel label = new JLabel("0");
		label.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent text) {
				int a=convertInt(label.getText()), b=convertInt(label_1.getText());
				
				
				if((a>b)&&(b%2==0)){
					label_1.setText(label.getText());
				}
			}
		});
		label.setBounds(145, 48, 46, 14);
		contentPane.add(label);
		
		
		lblHighScore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblHighScore.setBounds(145, 63, 124, 19);
		contentPane.add(lblHighScore);
		
		
		label_1.setBounds(145, 77, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblComodin = new JLabel("COMODIN");
		lblComodin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblComodin.setBounds(38, 522, 124, 19);
		contentPane.add(lblComodin);
		
		JButton btnDeshacer = new JButton("DESHACER MOVIMIENTO");
		btnDeshacer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnDeshacer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//DESHACER MOVIMIENTO: ELIMINA EL ULTIMO NODO AGREGADO
				label.setText("0"); //PUNTAJE ANTERIOR
				
			}
		});
		btnDeshacer.setBounds(114, 522, 227, 88);
		contentPane.add(btnDeshacer);
		
		JButton btnReiniciarPartida = new JButton("REINICIAR PARTIDA");
		btnReiniciarPartida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ELIMINA PUNTAJES:
				label.setText("0");
				//ELIMINA NODOS VISIBLES
				//RETORNA VALORES ORIGINALES DE LOS NODOS A 0
			}
		});
		btnReiniciarPartida.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnReiniciarPartida.setBounds(351, 522, 259, 38);
		contentPane.add(btnReiniciarPartida);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSalir.setBounds(351, 572, 259, 38);
		contentPane.add(btnSalir);
	}
}
