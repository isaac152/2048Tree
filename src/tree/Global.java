package tree;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaz.Tablero;
import Interfaz.Victoria;
import javax.swing.JOptionPane;

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
			System.out.println("ID1-"+id);
		}
		else
			id2=ID;
		System.out.println("ID2-"+id2);
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
 	 		sumandoScore(n2.getValor());
 	 		esferaMax(n2.getValor());
 		}
 		Flush();
 	}
	private static void Victoria(int valor){
 		if (valor>=2048){
 			Victoria frame = new Victoria();
 			frame.setVisible(true);
 		}
 	}
 	private static void esferaMax(int valor){
 		int maxima = Integer.parseInt(maximoN.getText());
 		
 		if(valor>maxima){
 			String direccion= Nodo.asignarImagen(valor);
 			maximoN.setIcon(new ImageIcon(Tablero.class.getResource(direccion)));
        }
 		Victoria(valor);
 		
 	}
 	private static void sumandoScore(int valor){
 		int puntuacion= Integer.parseInt(score.getText());
 		puntuacion=puntuacion+valor;
 		score.setText(String.valueOf(puntuacion));
 	}
 	public static void Reinicio(){
 		score.setText("0");
 		arbol.getRaiz().setValor(2);
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
				aux = aux.getLeft();
				aux.Vaciado();
			} 
			else if(aux.getRight().isOcupado())
			{
				aux.setValor(aux.getRight().getValor());
				aux = aux.getRight();
				aux.Vaciado();
			} 
			else 
				break;
			
		}
	}
}