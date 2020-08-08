package DatosUsuario;

import java.io.*;
import java.util.Scanner;

public class Archivos {

	public Archivos() {
		// TODO Auto-generated constructor stub
	}

	public static void escribirFichero(NodoUsuario nodo) {
		FileWriter flwriter = null;
		try {//adem�s de la ruta del archivo recibe un par�metro de tipo boolean, que le indican que se va a�adir m�s registros 
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
	 * Lee un fichero binario de forma secuencial
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
}
