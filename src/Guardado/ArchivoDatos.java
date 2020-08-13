package Guardado;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import Interfaz.Tablero;
import tree.Global;
import tree.Nodo;
/**Clase que maneja el guardado de datos de partida.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G*/
public class ArchivoDatos {
	/**
	 * Crea el archivo de partida de cada usuario.
	 * @param usuario = nombre de usuario
	 * @throws FileNotFoundException */
	public static void crearArchivo(String usuario) {
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("src//Guardado//"+usuario+".txt",false);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			if (Global.record())
				bfwriter.write(Global.score.getText());
			else
				bfwriter.write(Global.highScore.getText());
			bfwriter.newLine();
			bfwriter.write(Global.maximoN.getText());
			for(int i=1;i<32;i++){
				Nodo nodito= Global.arbol.Buscar(Global.arbol.getRaiz(),i);
	    		if (nodito.isOcupado()){
	    			bfwriter.newLine();
	    			bfwriter.write(String.valueOf(nodito.getClave()));
	    			bfwriter.newLine();
	    			bfwriter.write(String.valueOf(nodito.getValor()));
	    		}
			}
			bfwriter.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * Lee el archivo de usuario y obtiene las variables para el juego.
	 * @param usuario = nombre de usuario
	 * @param log = verifica si se esta deshaciendo el movimiento*/
		public static void leerFichero(String usuario,boolean log) {
		File file =null;
		if (log){
			file = new File("src//Guardado//"+usuario+".txt");			
		}
		else
		{
			file = new File("src//Guardado//T"+usuario+".txt");						
		}
		Scanner scanner;
		try {
			System.out.println(usuario);
			scanner = new Scanner(file);
			String linea = scanner.nextLine();
			Global.highScore.setText(linea);
			Global.score.setText(linea);
			linea =scanner.nextLine();
			Global.maximoN.setText(linea);
			Global.esfera=Integer.parseInt(linea);
			while (scanner.hasNextLine()) {
				linea =scanner.nextLine();
				Nodo nodito = Global.arbol.Buscar(Global.arbol.getRaiz(),Integer.valueOf(linea));
				linea =scanner.nextLine();
				nodito.setValor(Integer.valueOf(linea));
	    		nodito.gbc_graf.gridx=nodito.getPosx();
	    		Tablero.Pintarcontenedor(nodito.getNivel(),nodito);
	   			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		
		
	}
		/**Copia el ultimo movimiento realizado en un archivo nuevo.
		 * @param usuario = nombre de usuario
		 * @throws FileNotFoundException */
		public static void copiaArchivo(String usuario){		    
	    	//crea el archivo
	    	FileWriter flwriter = null;
	    	try {
				flwriter = new FileWriter("src//Guardado//T"+usuario+".txt",false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	try {
				flwriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	//copia el archivo
	    	Path pcopia = FileSystems.getDefault().getPath("src//Guardado//T"+usuario+".txt");
	    	Path pfuente = FileSystems.getDefault().getPath("src//Guardado//"+usuario+".txt");
	    	try {
				Files.copy(pfuente, pcopia, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
	/**Verifica si el archivo esta vacio.
	 * @param usuario = nombre de usuario
	 * @return true si es vacio
	 * @return false si no lo es*/
	public static boolean archivoVacio(String usuario){
		File newFile = new File(usuario+".txt"); 
		if (newFile.length() == 0) { return true;} 
		else { return false; }

	}
	/**Verifica si el archivo existe.
	 * @param usuario = nombre de usuario
	 * @return true si existe
	 * @return false si no existe*/
	public static boolean archivoExiste(String usuario){
		File tmpDir = new File("src//Guardado//"+usuario+".txt");
		return tmpDir.exists();
	}
	
	/**Copia el archivo dado en el archivo T(username)
	 * @param fuente = archivo a copiar
	 * @param usuario = nombre de usuario*/
	public static void copiaArchivo(File fuente, String usuario) throws IOException {
		    InputStream is = null;
		    OutputStream os = null;
		    try {
		    	File copia = new File("src//Guardado//T"+usuario+".txt");
		        is = new FileInputStream(fuente);
		        os = new FileOutputStream(copia);
		        byte[] buffer = new byte[1024];
		        int length;
		        while ((length = is.read(buffer)) > 0) {
		            os.write(buffer, 0, length);
		        }
		    } finally {
		        is.close();
		        os.close();
		    }
		
		}
	
}
