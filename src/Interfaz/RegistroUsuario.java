package Interfaz;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
=======
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> b5edfcfeecba69f535aeae498d650e41dc196eda

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
<<<<<<< HEAD
import javax.swing.JOptionPane;
=======
>>>>>>> b5edfcfeecba69f535aeae498d650e41dc196eda
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

<<<<<<< HEAD
import DatosUsuario.*;

import javax.swing.JPasswordField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textUsername;
	private JTextField textEmail;
	private JPasswordField passwordFieldConfirm;
	private JPasswordField passwordField;
	ArbolUsuario l1 =  new ArbolUsuario();
	NodoUsuario n1 = null;
	
	Archivos principal = new Archivos();
=======
public class RegistroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
>>>>>>> b5edfcfeecba69f535aeae498d650e41dc196eda

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
<<<<<<< HEAD
	
	private void verificarTecla(KeyEvent e){
		char caracter = e.getKeyChar();
		if ((!Character.isLetter(caracter))&&(!Character.isSpace(caracter)))
			e.consume();
			//finaliza este evento para que la fuente que lo origino no lo procese de la manera determinada como si no hubiera presionado la tecla
	}
	
	private boolean verificarEmail(String email){
		// Patrón para validar el email
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		if (mather.find() == true) return true;
		else return false;
	}
	
