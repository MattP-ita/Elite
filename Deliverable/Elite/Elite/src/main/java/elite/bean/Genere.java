package elite.bean;

public class Genere {
	private int id;
	private String nome;
	
	public Genere() {}
	
	public Genere(String nome) {
		this.nome = nome;
	}
	
	public Genere(int id, String nome) {
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
