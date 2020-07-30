package tree;

public class ArbolB {
	// raiz del arbol o primer nodo
    private Nodo raiz; 
    private int tamano=1;
  
    // Constructores 
    ArbolB(int valor){ 
        raiz = new Nodo(valor);
        } 
  
    ArbolB(){ 
        raiz = new Nodo();
        } 
    
    public boolean esVacio(){
    	return (raiz==null); //true es vacio 
    }
    public void insertarNodo(Nodo insertar,Nodo aux){
    		
    	if (aux.getIzquierda()==null)
    		aux.setIzquierda(insertar);
    	else
    	{
    		if (aux.getDerecha()==null)
    			aux.setDerecha(insertar);
    		else
    		{
    			aux=aux.getIzquierda();
    			insertarNodo(insertar,aux);
    		}
    	}
    			
    }
}
