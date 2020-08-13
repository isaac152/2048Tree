package arbolScores;


public class ArbolScores {

	private NodoScores primero;
	
	public ArbolScores(){
		this.primero = null;
	}
		
	public void setPrimero(NodoScores primero) {
		this.primero = primero;
	}	
	
	public NodoScores getPrimero() {
		return primero;
	}
		
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