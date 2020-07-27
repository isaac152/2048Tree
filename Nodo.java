package arbolbin;

public class Nodo {
	private int x;
	private Nodo hijoDer;
	private Nodo hijoIzq;
	
	//construct
	
	public Nodo(int x){
		this.x=x;
		hijoIzq=hijoDer=null;
		}
	
	//getsetters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Nodo getHijoDer() {
		return hijoDer;
	}
	public void setHijoDer(Nodo hijoDer) {
		this.hijoDer = hijoDer;
	}
	public Nodo getHijoIzq() {
		return hijoIzq;
	}
	public void setHijoIzq(Nodo hijoIzq) {
		this.hijoIzq = hijoIzq;
	}
	
	
}
