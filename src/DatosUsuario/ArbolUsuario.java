package DatosUsuario;
/**
 * Arbol binario que maneja los datos de los usuarios.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */

public class ArbolUsuario {
		
	private NodoUsuario primero;
	/**
	 * Constructor del arbol de datos de usuario.
	 * */
	public ArbolUsuario(){
		this.primero = null;
	}
	/**
	 * Asigna el primer nodo del arbol binario.
	 * @param primero = primer nodo del arbol.
	 * */
	public void setPrimero(NodoUsuario primero) {
		this.primero = primero;
	}	
	/**
	 * Retorna el primer nodo del arbol binario.
	 * @return primero = primer nodo del arbol.
	 * */
	public NodoUsuario getPrimero() {
		return primero;
	}
	/**
	 * Inserta elementos al arbol en la primera posicion.
	 * Si el arbol es vacio, el primer elemento pasa a ser n.
	 * Si no lo es, se coloca el nodo existente como hijo derecho del arbol.
	 * @param n = nodo a insertar.
	 * */
	public void insertarElementoPrimero(NodoUsuario n){
		if (primero == null)
			primero = n;
		else{
			NodoUsuario aux = primero;
			primero = n;
			primero.setRight(aux);
		}			
	}
		
}