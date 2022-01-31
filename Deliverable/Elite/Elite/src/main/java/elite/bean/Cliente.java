package elite.bean;

public class Cliente {
	private int id;
	private String nome;
	private String telefono;
	private String email;
	private String password;

	public Cliente() {
	}

	public Cliente(String nome, String telefono, String email, String password) {
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
		this.password=password;
	}
	
	public Cliente(int id, String nome, String telefono, String email, String password) {
		this.id = id;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
		this.password=password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public boolean isEmpty() {
		return email==null;
	}
}