=======

	
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
>>>>>>> b5edfcfeecba69f535aeae498d650e41dc196eda
	/**
	 * Create the dialog.
	 */
	public RegistroUsuario() {
<<<<<<< HEAD
		l1=principal.leerFichero();
		setResizable(false);
		getContentPane().setBackground(new Color(173, 216, 230));
=======
>>>>>>> b5edfcfeecba69f535aeae498d650e41dc196eda
		JLabel lblNewLabel = new JLabel("");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
<<<<<<< HEAD
			JLabel lblRegistroDeUsuario = new JLabel("REGISTRO DE JUGADOR");
			lblRegistroDeUsuario.setForeground(new Color(0, 0, 153));
			lblRegistroDeUsuario.setBackground(new Color(0, 0, 139));
			lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistroDeUsuario.setFont(new Font("Georgia", Font.BOLD, 15));
			lblRegistroDeUsuario.setBounds(10, 11, 414, 14);
			getContentPane().add(lblRegistroDeUsuario);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblApellido.setBounds(84, 80, 51, 14);
			getContentPane().add(lblApellido);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblNombre.setBounds(84, 47, 51, 14);
			getContentPane().add(lblNombre);
			
			JLabel lblUsername = new JLabel("Usuario:");
			lblUsername.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblUsername.setBounds(85, 146, 51, 14);
			getContentPane().add(lblUsername);
			
			JLabel lblEmail = new JLabel("E-mail:");
			lblEmail.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblEmail.setBounds(92, 111, 63, 14);
			getContentPane().add(lblEmail);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblContrasea.setBounds(116, 180, 80, 14);
			getContentPane().add(lblContrasea);
			
			JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a:");
			lblConfirmarContrasea.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblConfirmarContrasea.setBounds(54, 203, 144, 14);
			getContentPane().add(lblConfirmarContrasea);
			
			textNombre = new JTextField();
			textNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					verificarTecla(e);				
				}
			});
			textNombre.setBounds(139, 42, 250, 20);
			getContentPane().add(textNombre);
			textNombre.setColumns(10);
			
			textApellido = new JTextField();
			textApellido.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					verificarTecla(e);				
				}
			});
			textApellido.setColumns(10);
			textApellido.setBounds(139, 75, 250, 20);
			getContentPane().add(textApellido);
			
			textUsername = new JTextField();
			textUsername.setColumns(10);
			textUsername.setBounds(139, 142, 250, 20);
			getContentPane().add(textUsername);
			
			textEmail = new JTextField();
			textEmail.setColumns(10);
			textEmail.setBounds(139, 108, 250, 20);
			getContentPane().add(textEmail);
			
			passwordFieldConfirm = new JPasswordField();
			passwordFieldConfirm.setBounds(195, 201, 194, 20);
			getContentPane().add(passwordFieldConfirm);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(194, 177, 194, 20);
			getContentPane().add(passwordField);
			
			JLabel lblErrorNombre = new JLabel("*Nombre invalido");
			lblErrorNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorNombre.setFont(new Font("Georgia", Font.PLAIN, 11));
			lblErrorNombre.setForeground(new Color(255, 0, 0));
			lblErrorNombre.setBounds(54, 29, 335, 14);
			lblErrorNombre.setVisible(false);
			getContentPane().add(lblErrorNombre);
			
			JLabel lblErrorContraseñas = new JLabel("*Contrase\u00F1as invalidas");
			lblErrorContraseñas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorContraseñas.setFont(new Font("Georgia", Font.PLAIN, 11));
			lblErrorContraseñas.setForeground(Color.RED);
			lblErrorContraseñas.setBounds(54, 152, 334, 38);
			lblErrorContraseñas.setVisible(false);
			getContentPane().add(lblErrorContraseñas);
			
			JLabel lblErrorUser = new JLabel("*User invalido");
			lblErrorUser.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorUser.setFont(new Font("Georgia", Font.PLAIN, 11));
			lblErrorUser.setForeground(Color.RED);
			lblErrorUser.setBounds(54, 128, 335, 14);
			lblErrorUser.setVisible(false);
			getContentPane().add(lblErrorUser);
			
			JLabel lblErrorEmail = new JLabel("*Email invalido");
			lblErrorEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorEmail.setFont(new Font("Georgia", Font.PLAIN, 11));
			lblErrorEmail.setForeground(Color.RED);
			lblErrorEmail.setBounds(54, 94, 335, 14);
			lblErrorEmail.setVisible(false);
			getContentPane().add(lblErrorEmail);
			
			JLabel lblErrorApellido = new JLabel("*Apellido invalido");
			lblErrorApellido.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorApellido.setFont(new Font("Georgia", Font.PLAIN, 11));
			lblErrorApellido.setForeground(Color.RED);
			lblErrorApellido.setBounds(54, 62, 335, 14);
			lblErrorApellido.setVisible(false);
			getContentPane().add(lblErrorApellido);
			
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 444, 44);
			getContentPane().add(buttonPane);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setBounds(243, 9, 89, 23);
				btnRegistrar.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void mouseClicked(MouseEvent e) {
						lblErrorNombre.setVisible(false);
						lblErrorApellido.setVisible(false);
						lblErrorUser.setVisible(false);
						lblErrorEmail.setVisible(false);
						lblErrorContraseñas.setVisible(false);
						boolean error=false;
						if (textNombre.getText().length() < 3){
							lblErrorNombre.setText("Error: nombre NO puede ser menor a 3 caracteres.");
							lblErrorNombre.setVisible(true);
							error=true;
						}
						if (textNombre.getText().isEmpty()){
							lblErrorNombre.setText("Error: nombre NO puede estar en blanco.");
							lblErrorNombre.setVisible(true);
							error=true;
						}
						if (textApellido.getText().length() < 4){
							lblErrorApellido.setText("Error: apellido NO puede ser menor a 4 caracteres.");
							lblErrorApellido.setVisible(true);
							error=true;
						}
						if (textApellido.getText().isEmpty()){
							lblErrorApellido.setText("Error: apellido NO puede estar en blanco.");
							lblErrorApellido.setVisible(true);
							error=true;
						}
						if (textUsername.getText().isEmpty()){
							lblErrorUser.setText("Error: usuario NO puede estar en blanco.");
							lblErrorUser.setVisible(true);
							error=true;
						}
						if (textUsername.getText().length() < 5){
							lblErrorUser.setText("Error: usuario debe contener minimo 5 caracteres.");
							lblErrorUser.setVisible(true);
							error=true;
						}	
						if (!verificarEmail(textEmail.getText())){
							lblErrorEmail.setText("Error: email invalido.");
							lblErrorEmail.setVisible(true);
							error=true;
						}
						if (textEmail.getText().isEmpty()){
							lblErrorEmail.setText("Error: email NO puede estar en blanco.");
							lblErrorEmail.setVisible(true);
							error=true;
						}
						if (passwordField.getText().isEmpty()||passwordFieldConfirm.getText().isEmpty()){
							lblErrorContraseñas.setText("Error: contraseña en blanco.");
							lblErrorContraseñas.setVisible(true);
							error=true;
						}
						if (String.valueOf(passwordField.getText()).equals(String.valueOf(passwordFieldConfirm.getText())));
						else{
							lblErrorContraseñas.setText("Error: contraseñas no coinciden.");
							lblErrorContraseñas.setVisible(true);
							error=true;
							
						}
						if (passwordField.getText().length() < 6 || passwordField.getText().length() > 8){
							lblErrorContraseñas.setText("Error: contraseña debe contener entre 6 y 8 caracteres.");
							lblErrorContraseñas.setVisible(true);
							error=true;
						}	
						//arreglar
						if (!error){
							NodoUsuario n1 = new NodoUsuario(textNombre.getText(),textApellido.getText(),textEmail.getText(),textUsername.getText(),passwordField.getText());							
							NodoUsuario aux = l1.getPrimero();
							boolean flag = false;
							while(aux != null){
								if (textUsername.getText().equals(aux.getUsername())){
									flag=true;
									break;
								}
								aux = aux.getRight(); 
							}
							if (!flag){
								l1.insertarElementoPrimero(n1);
								principal.escribirFichero(n1);
								JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
								setVisible(false); //you can't see me!
								MenuInicial a = new MenuInicial();
								a.setVisible(true);
								dispose(); //Destroy the JFrame object
							}
							else{
								lblErrorUser.setText("Error: usuario ya se encuentra registrado.");
								lblErrorUser.setVisible(true);
								error=true;
							}
														
						}
					}
				});
=======
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
>>>>>>> b5edfcfeecba69f535aeae498d650e41dc196eda
				buttonPane.setLayout(null);
				
				
				lblNewLabel.setBounds(10, 9, 248, 14);
				buttonPane.add(lblNewLabel);
<<<<<<< HEAD
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false); //you can't see me!
						MenuInicial a = new MenuInicial();
						a.setVisible(true);
						dispose(); //Destroy the JFrame object
					}
				});
				btnCancelar.setBounds(345, 9, 89, 23);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}	
		
	}
=======
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
	
	


>>>>>>> b5edfcfeecba69f535aeae498d650e41dc196eda
}
