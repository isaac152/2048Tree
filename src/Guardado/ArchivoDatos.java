package Guardado;

import java.io.*;
import java.util.Scanner;

import Interfaz.Tablero;
import tree.Global;
import tree.Nodo;

public class ArchivoDatos {
	
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
	public static void copiaUltimo(String usuario) {
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("src//Guardado//Ts"+usuario+".txt",false);
			BufferedWriter escribir = new BufferedWriter(flwriter);
			File archivo = new File(usuario+".txt");
			Scanner leer = new Scanner(archivo);
			escribir.write(leer.nextLine()); 
			while(leer.hasNext())
			{
				escribir.newLine();
				escribir.write(leer.nextLine());
			}
			escribir.close(); 
			leer.close();
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
	public static boolean archivoVacio(String usuario){
		File newFile = new File(usuario+".txt"); 
		if (newFile.length() == 0) { return true;} 
		else { return false; }

	}
	public static boolean archivoExiste(String usuario){
		File tmpDir = new File("src//Guardado//"+usuario+".txt");
		return tmpDir.exists();
	}
}
