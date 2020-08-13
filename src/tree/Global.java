package tree;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Interfaz.Tablero;
import Interfaz.Victoria;
/**
 * Clase que maneja funciones relacionadas al tablero.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */
public class Global {
	public static boolean log=true;
	public static int id=0;
	public static int id2=0;
	public static Arbol arbol;
	public static JLabel score = new JLabel("0");
	public static JLabel maximoN = new JLabel("0");
	public static int max= 2;
	
	/**
	 * Detecta los clicks en esferas en el tablero.
	 * @param ID = codigo de la esfera.
	 * */
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
	
	/**
	 * Limpia los id.
	 * */
	public static void Flush(){
		id=0;
		id2=0;
		log=true;
	}
	
	/**
	 * Verifica que dos nodos dados estén en diferentes niveles.
	 * @return false si no están en el mismo nivel.
	 * @return true si ambos son hojas o uno es hijo del otro.
	 * */
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
	/**
	 *Verifica que se pueda realizar la suma entre ambos nodos dados.
	 *@return true si difNiveles retorna true, o ambos nodos son primos.
	 *@return false en cualquier otro caso.
	 * */
 	public static Boolean Validando (Nodo n1, Nodo n2){

 		if ((difNiveles(n1,n2))||(n1.getNivel()==n2.getNivel())&& (n1.getValor()==n2.getValor()))
 				return true;
 		else
 				return false;
 		
 	}
 	/**
	 *Realiza la suma entre esferas.
	 * */
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
 	/**
	 *Realiza la suma de puntaje y la muestra en pantalla.
	 *@param valor = valor de la esfera creada.
	 * */
 	private static void sumandoScore(int valor){
 		int puntuacion= Integer.parseInt(score.getText());
 		puntuacion=puntuacion+valor;
 		score.setText(String.valueOf(puntuacion));
 	}
 	/**
	 *Muestra la pantalla de victoria al obtenerse la esfera de 2048.
	 *@param valor = valor de la esfera sumada.
	 * */
 	private static void Victoria(int valor){
 		if (valor>=2048){
 			Victoria frame = new Victoria();
 			frame.setVisible(true);
 		}
 	}
 	/**
	 *Muestra la maxima esfera obtenida en el tablero.
	 *@param valor = valor de la esfera obtenida.
	 * */
 	private static void esferaMax(int valor){
 		int maxima = Integer.parseInt(maximoN.getText());
 		if(valor>maxima){
 		ImageIcon icon = new ImageIcon(Tablero.class.getResource("/Imagenes/esfera"+valor+".png"));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(maximoN.getHeight(), maximoN.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        maximoN.setIcon(newImc);
        maximoN.setText("");}
 		Victoria(valor);
 		
 	}
 	
 	/**
	 *Reinicia el juego.
	 * */
 	public static void Reinicio(){
 		score.setText("0");
 		
 		for(int i=2;i<32;i++){
    		Nodo graf = arbol.Buscar(arbol.getRaiz(), i);
    		graf.Vaciado();
 		}
 	}
 	/**
	 *Retorna el arbol del juego.
	 * */
	public static Arbol getArbol() {
		return arbol;
	}
	/**
	 *Asigna el arbol del juego.
	 * */
	public static void setArbol(Arbol arbol) {
		Global.arbol = arbol;
	}

	/**
	 *Sube de nivel un nodo dado.
	 *@param aux = nodo cuyos hijos van a subir.
	 * */
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
	/**
	 * Establece la condicion de derrota.
	 * @param raiz = raiz del arbol.
	 * */
	public static void Derrota(Nodo raiz){
		//primo1.getvalor!=primo2.getvalor && padre.getvalor!=hijo.getvalor
		if ((raiz.getLeft().getValor()==raiz.getRight().getValor())||(raiz.getValor()==raiz.getLeft().getValor())||(raiz.getValor()==raiz.getRight().getValor())){
			JOptionPane.showMessageDialog(null, "No has perdido :o)");
			return; //no se ha perdido
			
		}
		if(!(arbol.countChildren(raiz)<=30)){
		
			Derrota(raiz.getLeft());
			Derrota(raiz.getRight());
			JOptionPane.showMessageDialog(null, "Perdiste por gafo ;o)");
			Reinicio();}
		
	}
	
	/**
	 *Convierte los valores de los nodos a string,
	 *@param valor = valor del nodo.
	 *@return String correspondiente al valor dado.
	 * */
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
	
	/**
	 *Obtiene la posicion actual de todos los nodos del tablero.
	 *@return movimientos = String que almacena todos los nodos actuales.
	 * */
	public static String estadoTablero(){
		String movimientos="";
		int i;
		Nodo nodo=null;
		for (i=1;i<=31;i++){
			nodo=arbol.Buscar(arbol.getRaiz(), i);
			if (nodo!=null){
				movimientos+=String.valueOf(i)+"-"+nodo.getValor();
			}
			
		}
		return movimientos;
	}
	

}