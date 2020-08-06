package DatosUsuario;

public class ArbolUsuario {
		
	private NodoUsuario primero;
		
	public ArbolUsuario(){
		this.primero = null;
	}
		
	public void setPrimero(NodoUsuario primero) {
		this.primero = primero;
	}	
	
	public NodoUsuario getPrimero() {
		return primero;
	}
		
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