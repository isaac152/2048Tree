package tree;
public class Arbol {

	private Nodo Raiz;
	private int cont=1;
	private int base=2;
	private int nivel=1;
	
	public Arbol(){
		Raiz = new Nodo();
	}
	public Nodo getRaiz() {
		return Raiz;
	}

	public void setRaiz(Nodo raiz) {
		Raiz = raiz;
	}
	public boolean esHoja(Nodo hoja){
		if ((hoja.getLeft()==null)&&(hoja.getRight()==null))
			return true;
		else
			return false;
	}
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
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	} 
	  
}