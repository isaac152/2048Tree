package Interfaz;
import tree.ArbolSupremo;
import tree.Nodo;
import tree.Global;

import DatosUsuario.Archivos;
import Guardado.ArchivoDatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
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
import java.io.FileNotFoundException;

import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;
/**
 * Clase que genera el tablero de juego.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */

public class Tablero extends JFrame implements ActionListener{

	private JPanel contentPane;
	static ArbolSupremo superarbolito = new ArbolSupremo();
	Nodo raiz= superarbolito.getRaiz();
	static Contenedor nivel0= new Contenedor();
	static Contenedor nivel1 = new Contenedor();
	static Contenedor nivel2 = new Contenedor();
	static Contenedor nivel3 = new Contenedor();
	static Contenedor nivel4 = new Contenedor();
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
		Global.setArbol(superarbolito.getArbol());
		if((ArchivoDatos.archivoExiste(Global.usuario))&&(ArchivoDatos.archivoVacio(Global.usuario)))
			ArchivoDatos.leerFichero(Global.usuario,true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			/**Cierre de ventana.
			 * @param e = click*/
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
		contentPane.setLayout(null);
		
		JLabel lblscore = new JLabel("Score");
		lblscore.setBounds(139, 5, 77, 18);
		lblscore.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblscore);
		Global.score.setBounds(180, 25, 36, 18);
		contentPane.add(Global.score);
		
		JLabel lblHiscore = new JLabel("High score");
		lblHiscore.setBounds(251, 5, 108, 18);
		lblHiscore.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblHiscore);
		
		Global.highScore.setBounds(260, 30, 74, 14);
		contentPane.add(Global.highScore);
		Global.maximoN.setBounds(15, 1, 66, 66);

		Global.maximoN.setIcon(new ImageIcon(Tablero.class.getResource(Nodo.asignarImagen(Global.esfera))));
		contentPane.add(Global.maximoN);
		
		JButton btnCrear = new JButton("A\u00F1adir Esfera");
		btnCrear.setBounds(376, 15, 141, 23);
		contentPane.add(btnCrear);
		btnCrear.addActionListener(this);

		
		//abajo
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setBounds(15, 61, 1335, 559);
		panel.setBackground(new Color(245, 222, 179));
		contentPane.add(panel);
		panel.setLayout(null);

		
		JPanel MenuInf = new JPanel();
		MenuInf.setBounds(15, 651, 1335, 49);
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
			
		/**
		 * Reinicia la partida.
		 * @param e = acci�n realizada.
		 * */
		JButton btnReiniciarPartida = new JButton("Reiniciar Partida");
		btnReiniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Global.Reinicio();
				validate();
				System.out.println("reset");
				
			}
		});
		btnReiniciarPartida.setBounds(894, 6, 424, 40);
		btnReiniciarPartida.setMinimumSize(new Dimension(200, 28));
		btnReiniciarPartida.setMaximumSize(new Dimension(200, 28));
		MenuInf.add(btnReiniciarPartida);
		
		
		JButton btnDeshacerMovimiento = new JButton("Deshacer Movimiento");
		btnDeshacerMovimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((ArchivoDatos.archivoExiste("T"+Global.usuario)))
					ArchivoDatos.leerFichero(Global.usuario,false);}
		});
		btnDeshacerMovimiento.setBounds(22, 6, 424, 40);
		MenuInf.add(btnDeshacerMovimiento);
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(458, 6, 424, 40);
		MenuInf.add(btnSalir);
		
		JLabel label = new JLabel("");
		ImageIcon icon2 = new ImageIcon(Tablero.class.getResource("/Imagenes/fondo.jpg"));
        Image img2 = icon2.getImage();
        Image newImg2 = img2.getScaledInstance(contentPane.getWidth(), contentPane.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc2 = new ImageIcon(newImg2);
		label.setIcon(newImc2);
		label.setBounds(0, 0, 1370, 705);
		contentPane.add(label);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Cierra la ventana.
			 * @param arg0 = click en ventana*/

			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				dispose();
			}
		});

		
	}
	/**
	 * Crea un nodo.
	 * @param evt = accion realizada.*/
    public void actionPerformed(ActionEvent evt) {
    	Boolean log= true;
    	int cont=1;
		while (log){
			if(cont<32){
	    		Nodo graf = Global.arbol.Buscar(raiz, cont);
	    		if (!graf.isOcupado()){	
	    			graf.setValor(2);
		    		Global.Flush();    	
		    		graf.gbc_graf.gridx=graf.getPosx();
		    		Pintarcontenedor(graf.getNivel(),graf);
	    			log=false;
						ArchivoDatos.crearArchivo(Global.usuario);

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
    /**Dibuja el nodo en el tablero.*/
    public static void Pintarcontenedor(int nivel,Nodo graf){
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
