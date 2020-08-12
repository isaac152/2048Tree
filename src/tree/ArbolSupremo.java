package tree;

public class ArbolSupremo {
	private Nodo raiz=null;
	private Arbol arbol=new Arbol();
	private int cont=2;
	private int posx=1;
	
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
    
	public Arbol getArbol() {
		return arbol;
	}
	public void setArbol(Arbol arbol) {
		this.arbol = arbol;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public int getCont() {
		return cont;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
}
