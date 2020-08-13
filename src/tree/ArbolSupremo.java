package tree;
/**Clase que maneja el arbol en general y la insercion de nodos
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G*/
public class ArbolSupremo {
	private Nodo raiz=null;
	private Arbol arbol=new Arbol();
	private int cont=2;
	private int posx=1;
	
	/**
	 * Constructor ArbolSupremo
	 * */
	public ArbolSupremo(){
		Arbol arbolito=new Arbol();
		this.raiz=arbolito.getRaiz();
		arbolito=crearArbol(raiz);
		this.raiz.setClave(1);
		this.raiz.setPosx(1);
		this.raiz.setOcupado(true);
		crearSubArbol(raiz.getLeft());      
		crearSubArbol(raiz.getRight());
		crearSubArbol(raiz.getLeft().getLeft());
		crearSubArbol(raiz.getLeft().getRight());
		crearSubArbol(raiz.getRight().getLeft());
		crearSubArbol(raiz.getRight().getRight());
		this.arbol=arbolito;
	}		
	/**Crea el Arbol interno del juego.
	 * @param r =  nodo raiz
	 * @return arbolito = arbol interno*/
	private Arbol crearArbol(Nodo r){
		Arbol arbolito=new Arbol();
		arbolito.setRaiz(r);
		for (int i=0;i<6;i++){
			Nodo nodito = new Nodo();
			nodito.setClave(cont);
			cont++;
			arbolito.insert(nodito);
			nodito.setPosx(Pintar(nodito.getNivel(),nodito));
		}	
		return arbolito;
	}
	/**Crea subarboles
	 * @param r = nodo a tomar como raiz.*/
	private void crearSubArbol(Nodo r){
		Arbol arbolito = new Arbol();
		arbolito.setRaiz(r);
		int nivel= r.getNivel();
		if(cont>=7){
			for (int i=0;i<4;i++){
				Nodo nodito = new Nodo();
				nodito.setClave(cont);
				nodito.setNivel(nivel+2);
				cont++;								
				arbolito.insertSubArbol(nodito);
				nodito.setPosx(Pintar(nodito.getNivel(),nodito));			
				
			}
			
		}
	}
	/**Dibuja las esferas en el tablero dada la posición de un nodo y el nivel.
	 * @param nivel = nivel del nodo
	 * @param n = nodo a dibujar
	 * @return 0*/
    private int  Pintar (int nivel, Nodo n){
   	switch(nivel){
   	case 1:
   		if (n.getClave()==2)
   			return 1;
   		else
   			return 3;
   	case 2:
   		 if(n.getClave()==4)
   		 {
   			 return posx;
   	}
   		else
   		 {
   			 posx=posx+2;
   			 return posx;
   		 }
   	case 3:
   		if(n.getClave()==8)
   		{
   	   		this.posx=1;
   			return posx;
   		}
   		else
   		{
   			posx=posx+2;
   			return posx;
   		}
   	case 4:
   		if(n.getClave()==16)
   		{
   	   		this.posx=1;
   			return posx;
   		}
   		else
   		{
   			posx=posx+1;
   			return posx;
   		}
   	}
   	return 0;
   }
    /**
	 * Retorna el arbol interno.
	 * @return arbol = arbol interno del juego
	 * */
	public Arbol getArbol() {
		return arbol;
	}
	/**
	 * Asigna el arbol interno.
	 * @param arbol = arbol interno del juego
	 * */
	public void setArbol(Arbol arbol) {
		this.arbol = arbol;
	}

	/**
	 * Retorna la raiz del arbol.
	 * @return raiz = nodo raiz del arbol.
	 * */
	public Nodo getRaiz() {
		return raiz;
	}

	/**
	 * Retorna el contador.
	 * @return cont = contador.
	 * */
	public int getCont() {
		return cont;
	}

	/**
	 * Asigna la raiz del arbol.
	 * @param raiz = nodo raiz del arbol.
	 * */
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	/**
	 * Asigna el contador.
	 * @param cont = contador.
	 * */
	public void setCont(int cont) {
		this.cont = cont;
	}
	
}
