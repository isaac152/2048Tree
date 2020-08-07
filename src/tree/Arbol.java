package tree;

import Interfaz.NodoGrafico;

public class Arbol {

	private Nodo Raiz; 
	
	public Arbol(){
		Raiz = null;
	}
	public Nodo getRaiz() {
		return Raiz;
	}

	public void setRaiz(Nodo raiz) {
		Raiz = raiz;
	}
	
	public  Nodo Busqueda(Nodo r, int x,int y){
	    Nodo Aux = null;
		if(r!=null){
	    	if((r.getPosx()==x)&&(r.getPosy()==y)){
	    		Aux = r;
	    	}
	    	else{
	            Aux = Busqueda(r.getRight(),x,y);
	            if(Aux==null)
	                Aux = Busqueda(r.getLeft(),x,y);
	        }
	    	
	    }
	    return Aux;
	}
	

	public void insert(Nodo nodo) {
		if(this.getRaiz() == null) {
            this.setRaiz(nodo);
            return;
        }
 
        Nodo t = this.getRaiz();
        boolean val = true;
        while((t != null)&&(val)) {
            if(t.getLeft() == null) {
            	t.setLeft(nodo);
            	nodo.setPadre(t);
            	val=false;
            }
            else if(t.getRight() == null) {
                t.setRight(nodo);
            	nodo.setPadre(t);
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
	public void insert(NodoGrafico n) {
		Nodo nodo = n.getNodo();
		if(this.getRaiz() == null) {
			this.setRaiz(nodo);
			return;
		}
		
		Nodo t = this.getRaiz();
		boolean val = true;
		while((t != null)&&(val)) {
			if(t.getLeft() == null) {
				t.setLeft(nodo);
				nodo.setPadre(t);
				val=false;
			}
			else if(t.getRight() == null) {
				t.setRight(nodo);
				nodo.setPadre(t);
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
}