package elite.bean;

public class Gestore {
	private int id;
	private String nome;
	private String email;
	private String password;
		
	public Gestore() {
	}
	
	public Gestore(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}

	public Gestore(int id, String nome, String email, String password) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
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
		return email.equals("");
	}
}
