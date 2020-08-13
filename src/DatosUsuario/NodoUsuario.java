package DatosUsuario;

/**
 * Clase que establece los nodos del arbol binario que maneja los datos de usuario.
 * @author Daniela E
 * @author Katherine M
 * @author Isaac G
 * */
public class NodoUsuario {
	private String nombre;
	private String apellido;
	private String email;
	private String username;
	private String contrasena;
	private NodoUsuario left;
	private NodoUsuario right;
	 
	/**
	 * Constructor del nodo de datos de usuario.
	 * @param nombre = nombre del usuario
	 * @param apellido = apellido del usuario
	 * @param email = email del usuario
	 * @param username = nombre de usuario del usuario
	 * @param contrasena = contraseña del usuario
	 * */
	public NodoUsuario(String nombre,String apellido,String email,String username,String contrasena) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.username = username;
		this.contrasena = contrasena;
		this.left=null;
		this.right=null;
	}
	/**
	 * Constructor del nodo de datos de usuario.
	 * */
	public NodoUsuario() {
		
	}
	 
	/**
	 * Retorna el nombre del usuario.
	 * @return nombre = nombre del usuario.
	 * */
	public String getNombre() {
		return nombre;
	}
	

	/**
	 * Asigna el nombre del usuario.
	 * @param nombre = nombre del usuario.
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	/**
	 * Retorna el apellido del usuario.
	 * @return apellido = apellido del usuario.
	 * */
	public String getApellido() {
		return apellido;
	}
	

	/**
	 * Asigna el apellido del usuario.
	 * @return apellido = apellido del usuario.
	 * */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Retorna el correo del usuario.
	 * @return email = correo del usuario.
	 * */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Asigna el correo del usuario.
	 * @param email = correo del usuario.
	 * */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Retorna el nombre de usuario del usuario.
	 * @return username = nombre del usuario.
	 * */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Asigna el nombre de usuario del usuario.
	 * @param username = nombre del usuario.
	 * */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Retorna la contraseña del usuario.
	 * @return contrasena = contraseña del usuario.
	 * */
	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * Asigna la contraseña del usuario.
	 * @param contrasena = contraseña del usuario.
	 * */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	 
	/**
	 * Retorna el hijo izquierdo del nodo actual.
	 * @return left = hijo izquierdo.
	 * */
	public NodoUsuario getLeft() {
		return left;
	}
	/**
	 * Asigna el hijo izquierdo del nodo actual.
	 * @param left = hijo izquierdo.
	 * */
	public void setLeft(NodoUsuario left) {
		this.left = left;
	}
	/**
	 * Retorna el hijo derecho del nodo actual.
	 * @return right = hijo derecho.
	 * */
	public NodoUsuario getRight() {
		return right;
	}
	/**
	 * Asigna el hijo derecho del nodo actual.
	 * @param right = hijo derecho.
	 * */ 
	public void setRight(NodoUsuario right) {
		this.right = right;
	}
	 
	/**
	   * Overwrite para imprimir los datos del nodo.
	   * @return datos del nodo en un String.
	   * */
	public String toString(){
		return("Node [NOMBRE = "+ nombre + "----   APELLIDO = "+ apellido+ "----   EMAIL = "+ email+ "----   USUARIO = "+ username+ "----   contrasena = "+ contrasena+  "]");
	} 
	
}

