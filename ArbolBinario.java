package arbolbin;

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
}
