package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RegistroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroUsuario dialog = new RegistroUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public int toInt(String a){
		int b;
		try {
		   b = Integer.parseInt(a);
		}
		catch (NumberFormatException e)
		{
		   b = 0;
		}
		return b;
	}
	/**
	 * Create the dialog.
	 */
	public RegistroUsuario() {
		JLabel lblNewLabel = new JLabel("");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(265, 5, 70, 23);
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int contrasena=toInt(textField_4.getText()), contracheck=toInt(textField_5.getText());
						//verificar que todas las condiciones se cumplan:
						if (contrasena!=contracheck){
							lblNewLabel.setText("Las contraseñas no coinciden.");
							return;
						
					}
						//...
						//despues de todos los checks
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
				}});
				buttonPane.setLayout(null);
				
				
				lblNewLabel.setBounds(10, 9, 248, 14);
				buttonPane.add(lblNewLabel);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
					}
				});
				cancelButton.setBounds(340, 5, 89, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblRegistroDeUsuario = new JLabel("REGISTRO DE USUARIO");
		lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblRegistroDeUsuario.setBounds(10, 11, 414, 14);
		getContentPane().add(lblRegistroDeUsuario);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblApellido.setBounds(44, 76, 46, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNombre.setBounds(44, 51, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblUsername.setBounds(44, 101, 63, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEmail.setBounds(44, 126, 63, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblContrasea.setBounds(44, 151, 63, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblConfirmarContrasea.setBounds(44, 176, 110, 14);
		getContentPane().add(lblConfirmarContrasea);
		
		textField = new JTextField();
		textField.setBounds(100, 48, 296, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 73, 296, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 98, 296, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 123, 296, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 148, 286, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(152, 173, 244, 20);
		getContentPane().add(textField_5);

		
		
		
	}
	
}