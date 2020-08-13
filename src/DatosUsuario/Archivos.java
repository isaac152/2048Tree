package DatosUsuario;

import java.io.*;
import java.util.Scanner;

import arbolScores.ArbolScores;
import arbolScores.NodoScores;
import tree.Global;
public class Archivos {

	public Archivos() {
		// TODO Auto-generated constructor stub
	}

	public static void escribirFichero(NodoUsuario nodo) {
		FileWriter flwriter = null;
		try {//ademï¿½s de la ruta del archivo recibe un parï¿½metro de tipo boolean, que le indican que se va aï¿½adir mï¿½s registros 
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
				//se usa una expresiï¿½n regular que valida que antes o despues de una coma (,) exista cualquier cosa			
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
	
	
	public static void escribirFicheroScore(NodoScores nodo, String username) {
		FileWriter flwriter = null;
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter("src//arbolScores//"+username+".txt",false);//false para poder sobreescribir
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(nodo.getUsername()+ ",");
			bfwriter.write(nodo.getMov1() + ",");
			bfwriter.write(nodo.getMov2() + ",");
			bfwriter.write(nodo.getHiscore() + ",");
			bfwriter.write(nodo.getSumamax() +"\n");
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
	 * 
	 * */
	public static void crearArchivo(String username){
	File file = new File("src//arbolScores//"+ username+ ".txt");
	
	try   
	{  
	file.createNewFile();  //creates a new file  
	} 
	catch (IOException e)   
	{  
	e.printStackTrace();    //prints exception if any  
	}   }  
	
	
	/**
	 * Lee un fichero binario de forma secuencial
	 */
	public static ArbolScores leerFicheroScore(String username) {
		
		File file = new File("src//arbolScores//"+ username+ ".txt");
		 
		
		ArbolScores scores = new ArbolScores();	
		Scanner scanner;
		try {
			//se pasa el flujo al objeto scanner
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				//se usa una expresión regular que valida que antes o despues de una coma (,) exista cualquier cosa			
				delimitar.useDelimiter("\\s*\n\\s*");
				NodoScores nodo= new NodoScores();
				nodo.setUsername(delimitar.next());
				nodo.setMov1(delimitar.next());
				nodo.setMov2(delimitar.next());
				nodo.setHiscore(Integer.valueOf(delimitar.next()));
				nodo.setSumamax(Integer.valueOf(delimitar.next()));
				scores.insertarElementoPrimero(nodo);
				delimitar.close();
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return scores;
		
	}
	
	/**
	 * Escribe en un fichero los dos ultimos movimientos para sobreescribirlos en dataScores.txt
	 */
	
	public static void escribirFicheroActual(NodoScores nodo,String username) {
		FileWriter flwriter = null;
		try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
			flwriter = new FileWriter("src//arbolScores//"+username+".txt",false);//false permite sobreescribir la linea
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(nodo.getUsername()+ "\n");
			bfwriter.write(nodo.getMov1() + "\n");
			bfwriter.write(nodo.getMov2() + "\n");
			bfwriter.write(nodo.getHiscore() + "\n");
			bfwriter.write(nodo.getSumamax() +"\n");
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
	 * Sobreescribe la linea cada movimiento
	 * */
	// read file one line at a time
	// replace line as you read the file and store updated lines in StringBuffer
	// overwrite the file with the new lines
	public static void replaceLines(String linea, String reemplazar, String username) {
	    try {
	        // input the (modified) file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader("src//arbolScores//"+username+".txt"));
	        StringBuffer inputBuffer = new StringBuffer();

	        while ((reemplazar = file.readLine()) != null) {
	            reemplazar = linea; // replace the line here
	            inputBuffer.append(reemplazar);
	            inputBuffer.append('\n');
	        }
	        file.close();

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("src//arbolScores//"+username+".txt");
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Error leyendo el archivo.");
	    }
	}
	
	public static void sobreescribir(NodoScores nodo, boolean reinicio,String username){
		ArbolScores arbol=leerFicheroScore(username);
		boolean flag = false;
		NodoScores aux = arbol.getPrimero();
		String linea="", linea2=username+"\n"+"1-2\n"+Global.score.getText()+"\n"+Global.maximoN.getText()+"\n";
		while(aux != null){
			if (username.equals(aux.getUsername())){
					//linea=nodo.getUsername()+"\n"+"1-2"+"\n"+nodo.getHiscore()+"\n"+nodo.getSumamax()+"\n";
					linea="";
					flag=true;
					break;
				
			}
			aux = aux.getRight(); 
		}
		
		if (flag){
			if (!reinicio){
				//linea2=nodo.getUsername()+","+Global.estadoTablero()+","+nodo.getMov1()+","+Global.score.getText()+","+Global.maximoN+"\n";
				linea2="hola";
			}
			replaceLines(linea2,linea,username);
		}
	}
	

	
	
}
