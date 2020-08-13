package Interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DatosUsuario.*;

import javax.swing.JPasswordField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**Clase que maneja la interfaz de registro de usuarios.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G*/
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
	/**
	 * Evita que se marquen ciertos caracteres.
	 * @param e = tecla presionada
	 * */
	@SuppressWarnings("deprecation")
	private void verificarTecla(KeyEvent e){
		char caracter = e.getKeyChar();
		if ((!Character.isLetter(caracter))&&(!Character.isSpace(caracter)))
			e.consume();
			//finaliza este evento para que la fuente que lo origino no lo procese de la manera determinada como si no hubiera presionado la tecla
	}
	
	/**
	 * Verifica que se haya insertado un email válido.
	 * @param email = email introducido
	 * */
	private boolean verificarEmail(String email){
		// Patron para validar el email
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		if (mather.find() == true) return true;
		else return false;
	}
	
	/**
	 * Create the dialog.
	 */
	public RegistroUsuario() {
		l1=principal.leerFichero();
		setResizable(false);
		getContentPane().setBackground(new Color(173, 216, 230));
		JLabel lblNewLabel = new JLabel("");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JLabel lblRegistroDeUsuario = new JLabel("REGISTRO DE JUGADOR");
			lblRegistroDeUsuario.setForeground(new Color(0, 0, 153));
			lblRegistroDeUsuario.setBackground(new Color(0, 0, 139));
			lblRegistroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistroDeUsuario.setFont(new Font("Georgia", Font.BOLD, 15));
			lblRegistroDeUsuario.setBounds(10, 11, 414, 14);
			getContentPane().add(lblRegistroDeUsuario);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblApellido.setBounds(30, 80, 105, 14);
			getContentPane().add(lblApellido);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblNombre.setBounds(30, 47, 105, 14);
			getContentPane().add(lblNombre);
			
			JLabel lblUsername = new JLabel("Usuario:");
			lblUsername.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblUsername.setBounds(30, 146, 106, 14);
			getContentPane().add(lblUsername);
			
			JLabel lblEmail = new JLabel("E-mail:");
			lblEmail.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblEmail.setBounds(30, 111, 125, 23);
			getContentPane().add(lblEmail);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblContrasea.setBounds(30, 180, 166, 11);
			getContentPane().add(lblContrasea);
			
			JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a:");
			lblConfirmarContrasea.setFont(new Font("Georgia", Font.PLAIN, 12));
			lblConfirmarContrasea.setBounds(30, 203, 168, 14);
			getContentPane().add(lblConfirmarContrasea);
			
			textNombre = new JTextField();
			textNombre.addKeyListener(new KeyAdapter() {
				@Override
				/**
				 * Verifica que la tecla presionada sea aceptable.
				 * @param e = tecla presionada
				 * */
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
				/**
				 * Verifica que la tecla presionada sea aceptable.
				 * @param e = tecla presionada
				 * */
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
			
			JLabel lblErrorContrasenas = new JLabel("*Contrase\u00F1as invalidas");
			lblErrorContrasenas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblErrorContrasenas.setFont(new Font("Georgia", Font.PLAIN, 11));
			lblErrorContrasenas.setForeground(Color.RED);
			lblErrorContrasenas.setBounds(54, 152, 334, 38);
			lblErrorContrasenas.setVisible(false);
			getContentPane().add(lblErrorContrasenas);
			
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
				btnRegistrar.setBounds(136, 9, 156, 23);
				btnRegistrar.addMouseListener(new MouseAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					/**
					 * Realiza el registro de usuario y la verificación de todos los datos.
					 * @param e = click
					 * */
					public void mouseClicked(MouseEvent e) {
						lblErrorNombre.setVisible(false);
						lblErrorApellido.setVisible(false);
						lblErrorUser.setVisible(false);
						lblErrorEmail.setVisible(false);
						lblErrorContrasenas.setVisible(false);
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
							lblErrorContrasenas.setText("Error: contraseña en blanco.");
							lblErrorContrasenas.setVisible(true);
							error=true;
						}
						if (String.valueOf(passwordField.getText()).equals(String.valueOf(passwordFieldConfirm.getText())));
						else{
							lblErrorContrasenas.setText("Error: Contrasenas no coinciden.");
							lblErrorContrasenas.setVisible(true);
							error=true;
							
						}
						if (passwordField.getText().length() < 6 || passwordField.getText().length() > 8){
							lblErrorContrasenas.setText("Error: contraseña debe contener entre 6 y 8 caracteres.");
							lblErrorContrasenas.setVisible(true);
							error=true;
						}	
						//arreglar
						if (!error){
							NodoUsuario n1 = new NodoUsuario(textNombre.getText(),textApellido.getText(),textEmail.getText(),textUsername.getText(),passwordField.getText());							
							NodoUsuario aux = l1.getPrimero();
							//check username
							boolean flag1 = false, flag2=false;
							
							while(aux != null){
								if (textUsername.getText().equals(aux.getUsername())){
									flag1=true;
									break;
								}
								aux = aux.getRight(); 
							}
							//check email
							aux = l1.getPrimero();
							while(aux != null){
								if (textEmail.getText().equals(aux.getEmail())){
									flag2=true;
									break;
								}
								aux = aux.getRight(); 
							}
							if ((!flag1)&&(!flag2)){
								l1.insertarElementoPrimero(n1);
								principal.escribirFichero(n1);
								JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
								setVisible(false); //you can't see me!
								MenuInicial a = new MenuInicial();
								a.setVisible(true);
								dispose(); //Destroy the JFrame object
							}
							else{
								if (flag1==true)
									{lblErrorUser.setText("Error: usuario ya se encuentra registrado.");
									lblErrorUser.setVisible(true);
									error=true;}
								if (flag2==true){
									lblErrorEmail.setText("Error: email ya se encuentra registrado.");
									lblErrorEmail.setVisible(true);
									error=true;
								}
							}
														
						}
					}
				});
				buttonPane.setLayout(null);
				
				
				lblNewLabel.setBounds(10, 9, 248, 14);
				buttonPane.add(lblNewLabel);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					/**
					 * Cierra la ventana y regresa al menu de inicio.
					 * @param e = click
					 * */
					public void mouseClicked(MouseEvent e) {
						setVisible(false); //you can't see me!
						MenuInicial a = new MenuInicial();
						a.setVisible(true);
						dispose(); //Destroy the JFrame object
					}
				});
				btnCancelar.setBounds(304, 9, 130, 23);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}	
		
	}
}