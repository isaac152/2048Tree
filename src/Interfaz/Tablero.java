package Interfaz;
import tree.ArbolSupremo;
import tree.Nodo;
import tree.Global;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class Tablero extends JFrame implements ActionListener{

	private JPanel contentPane;
	ArbolSupremo superarbolito = new ArbolSupremo();
	Nodo raiz= superarbolito.getRaiz();
	Contenedor nivel0= new Contenedor();
	Contenedor nivel1 = new Contenedor();
	Contenedor nivel2 = new Contenedor();
	Contenedor nivel3 = new Contenedor();
	Contenedor nivel4 = new Contenedor();
	Contenedor varas1=new Contenedor();
	Contenedor varas2=new Contenedor();
	Contenedor varas3=new Contenedor();
	Contenedor varas4=new Contenedor();


	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Tablero() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	        	//guardar datos
	        	setVisible(false);
	            dispose();
	            System.out.println(";)");
	        }
	    });
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1452, 744);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(getBounds());
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		//superior
		
		JLabel lblSumaMaxima = new JLabel("Suma Maxima");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSumaMaxima, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSumaMaxima, 10, SpringLayout.WEST, contentPane);
		lblSumaMaxima.setForeground(new Color(255, 0, 0));
		lblSumaMaxima.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblSumaMaxima);
		
		JLabel lblscore = new JLabel("Score");
		lblscore.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblscore, 0, SpringLayout.NORTH, lblSumaMaxima);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblscore, 65, SpringLayout.EAST, lblSumaMaxima);
		contentPane.add(lblscore);
		
		
		sl_contentPane.putConstraint(SpringLayout.NORTH,Global.score, 6, SpringLayout.SOUTH, lblscore);
		sl_contentPane.putConstraint(SpringLayout.WEST, Global.score, 190, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Global.score, -10, SpringLayout.EAST, lblscore);
		contentPane.add(Global.score);
		
		JLabel lblHiscore = new JLabel("HIGH score");
		lblHiscore.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblHiscore, 0, SpringLayout.NORTH, lblSumaMaxima);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHiscore, 35, SpringLayout.EAST, lblscore);
		contentPane.add(lblHiscore);
		
		JLabel lblHiscoreVar = new JLabel("???");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblHiscoreVar, 0, SpringLayout.NORTH, Global.score);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblHiscoreVar, 306, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblHiscoreVar, -10, SpringLayout.EAST, lblHiscore);
		contentPane.add(lblHiscoreVar);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, Global.maximoN, 6, SpringLayout.SOUTH, lblSumaMaxima);
		sl_contentPane.putConstraint(SpringLayout.WEST, Global.maximoN, 10, SpringLayout.WEST, lblSumaMaxima);
		contentPane.add(Global.maximoN);
		
		JButton btnCrear = new JButton("Boton");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCrear, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCrear, 57, SpringLayout.EAST, lblHiscore);
		contentPane.add(btnCrear);
		btnCrear.addActionListener(this);

		
		//abajo
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 16, SpringLayout.SOUTH, Global.maximoN);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -15, SpringLayout.EAST, contentPane);
		panel.setBounds(15, 63, 1314, 570);
		panel.setBackground(new Color(245, 222, 179));
		contentPane.add(panel);
		panel.setLayout(null);

		
		JPanel MenuInf = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, MenuInf, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, MenuInf, -15, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -31, SpringLayout.NORTH, MenuInf);
		sl_contentPane.putConstraint(SpringLayout.NORTH, MenuInf, 646, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, MenuInf, 0, SpringLayout.SOUTH, contentPane);
		MenuInf.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		MenuInf.setBackground(new Color(135, 206, 235));
		contentPane.add(MenuInf);
		MenuInf.setLayout(null);

		//Contenedores - Conectores
		
		varas1.panel.setBounds(6, 83, 1323, 38);
		varas1.gbl_panel.columnWidths = new int[]{467, 3, 335, 3, 0};
		varas1.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(varas1.panel);

		varas2.panel.setBounds(6, 200, 1323, 38);
		varas2.gbl_panel.columnWidths = new int[]{283, 3, 129, 3, 374, 3, 140, 3, 0};
		varas2.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(varas2.panel);
		
		varas3.panel.setBounds(6, 317, 1323, 38);
		varas3.gbl_panel.columnWidths = new int[]{190, 3, 32, 3, 191, 3, 32, 3, 194, 3, 32, 3, 185, 3, 33, 3, 0};
		varas3.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(varas3.panel);
				
		varas4.panel.setBounds(6, 435, 1323, 38);
		varas4.gbl_panel.columnWidths = new int[]{119, 3, 32, 3, 42, 3, 33, 3, 60, 3, 32, 3, 45, 3, 32, 3, 49, 3, 32, 3, 58, 3, 32, 3, 41, 3, 32, 3, 49, 3, 32, 3, 0};
		varas4.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(varas4.panel);


		//Conectores
		
		Palito conector1 = new Palito(1);
		conector1.gbc_label.gridx=1;
		varas1.panel.add(conector1.label,conector1.gbc_label);
		
		Palito conector2 = new Palito(2);
		conector2.gbc_label.gridx = 3;
		varas1.panel.add(conector2.label, conector2.gbc_label);
		
		int gridx=-1;
		for (int i=1;i<5;i++){
			Palito conector3= new Palito(i%2);
			gridx=gridx+2;
			conector3.gbc_label.gridx=gridx;
			varas2.panel.add(conector3.label,conector3.gbc_label);
		}
		gridx=-1;
		
		for (int i=1;i<9;i++){
			Palito conector4 =new Palito(i%2);
			gridx=gridx+2;
			conector4.gbc_label.gridx=gridx;
			varas3.panel.add(conector4.label,conector4.gbc_label);
		
		}
		gridx=-1;
		
		for (int i=1;i<17;i++){
			Palito conector5 =new Palito(i%2);
			gridx=gridx+2;
			conector5.gbc_label.gridx=gridx;
			varas4.panel.add(conector5.label,conector5.gbc_label);
		}
				
		//Contenedores - Niveles
		nivel0.panel.setBounds(6, 6, 1323, 75);
		nivel0.gbl_panel.columnWidths = new int[]{629, 7, 0};
		nivel0.gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.add(nivel0.panel);

		nivel1.panel.setBounds(6, 123, 1323, 75);
		nivel1.gbl_panel.columnWidths = new int[]{337, 7, 495, 7, 0};
		nivel1.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(nivel1.panel);
		
		nivel2.panel.setBounds(6, 240, 1323, 75);
		nivel2.gbl_panel.columnWidths = new int[]{198, 7, 215, 7, 212, 7, 203, 7, 0};
		nivel2.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(nivel2.panel);

		nivel3.panel.setBounds(6, 358, 1323, 75);
		nivel3.gbl_panel.columnWidths = new int[]{131, 7, 59, 7, 82, 14, 63, 14, 69, 14, 87, 14, 60, 14, 62, 14, 0};
		nivel3.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(nivel3.panel);
	
		nivel4.panel.setBounds(6, 476, 1323, 75);
		nivel4.gbl_panel.columnWidths = new int[]{93, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 0};
		nivel4.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.add(nivel4.panel);		
		
		//Raiz
		raiz.gbc_graf.gridx=1;
		nivel0.panel.add(raiz.labelNodo, raiz.gbc_graf);
		Global.setArbol(superarbolito.getArbol());
			
		
		JButton btnReiniciarPartida = new JButton("Reiniciar Partida");
		btnReiniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Global.Reinicio();
				validate();
				//guardar partida en txt como partida nueva
			}
		});
		btnReiniciarPartida.setBounds(894, 6, 424, 40);
		btnReiniciarPartida.setMinimumSize(new Dimension(200, 28));
		btnReiniciarPartida.setMaximumSize(new Dimension(200, 28));
		MenuInf.add(btnReiniciarPartida);
		
		
		JButton btnDeshacerMovimiento = new JButton("Deshacer Movimiento");
		btnDeshacerMovimiento.setBounds(22, 6, 424, 40);
		MenuInf.add(btnDeshacerMovimiento);
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(458, 6, 424, 40);
		MenuInf.add(btnSalir);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//guardar juego
				setVisible(false);
				dispose();
			}
		});

		
	}
    public void actionPerformed(ActionEvent evt) {
    	Boolean log= true;
    	int cont=1;
		while (log){
			if(cont<32){
	    		Nodo graf = superarbolito.getArbol().Buscar(raiz, cont);
	    		if (!graf.isOcupado()){	
	    			graf.setValor(2);
		    		Global.Flush();    	
		    		graf.gbc_graf.gridx=graf.getPosx();
		    		Pintarcontenedor(graf.getNivel(),graf);
		    		graf.setOcupado(true);
	    			log=false;
	    		}
	    		else
	    			cont++;
			}
			else
				{System.out.println("No se puede crear mas");
	    		Global.Flush();    	
				break;
				}
    	}
		validate();
		
    }
    public void Pintarcontenedor(int nivel,Nodo graf){
    	switch(nivel){
    	case 1:
    		nivel1.panel.add(graf.labelNodo, graf.gbc_graf);
    		break;
    	case 2:
    		nivel2.panel.add(graf.labelNodo, graf.gbc_graf);
    		break;
    	case 3:
    		nivel3.panel.add(graf.labelNodo, graf.gbc_graf);
    		break;
    	case 4:
    		nivel4.panel.add(graf.labelNodo, graf.gbc_graf);
    		break;
    	}
    }
}
