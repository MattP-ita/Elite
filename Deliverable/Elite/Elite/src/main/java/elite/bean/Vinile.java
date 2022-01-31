package elite.bean;

public class Vinile {
	public String id;
	public String nome;
	public String giri;
	public Artista artista;
	public Genere genere;
	public double prezzo;
	public int quantita;
	private boolean copertina;

	public Vinile() {
	}

	public Vinile(String id, String nome, String giri, int idArtista, int idGenere, double prezzo, int quantita) {
		this.id = id;
		this.nome = nome;
		this.giri = giri;
		setIdArtista(idArtista);
		setIdGenere(idGenere);
		this.prezzo = prezzo;
		this.quantita = quantita;
	}

	public Vinile(String id, String nome, String giri, int idArtista, String nomeA, int idGenere, String nomeG,
			double prezzo, int quantita, boolean copertina) {
		this.id = id;
		this.nome = nome;
		this.giri = giri;
		this.artista = new Artista(idArtista, nomeA);
		this.genere = new Genere(idGenere, nomeG);
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.copertina = copertina;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGiri() {
		return giri;
	}

	public void setGiri(String giri) {
		this.giri = giri;
	}

	public int getIdArtista() {
		return artista.getId();
	}

	public void setIdArtista(int idArtista) {
		artista.setId(idArtista);
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista=artista;
	}

	public int getIdGenere() {
		return genere.getId();
	}

	public void setIdGenere(int idGenere) {
		genere.setId(idGenere);
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public boolean isCopertina() {
		return copertina;
	}

	public void setCopertina(boolean copertina) {
		this.copertina = copertina;
	}
}
