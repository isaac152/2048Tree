package tree;

import java.awt.Image;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Interfaz.Tablero;
import Interfaz.Victoria;
import javax.swing.JOptionPane;

import Guardado.ArchivoDatos;

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
	public static JLabel highScore = new JLabel("0");
	public static JLabel maximoN = new JLabel("2");	
	public static int esfera = 2;
	public static String usuario;
	
	/**
	 * Detecta los clicks en esferas en el tablero.
	 * @param ID = codigo de la esfera.
	 * */
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
 	 		sumandoScore(n2.getValor());
 	 		esferaMax(n2.getValor());
 	 		ArchivoDatos.crearArchivo(usuario);
 	 		if(ArchivoDatos.archivoExiste(usuario)){
 	 			System.out.println(ArchivoDatos.archivoExiste(usuario));
 	 			ArchivoDatos.copiaUltimo(usuario);
 	 			
 	 			
 	 		}
 	 		
 		}
 		Flush();
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
 			String direccion= Nodo.asignarImagen(valor);
 			maximoN.setIcon(new ImageIcon(Tablero.class.getResource(direccion)));
 			maximoN.setText(String.valueOf(valor));
        }
 		Victoria(valor);
 		
 	}
 	/**
	 *Realiza la suma de puntaje y la muestra en pantalla.
	 *@param valor = valor de la esfera creada.
	 * */
 	private static void sumandoScore(int valor){
 		int puntuacion= Integer.parseInt(score.getText());
 		puntuacion=puntuacion+valor;
 		score.setText(String.valueOf(puntuacion));
 		if (record())
 			highScore.setText(String.valueOf(puntuacion));
 		
 	}
 	/**
	 *Reinicia el juego.
	 * */

 	public static void Reinicio(){
 		score.setText("0");
 		arbol.getRaiz().setValor(2);
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
	 * verifica si el puntaje obtenido es mayor al record actual.
	 * @return true si es mayor.
	 * @return false si no lo es.*/
	public static boolean record(){
		int puntuacion = Integer.valueOf(score.getText());
		int maximaP = Integer.valueOf(highScore.getText());
		if(puntuacion>maximaP)
			return true;
		else
			return false;
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
	/**
	 * Verifica la condicion de derrota.
	 * @param raiz = nodo raiz del arbol de juego.*/
	public static void Derrota(Nodo raiz){
		//primo1.getvalor!=primo2.getvalor && padre.getvalor!=hijo.getvalor
		if ((raiz.getLeft().getValor()==raiz.getRight().getValor())||(raiz.getValor()==raiz.getLeft().getValor())||(raiz.getValor()==raiz.getRight().getValor())){
			return; //no se ha perdido
			
		}
		if(!(arbol.countChildren(raiz)<=30)){
		
			Derrota(raiz.getLeft());
			Derrota(raiz.getRight());
			JOptionPane.showMessageDialog(null, "Perdiste :(\nSe reiniciará el juego.");
			Reinicio();}
		
	}
}