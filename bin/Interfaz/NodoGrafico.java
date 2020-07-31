package Interfaz;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tree.Nodo;

public class NodoGrafico {
	private Nodo nodo;
	private int valor=2;
	private int posx;
	private int posy;
	public int tamano=66;
	
	JLabel labelNodo;

	public NodoGrafico(int valor) {
		labelNodo = new JLabel("");
		String direccion= asignarImagen(valor);
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource(direccion)));
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
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource(asignarImagen(valor))));
	}


	public Nodo getNodo() {
		return nodo;
	}


	public int getPosx() {
		return posx;
	}


	public int getPosy() {
		return posy;
	}


	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}


	public void setPosx(int posx) {
		this.posx = posx;
	}


	public void setPosy(int posy) {
		this.posy = posy;
	}

}
