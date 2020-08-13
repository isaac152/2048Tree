package arbolScores;

/**
 * Arbol binario que maneja los puntajes y partidas.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */
public class ArbolScores {

	private NodoScores primero;
	/**
	 * Constructor del arbol de puntajes.*/
	public ArbolScores(){
		this.primero = null;
	}
		/**
		 * Establece el primer nodo del arbol binario.
		 * @param NodoScores primero = primer nodo del arbol.
		 * */
	public void setPrimero(NodoScores primero) {
		this.primero = primero;
	}	
	
	/**
	 * Retorna el primer nodo del arbol binario.
	 * @return primero = primer nodo del arbol.
	 * */
	public NodoScores getPrimero() {
		return primero;
	}
	/**
	 * Inserta elementos al arbol en la primera posicion.
	 * Si el arbol es vacio, el primer elemento pasa a ser n.
	 * Si no lo es, se coloca el nodo existente como hijo derecho del arbol.
	 * @param NodoScores n = nodo a insertar.
	 * */
	public void insertarElementoPrimero(NodoScores n){
		if (primero == null)
			primero = n;
		else{
			NodoScores aux = primero;
			primero = n;
			primero.setRight(aux);
		}			
	}
		
}