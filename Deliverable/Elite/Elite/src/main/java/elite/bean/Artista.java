package elite.bean;

public class Artista {
	private int id;
	private String nome;
	
	public Artista() {}
	
	
	public Artista(String nome) {
		this.nome = nome;
	}
	
	public Artista(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public boolean isEmpty() {
		return nome.equals("");
	}
}
