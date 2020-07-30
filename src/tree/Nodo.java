package tree;

public class Nodo {
	private int valor=2;
	private Nodo derecha;
	private Nodo izquierda;
	
	public Nodo (){
		derecha=izquierda=null;
	}
	public Nodo (int valor){
		this.valor=valor;
		derecha=izquierda=null;
		
	}
	
	public int getValor() {
		return valor;
	}
	public Nodo getDerecha() {
		return derecha;
	}
	public Nodo getIzquierda() {
		return izquierda;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}
	
	
	
}
