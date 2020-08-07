package tree;
public class Nodo {

	private int clave=2;
	private int nivel;
	private Nodo left;
	private Nodo right;
	private Nodo padre;
	private int posx;
	private int posy;
	private boolean ocupado;
	
	
	public Nodo(int clave){
		this.clave = clave;
		this.nivel = 0;
		this.right = null;
		this.left = null;
	}
	public Nodo(){
		this.right= null;
		this.left = null;
		this.nivel=0;
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

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
    public void Nivel() {
        int level = 0;
        Nodo n = this;
        while (n != null && n.padre != null) {
            level++;
            n = n.padre;
        }
         this.nivel=level;
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
	public int getPosy() {
		return posy;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
    
}