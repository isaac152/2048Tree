package Interfaz;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class Contenedor {
	GridBagLayout gbl_panel = new GridBagLayout();	
	JPanel panel = new JPanel();
	
	public Contenedor(){		
		panel.setBackground(new Color(245, 222, 179));
		gbl_panel.rowHeights = new int[]{16, 0};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		panel.setOpaque(false);
	}

}