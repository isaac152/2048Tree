package tree;
import Interfaz.Tablero;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Nodo {

	private int clave;
	private int valor=2;
	private int nivel=0;
	private Nodo left;
	private Nodo right;
	private int posx=1;
	public JLabel labelNodo;
	public GridBagConstraints gbc_graf = new GridBagConstraints();
	private boolean ocupado=false;
	
	
	public Nodo(){
		labelNodo = new JLabel("");
		this.right = null;
		this.left = null;
		String direccion= asignarImagen(this.valor);
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource(direccion)));
		gbc_graf.insets = new Insets(0, 0, 5, 5);
		gbc_graf.gridy=0;
		labelNodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Global.Click(clave);
					if(Global.id2!=0){
						Global.Sumar();
					}
			}
		});	}
	public void Vaciado(){
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/blanco.png")));
		this.valor=0;
		this.ocupado=false;
		
	}
	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public int getSize() {
		return nivel;
	}

	public void setSize(int size) {
		this.nivel = size;
	}

	public Nodo getLeft() {
		return left;
	}

	public void setLeft(Nodo left) {
		this.left = left;
	}

	public Nodo getRight() {
		return right;
	}

	public void setRight(Nodo right) {
		this.right = right;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getPosx() {
		return posx;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
		cambiar(valor);
		this.ocupado=true;
	}
	public void cambiar(int valor){
		this.valor=valor;
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource(asignarImagen(valor))));
	}
	private String asignarImagen(int valor){
		String aux= String.valueOf(valor);
		return "/Imagenes/esfera"+aux+".png";
	}

    
}