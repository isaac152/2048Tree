package Interfaz;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tree.Nodo;

public class NodoGrafico {
	Nodo nodo;
	int posx;
	int posy;
	JLabel labelNodo;

	public NodoGrafico(Nodo nodo) {
		
		int valor= nodo.getValor();
		labelNodo = new JLabel("");
		String direccion= asignarImagen(valor);
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource(direccion)));
	}


	public String asignarImagen(int valor){
		String aux= String.valueOf(valor);
		return "/Imagenes/esfera"+aux+".png";
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
