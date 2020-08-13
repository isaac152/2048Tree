package tree;
/**
 * Arbol interno del juego.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */

public class Arbol {

	private Nodo Raiz;
	private int cont=1;
	private int base=2;
	private int nivel=1;
	
	/**
	 * Constructor del arbol
	 * */

	public Arbol(){
		Raiz = new Nodo();
	}
	/**
	 * Retorna la raiz del arbol.
	 * @return Raiz = nodo raiz del arbol.
	 * */

	public Nodo getRaiz() {
		return Raiz;
	}

	/**
	 * Asigna la raiz del arbol.
	 * @param raiz = nodo raiz del arbol.
	 * */
	public void setRaiz(Nodo raiz) {
		Raiz = raiz;
	}

	/**
	 * Verifica si el nodo dado es hoja del arbol.
	 * @param hoja = nodo a verificar
	 * @return true si es hoja
	 * @return false si no es hoja
	 * */
	public boolean esHoja(Nodo hoja){
		if ((hoja.getLeft()==null)&&(hoja.getRight()==null))
			return true;
		else
			return false;
	}
	/**
	 * Busca un nodo dada la clave.
	 * @param r = nodo raiz
	 * @param clave = clave a buscar
	 * @return Aux = nodo encontrado
	 * */
	public  Nodo Buscar(Nodo r, int clave){
	    Nodo Aux = null;
		if(r!=null){
	    	if(r.getClave()==clave){
	    		Aux = r;
	    	}
	    	else{
	            Aux = Buscar(r.getRight(),clave);
	            if(Aux==null)
	                Aux = Buscar(r.getLeft(),clave);
	        }
	    	
	    }
	    return Aux;
	}
	
	/**
	 * Obtiene el nivel de un nodo.
	 * @param nodo = nodo a examinar.
	 * */

	public void Nivel(Nodo nodo){
		if(cont<(int)Math.pow(2,base)){
			nodo.setNivel(nivel);
		}
		else
		{
			nivel++;
			base++;
			nodo.setNivel(nivel);
		}
	}

	/**
	 * Inserta nodo en el arbol.
	 * @param nodo = nodo a insertar.
	 * */

	public void insert(Nodo nodo) {
		if(cont<7){
			if(this.getRaiz() == null) {
	            this.setRaiz(nodo);
	            nodo.setClave(0);
	            return;
	        }
	 
	        Nodo t = this.getRaiz();
	        boolean val = true;
	        while((t != null)&&(val)) {
	            if(t.getLeft() == null) {
	            	t.setLeft(nodo);
	            	cont++;
	            	Nivel(nodo);
	            	val=false;
	            }
	            else if(t.getRight() == null) {
	                t.setRight(nodo);
	                cont++;
	            	Nivel(nodo);
	                val=false;
	            }
	            else {
	                int lCount = countChildren(t.getLeft());
	                int rCount = countChildren(t.getRight());
	                if(lCount == rCount)
	                 t = t.getLeft();    
	                
	                else if(lCount == 0 || lCount == 1)
	                    t = t.getLeft();                
	                
	                else
	                 t = t.getRight();
	                
	            }
	
	        }
		}
	}
	/**
	 * Inserta nodo en los subarboles.
	 * @param nodo = nodo a insertar
	 * */

	public void insertSubArbol(Nodo nodo) {
		if(cont<5){
			if(this.getRaiz() == null) {
				this.setRaiz(nodo);
				nodo.setClave(0);
				return;
			}
			
			Nodo t = this.getRaiz();
			boolean val = true;
			while((t != null)&&(val)) {
				if(t.getLeft() == null) {
					t.setLeft(nodo);
					cont++;
					val=false;
				}
				else if(t.getRight() == null) {
					t.setRight(nodo);
					cont++;
					val=false;
				}
				else {
					int lCount = countChildren(t.getLeft());
					int rCount = countChildren(t.getRight());
					if(lCount == rCount)
						t = t.getLeft();    
					
					else if(lCount == 0 || lCount == 1)
						t = t.getLeft();                
					
					else
						t = t.getRight();
					
				}
				
			}
		}
	}
	/**
	 * Cuenta los hijos del arbol.
	 * @param t = nodo a tomar como raiz,
	 * @return count = cantidad de hijos.
	 * */

    public int countChildren(Nodo t) {
        int count = 0;
        if(t == null)
            return 0;
        if(t.getLeft() != null)
            count++;
            count += countChildren(t.getLeft());
        if(t.getRight() != null)
            count++;
            count += countChildren(t.getRight());
        return count;
    }
    /**
	 * Impresion 2D en consola del arbol.
	 * @param raiz = raiz del arbol
	 * @param espacio = espacio entre niveles. 
	 * */

	  public void print2DUtil(Nodo raiz, int espacio)  
	  {  
	      // caso base 
	      if (raiz== null)  
	          return;  
	    
	      // Distancia entre niveles
	      espacio+= 8;  
	    
	      // nodo derecho primero
	      print2DUtil(raiz.getRight(), espacio);  
	    
	      // imprime el nodo actual 
	      for (int i = 8; i < espacio; i++)  
	          System.out.print(" ");  
	      System.out.print(raiz.getClave() + "\n");  
	    
	      // luego izquierdo
	      print2DUtil(raiz.getLeft(), espacio);  
	  }
	  /**
		 * Retorna el contador.
		 * @return cont = contador.
		 * */

	public int getCont() {
		return cont;
	}
	/**
	 * Asigna el contador.
	 * @param cont = contador
	 * */

	public void setCont(int cont) {
		this.cont = cont;
	} 
	  
}