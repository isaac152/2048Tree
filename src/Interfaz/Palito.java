package Interfaz;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**Clase que controla la generación de los conectores entre esferas.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G*/

public class Palito {
	GridBagConstraints gbc_label= new GridBagConstraints();
	JLabel label = new JLabel("");
	/**
	 * Constructor de la clase Palito.
	 * @param i = determina la posicion del palito en el tablero.*/
	public Palito(int i){
		
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridy = 0;
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		
		if(i==1){
			label.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/conector1.png")));
		}
		else{
			label.setIcon(new ImageIcon(Tablero.class.getResource("/Imagenes/conector2.png")));			
		}
	}
	
}
