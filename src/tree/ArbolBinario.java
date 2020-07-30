/*package tree;

public class ArbolBinario {

	// raiz del arbol o primer nodo
    Nodo raiz; 
  
    // Constructores 
    ArbolBinario(int x){ 
        raiz = new Nodo(x);
        } 
  
    ArbolBinario(){ 
        raiz = null;
        } 
    
    public boolean esVacio(){
    	return (raiz==null); //true es vacio 
    }
    
    //insertar nodo
    
    private Nodo insertarNodo (Nodo actual, int valor){
    	if (actual==null){
    		return new Nodo(valor);
    	}
    	
    	if (valor<actual.x){
    		actual.hijoIzq=insertarNodo(actual.hijoIzq,valor);
    	}
    	else if (valor>actual.x){
    		actual.hijoDer=insertarNodo(actual.hijoDer,valor);
    	}
    	return actual;
    }
    public void insertar(int valor){
    	raiz=insertarNodo(raiz,valor);
    }
    
    //buscar elemento
   /* 
    private boolean contieneNodo(Nodo actual, int valor){
    	if (actual==null){
    		return false;
    	}
    	if (valor==actual.x)
    		return true;
    	return valor < actual.x //condicion
    		? contieneNodo(actual.hijoIzq,valor) //true
    		: contieneNodo (actual.hijoDer,valor); //false
    }
    
    public boolean contiene (int valor){
    	return contieneNodo(raiz,valor);
    }
    
    //eliminar nodo
    private int valorMenor(Nodo raiz){
    	return raiz.hijoIzq==null
    			? raiz.x :valorMenor(raiz.hijoIzq);
    }
    private Nodo eliminarNodo (Nodo actual, int valor){
    	
    	if (actual==null)//vacio
    		return null;
    	
    	if (valor==actual.x){//nodo encontrado
    		
    		//nodo sin hijos
    		if ((actual.hijoDer==null)&&(actual.hijoIzq==null))
    		return null;
    		
    		//nodo con un hijo: reemplazar con el hijo
    		if (actual.hijoDer==null)
    			return actual.hijoIzq;
    		if (actual.hijoIzq==null)
    			return actual.hijoDer;
    		
    		//nodo con dos hijos
    		//encontrar nodo que reemplace al eliminado
    		int menor = valorMenor(actual.hijoDer);
    		actual.x = menor;
    		actual.hijoDer=eliminarNodo(actual.hijoDer,menor);
    		return actual;    		
    	}
    	
    	if (valor< actual.x){ //valor menor al nodo
    		actual.hijoIzq=eliminarNodo(actual.hijoIzq,valor);
    	return actual;
    	}
    	//valor mayor al nodo
    	actual.hijoDer=eliminarNodo(actual.hijoDer,valor);
    	return actual;
    }

    public void eliminar (int valor){
    	raiz=eliminarNodo(raiz,valor);
    }
   }
*/