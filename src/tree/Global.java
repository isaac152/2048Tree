package tree;

import javax.swing.JLabel;

public class Global {
	public static boolean log=true;
	public static int id=0;
	public static int id2=0;
	public static Arbol arbol;
	public static JLabel score = new JLabel("0");
	public static JLabel maximoN = new JLabel("0");
	public static int max= 2;
	
	public static void Click (int ID){
		if(log){
			id=ID;
			log=false;	
			System.out.println("Click 1-"+id);
		}
		else
			id2=ID;

		System.out.println("Click 2-"+id2);
	}	
	public static void Flush(){
		id=0;
		id2=0;
		log=true;
	}
	public static Boolean difNiveles(Nodo n1, Nodo n2){
		if(arbol.esHoja(n1)&&(arbol.esHoja(n2)))
			return true;
		else{
			if((n2.getLeft().getClave()==n1.getClave()) || (n2.getRight().getClave()==n1.getClave()))
				return true;
			else
				return false;
		}
	}
 	public static Boolean Validando (Nodo n1, Nodo n2){

 		if ((difNiveles(n1,n2))||(n1.getNivel()==n2.getNivel())&& (n1.getValor()==n2.getValor()))
 				return true;
 		else
 				return false;
 		
 	}
 	public static void Sumar(){
 		Nodo n1=arbol.Buscar(arbol.getRaiz(),Global.id);
 		Nodo n2=arbol.Buscar(arbol.getRaiz(),Global.id2);

 		if ((Validando(n1,n2))&&(n1!=n2)){
 			
 			n2.cambiar(n2.getValor()*2);
 			n1.Vaciado();
 			Promocion(n1);
 		}
 		sumandoScore(n2.getValor());
 		esferaMax(n2.getValor());
 		Flush();
 	}
 	private static void sumandoScore(int valor){
 		int puntuacion= Integer.parseInt(score.getText());
 		puntuacion=puntuacion+valor;
 		score.setText(String.valueOf(puntuacion));
 	}
 	private static void esferaMax(int valor){
 		int maxima = Integer.parseInt(maximoN.getText());
 		if(valor>maxima)
 			maximoN.setText(String.valueOf(valor));
 	}
 	public static void Reinicio(){
 		score.setText("0");
 		for(int i=2;i<32;i++){
    		Nodo graf = arbol.Buscar(arbol.getRaiz(), i);
    		graf.Vaciado();
 		}
 	}
	public static Arbol getArbol() {
		return arbol;
	}
	public static void setArbol(Arbol arbol) {
		Global.arbol = arbol;
	}

	public static void Promocion(Nodo aux)
	{
		while (aux.getLeft()!= null)
		{
			if(aux.getLeft().isOcupado())
			{
				aux.setValor(aux.getLeft().getValor());
				aux.getLeft().Vaciado();
				aux = aux.getLeft();
			} 
			else if(aux.getRight().isOcupado())
			{
				aux.setValor(aux.getRight().getValor());
				aux.getRight().Vaciado();
				aux = aux.getRight();
			} 
			else return;
		}
	}
	
	public static String conversorEstado(int valor){
		switch(valor){
		case 0: return "00"; 
		case 2: return "01"; 
		case 4: return "02";
		case 8: return "03"; 
		case 16: return "04"; 
		case 32: return "05";
		case 64: return "06"; 
		case 128: return "07"; 
		case 256: return "08";
		case 512: return "09"; 
		case 1024: return "10";
		case 2048: return "11"; 
		default: return "00";
		}
	}
	
	public static String estadoTablero(){
		String movimiento="";
		for (int i=0;i<=30;i++){
			arbol.Buscar(arbol.getRaiz(), i).getValor();
			movimiento+=conversorEstado(arbol.Buscar(arbol.getRaiz(), i).getValor());
		}
		return movimiento;
	}
	

}