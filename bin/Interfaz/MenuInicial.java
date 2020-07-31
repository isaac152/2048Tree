package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuInicial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuInicial dialog = new MenuInicial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuInicial() {
		setBounds(100, 100, 349, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[162px][212px]", "[66px][20px][20px][19px][24px]"));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MenuInicial.class.getResource("/Imagenes/esfera2048.png")));
		contentPanel.add(label, "cell 0 0,grow");
		
		JLabel label_1 = new JLabel("");
		contentPanel.add(label_1, "cell 1 0,grow");
		
		JLabel lblNombreDeUsuario = new JLabel("NOMBRE DE USUARIO");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPanel.add(lblNombreDeUsuario, "cell 0 1,grow");
		
		textField_1 = new JTextField();
		contentPanel.add(textField_1, "cell 1 1,grow");
		textField_1.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPanel.add(lblContrasea, "cell 0 2,grow");
		
		textField = new JTextField();
		contentPanel.add(textField, "cell 1 2,grow");
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		contentPanel.add(label_3, "cell 1 3,grow");
		
		JLabel label_4 = new JLabel("");
		contentPanel.add(label_4, "cell 0 4,grow");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
			btnRegistrarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					RegistroUsuario a = new RegistroUsuario();
					a.setVisible(true);
					dispose();
				}
			});
			btnRegistrarUsuario.setActionCommand("OK");
			buttonPane.add(btnRegistrarUsuario);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//busca username y pass y compara
						
							Tablero frame= new Tablero();
							frame.setVisible(true);
							setVisible(false);
							dispose();
				
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
