package arbolbin;

public class Nodo {
	public int x;
	public Nodo hijoDer;
	public Nodo hijoIzq;
	
	//construct
	
	public Nodo(int x){
		this.x=x;
		hijoIzq=hijoDer=null;
		}
	
	//getsetters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Nodo getHijoDer() {
		return hijoDer;
	}
	public void setHijoDer(Nodo hijoDer) {
		this.hijoDer = hijoDer;
	}
	public Nodo getHijoIzq() {
		return hijoIzq;
	}
	public void setHijoIzq(Nodo hijoIzq) {
		this.hijoIzq = hijoIzq;
	}
	//
	//pre y post orden
	  private void procesarInfo(Nodo a) {
	  	   System.out.println (a.getX());
	  	}

	  
	  public void preOrden(Nodo a) {
	  	if (a != null) {
	  	   procesarInfo(a);
	  	   
	  	   preOrden(a.getHijoIzq());
	  	   preOrden(a.getHijoDer());
	  	   }		
	  	}

	  
	  public void postOrden(Nodo a){
	  	if (a!=null){
	  		preOrden(a.getHijoIzq());
	  		preOrden(a.getHijoDer());
	  		procesarInfo(a);
	  	}
	  }
	  
	  /****/
	  //impresion 2d
	  private void print2DUtil(Nodo root, int space)  
	  {  
	      // caso base 
	      if (root == null)  
	          return;  
	    
	      // Distancia entre niveles
	      space += 8;  
	    
	      // nodo derecho primero
	      print2DUtil(root.hijoDer, space);  
	    
	      // imprime el nodo actual 
	      for (int i = 8; i < space; i++)  
	          System.out.print(" ");  
	      System.out.print(root.x + "\n");  
	    
	      // luego izquierdo
	      print2DUtil(root.hijoIzq, space);  
	  }  

	  public void print2D(Nodo root)  
	  {  
	      // pase inicial 0 
	      print2DUtil(root, 0);  
	  }  
	
}
