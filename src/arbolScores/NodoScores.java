package arbolScores;

/**
 * Clase que establece los nodos del arbol binario que maneja los puntajes y partidas.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */
public class NodoScores {
	/*username, mov1,mov2,hiscore,sumamax*/
	private String username;
	private String mov1;
	private String mov2;
	private int hiscore;
	private int sumamax;
	private NodoScores left;
	private NodoScores right;
	/**Constructor del nodo de puntajes.
	 * @param user = nombre de usuario
	 * @param m1 = movimiento actual
	 * @param m2 = movimiento anterior
	 * @param hs = mayor puntaje obtenido
	 * @param sumamax = mayor suma obtenida */
	public NodoScores(String user,String m1,String m2,int hs,int max) {
		this.username=user;
		this.mov1=m1;
		this.mov2=m2;
		this.hiscore=hs;
		this.sumamax=max;
		this.left=null;
		this.right=null;
	}
	/**Constructor del nodo de puntajes.*/
	public NodoScores() {

	}
	  /**
	   * Retorna el nombre de usuario del jugador actual.
	   * @return username
	   * */
	public String getUsername() {
		return username;
	}
	
	/**
	   * Asigna el nombre de usuario del jugador actual.
	   * @param username
	   * */
	public void setUsername(String username) {
		this.username = username;
		
	}
	
	/**
	   * Retorna el movimiento actual.
	   * @return Mov1=movimiento actual
	   * */
	public String getMov1() {
		return mov1;
	}
	
	/**
	   * Asigna el movimiento actual.
	   * @param Mov1=movimiento actual
	   * */
	public void setMov1(String mov1) {
		this.mov1 = mov1;
	}

	/**
	   * Retorna el movimiento anterior al actual.
	   * @return Mov2=movimiento anterior
	   * */
	public String getMov2() {
		return mov2;
	}
	
	/**
	   * Asigna el movimiento anterior al actual.
	   * @param Mov2=movimiento anterior
	   * */
	public void setMov2(String mov2) {
		this.mov2 = mov2;
	}
	
	/**
	   * Retorna el puntaje mayor obtenido por el usuario.
	   * @return hiscore = puntaje mayor
	   * */
	public int getHiscore() {
		return hiscore;
	}
	
	/**
	   * Asigna el puntaje mayor obtenido por el usuario.
	   * @param hiscore = puntaje mayor
	   * */
	public void setHiscore(int hiscore) {
		this.hiscore = hiscore;
	}
	
	/**
	   * Retorna la mayor suma de esferas obtenida por el usuario.
	   * @return sumamax = suma mayor
	   * */
	public int getSumamax() {
		return sumamax;
	}
	
	/**
	   * Asigna la mayor suma de esferas obtenida por el usuario.
	   * @param sumamax = suma mayor
	   * */
	public void setSumamax(int sumamax) {
		this.sumamax = sumamax;
	}
	
	/**
	   * Retorna el hijo izquierdo del nodo actual.
	   * @return left = hijo izquierdo
	   * */
	public NodoScores getLeft() {
		return left;
	}
	
	/**
	   * Asigna el hijo izquierdo del nodo actual.
	   * @param left = hijo izquierdo
	   * */
	public void setLeft(NodoScores left) {
		this.left = left;
	}
	
	/**
	   * Retorna el hijo derecho del nodo actual.
	   * @return right = hijo derecho
	   * */
	public NodoScores getRight() {
		return right;
	}
	

	/**
	   * Asigna el hijo derecho del nodo actual.
	   * @param right = hijo derecho
	   * */
	public void setRight(NodoScores right) {
		this.right = right;
	}
	

	/**
	   * Overwrite para imprimir los datos del nodo.
	   * @return datos del nodo en un String.
	   * */
	public String toString(){
		return("Node [USER = "+ username + "----   MOV1 = "+ mov1+ "----   MOV2 = "+ mov2+ "----   HISCORE = "+ hiscore+ "----   SUMAMAX = "+ sumamax+  "]");
	} 
    
}