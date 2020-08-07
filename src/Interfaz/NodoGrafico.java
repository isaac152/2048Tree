package Interfaz;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tree.Nodo;
public class NodoGrafico {
	private Nodo nodo;
	private int valor=2;

	public int tamano=66;
	
	JLabel labelNodo;
	

	public NodoGrafico(int valor) {
		labelNodo = new JLabel("");
		String direccion= asignarImagen(valor);
		labelNodo.setIcon(new ImageIcon(TestGrid.class.getResource(direccion)));
		labelNodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
	}
	public NodoGrafico(Nodo nodo) {
		this.nodo=nodo;
		labelNodo = new JLabel("");
		valor= nodo.getClave();
		String direccion= asignarImagen(valor);
		ImageIcon icon = new ImageIcon(TestGrid.class.getResource(direccion));
		java.awt.Image image = icon.getImage();
		java.awt.Image newimg = image.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH);
		
		labelNodo.setIcon(new ImageIcon(newimg));
		
		Dimension a = new Dimension(20,20);
		labelNodo.setMaximumSize(a);
		labelNodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				valor=valor*2;
				cambiar(valor);
				
			}
		}
		
				)
		;
		labelNodo.setSize(a);
	}

	public void cambiar(int valor){
		labelNodo.setIcon(new ImageIcon(TestGrid.class.getResource(asignarImagen(valor))));
		labelNodo.setSize(10, 10);
		labelNodo.setBounds(1000,1000,20,20);
		Dimension a = new Dimension(20,20);
		labelNodo.setMaximumSize(a);
	}
	public String asignarImagen(int valor){
		String aux= String.valueOf(valor);
		return "/Imagenes/esfera"+aux+".png";
	}
	
	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
		labelNodo.setIcon(new ImageIcon(TestGrid.class.getResource(asignarImagen(valor))));
		Dimension a = new Dimension(20,20);
		labelNodo.setMaximumSize(a);
	}


	public Nodo getNodo() {
		return nodo;
	}


	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}




}
