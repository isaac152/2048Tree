package DatosUsuario;

public class NodoUsuario {
	private String nombre;
	private String apellido;
	private String email;
	private String username;
	private String contraseña;
	private NodoUsuario left;
	private NodoUsuario right;
	 
	public NodoUsuario(String nombre,String apellido,String email,String username,String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.username = username;
		this.contraseña = contraseña;
		this.left=null;
		this.right=null;
	}
	public NodoUsuario() {
		
	}
	 
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	 
	public NodoUsuario getLeft() {
		return left;
	}
	 
	public void setLeft(NodoUsuario left) {
		this.left = left;
	}
	 
	public NodoUsuario getRight() {
		return right;
	}
	 
	public void setRight(NodoUsuario right) {
		this.right = right;
	}
	 
	public String toString(){
		return("Node [NOMBRE = "+ nombre + "----   APELLIDO = "+ apellido+ "----   EMAIL = "+ email+ "----   USUARIO = "+ username+ "----   CONTRASEÑA = "+ contraseña+  "]");
	} 
	
}

