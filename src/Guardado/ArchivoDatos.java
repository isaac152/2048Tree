package Guardado;

import java.io.*;
import java.util.Scanner;

import tree.Global;
import tree.Nodo;

public class ArchivoDatos {
	
	public static void crearArchivo(String usuario) {
		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("src//Guardado//"+usuario+".txt",false);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(Global.score.getText());
			bfwriter.newLine();
			bfwriter.write(Global.maximoN.getText());
			for(int i=1;i<32;i++){
				Nodo nodito= Global.arbol.Buscar(Global.arbol.getRaiz(),i);
	    		if (nodito.isOcupado()){
	    			bfwriter.newLine();
	    			bfwriter.write(nodito.getClave()+"-"+nodito.getValor());
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

	public static boolean archivoVacio(){
		File newFile = new File("archivo.txt"); 
		if (newFile.length() == 0) { return true;} //archivo vacio
		else { return false; }//archivo no vacio

	}
	public static boolean archivoExiste(){
		File tmpDir = new File("ubicacion de archivo");
		return tmpDir.exists();
	}
}
