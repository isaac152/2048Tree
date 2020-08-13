package DatosUsuario;

import java.io.*;
import java.util.Scanner;
/**
 * Clase que maneja la lectura y escritura de archivos.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */

public class Archivos {
	/**
	 * Constructor la clase de manejo de archivos.
	 * */
	public Archivos() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Escribe el nodo dado en el fichero de datos de usuario.
	 * @param n = nodo a insertar.
	 * */
	public static void escribirFichero(NodoUsuario nodo) {
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("src//DatosUsuario//dataRegistro.txt",true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(nodo.getNombre() + ",");
			bfwriter.write(nodo.getApellido() + ",");
			bfwriter.write(nodo.getEmail() + ",");
			bfwriter.write(nodo.getUsername() + ",");
			bfwriter.write(nodo.getContrasena() +"\n");
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
	 * Lee un fichero binario de forma secuencial, y agrega los datos obtenidos al arbol binario que maneja los datos de usuario.
	 * @return usuarios = arbol conteniendo los usuarios
	 */
	public static ArbolUsuario leerFichero() {
		
		File file = new File("src//DatosUsuario//dataRegistro.txt");
		ArbolUsuario usuarios = new ArbolUsuario();	
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresi�n regular que valida que antes o despues de una coma (,) exista cualquier cosa			
				delimitar.useDelimiter("\\s*,\\s*");
				NodoUsuario nodo= new NodoUsuario();
				nodo.setNombre(delimitar.next());
				nodo.setApellido(delimitar.next());
				nodo.setEmail(delimitar.next());
				nodo.setUsername(delimitar.next());
				nodo.setContrasena(delimitar.next());
				usuarios.insertarElementoPrimero(nodo);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return usuarios;
		
	}
	
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
