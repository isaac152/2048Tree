package tree;
import Interfaz.Tablero;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**Clase que maneja el nodo del arbol interno del juego.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G*/
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
	
	/**Constructor del nodo del arbol interno del juego.*/
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
	/**
	 *Vacia el nodo.
	 * */
	public void Vaciado(){
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/blanco.png")));
		this.valor=0;
		this.ocupado=false;
		
	}
	/**
	 *Retorna la clave del nodo.
	 *@return clave = clave del nodo.
	 * */
	public int getClave() {
		return clave;
	}

	/**
	 *Asigna la clave del nodo.
	 *@param clave = clave del nodo.
	 * */
	public void setClave(int clave) {
		this.clave = clave;
	}

	/**
	 *Retorna el hijo izquierdo del nodo.
	 *@return left = hijo izquierdo.
	 * */
	public Nodo getLeft() {
		return left;
	}

	/**
	 *Asigna el hijo izquierdo del nodo.
	 *@param left = hijo izquierdo.
	 * */
	public void setLeft(Nodo left) {
		this.left = left;
	}

	/**
	 *Retorna el hijo derecho del nodo.
	 *@return right = hijo derecho.
	 * */
	public Nodo getRight() {
		return right;
	}

	/**
	 *Asigna el hijo derecho del nodo.
	 *@param right = hijo derecho.
	 * */
	public void setRight(Nodo right) {
		this.right = right;
	}

	/**
	 *Retorna el nivel del nodo.
	 *@return nivel = nivel del nodo.
	 * */
	public int getNivel() {
		return nivel;
	}

	/**
	 *Asigna el nivel del nodo.
	 *@param nivel = nivel del nodo.
	 * */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 *Retorna coordenadas en x del nodo.
	 *@return posx = coordenadas en x.
	 * */
	public int getPosx() {
		return posx;
	}
	/**
	 * Verifica si la posición ya está ocupada.
	 * @return ocupado = true si está ocupada, false si no.*/
	public boolean isOcupado() {
		return ocupado;
	}
	/**
	 *Asigna coordenadas en x del nodo.
	 *@param posx = coordenadas en x.
	 * */
	public void setPosx(int posx) {
		this.posx = posx;
	}
	/**
	 *Asigna valor V/F a la posición del nodo.
	 *@param ocupado = valor V/F
	 * */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	/**
	 *Retorna valor del nodo.
	 *@return valor = valor del nodo.
	 * */
	public int getValor() {
		return valor;
	}
	/**
	 *Asigna valor del nodo.
	 *@param valor = valor del nodo.
	 * */
	public void setValor(int valor) {
		this.valor = valor;
		cambiar(valor);
	}
	/**
	 *Cambia la imagen del nodo gráfico dado el valor numérico.
	 *@param valor = valor del nodo.
	 * */
	public void cambiar(int valor){
		this.valor=valor;
		labelNodo.setIcon(new ImageIcon(Tablero.class.getResource(asignarImagen(valor))));
	}
	
	/**
	 *Busca la ubicación de la imagen del nodo gráfico dado el valor numérico.
	 *@param valor = valor del nodo.
	 * */
	private String asignarImagen(int valor){
		String aux= String.valueOf(valor);
		return "/Imagenes/esfera"+aux+".png";
	}

    
}