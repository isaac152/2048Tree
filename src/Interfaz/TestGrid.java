package Interfaz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tree.Arbol;
import tree.Nodo;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

public class TestGrid extends JFrame implements ActionListener {

	private JPanel contentPane;
	Nodo nodo = new Nodo(2);
	NodoGrafico raiz = new NodoGrafico(nodo);
	Arbol arbol = new Arbol();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGrid frame = new TestGrid();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestGrid() {
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 212);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 0};
		gbl_contentPane.rowHeights = new int[]{35, 35, 35, 35, 35, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		JButton btnAaa = new JButton("AAA");
		
		GridBagConstraints gbc_btnAaa = new GridBagConstraints();
		gbc_btnAaa.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAaa.insets = new Insets(0, 0, 5, 5);
		gbc_btnAaa.gridx = 1;
		gbc_btnAaa.gridy = 0;
		contentPane.add(btnAaa, gbc_btnAaa);

		GridBagConstraints gbc_raiz = new GridBagConstraints();
		gbc_raiz.insets = new Insets(0, 0, 5, 5);
		gbc_raiz.gridx = 15;
		gbc_raiz.gridy = 0;
		arbol.setRaiz(nodo);
		
		btnAaa.addActionListener(this);
		setVisible(true);
		contentPane.add(raiz.labelNodo, gbc_raiz);

}
    public void actionPerformed(ActionEvent evt) {
		Nodo nodo = new Nodo();
		NodoGrafico graf = new NodoGrafico(nodo);
		GridBagConstraints gbc_graf = new GridBagConstraints();
		gbc_graf.insets = new Insets(0, 0, 5, 5);
		arbol.insert(graf.getNodo());
		nodo.Nivel();
		System.out.println(nodo.getNivel());
		nodo.setPosx(Pintar(nodo.getNivel(),arbol.getRaiz(),arbol));
		nodo.setPosy(nodo.getNivel());
		System.out.println(nodo.getPosx());
		System.out.println(nodo.getPosy());
		gbc_graf.gridx=nodo.getPosx();
		gbc_graf.gridy=nodo.getPosy();
		
		validate();
		getContentPane().add(graf.labelNodo, gbc_graf);
		pack();
		
    }
     public int Pintar (int nivel,Nodo n,Arbol a){
    	boolean log=true;
    	int x=0;
    	switch(nivel){
    	case 1:
    		if(Validez(a.Busqueda(n,7,nivel)))
    			return 23;
    		else
    			return 7;
    	case 2:
    		 x=3;
    		 while(log){
    			 if((!Validez(a.Busqueda(n, x, nivel)))){
    				 return x;
    			 }
    			 x=x+8;
    			 if(x>27){
    				 break;
    			 }
    		 }
    	case 3:
    		x=1;
    		while (log){
   			 if((!Validez(a.Busqueda(n, x, nivel)))){
   					 return x;
   				 }
   				 x=x+4;
   				 if(x>29)
   					 break;
   			 }
    		
    	case 4:
    		x=0;
    		while (log){
    			if(!Validez(a.Busqueda(n, x, nivel))){
    				return x;
    			}
    			x=x+2;
    			if(x>30)
    				break;
    		}
    	}
    	return 0;
    }
 	public static Boolean Validez(Nodo r){
		boolean log= false;
		if (r==null)
			log=false;
		else
			log=true;
	
		return log;
	}

}
