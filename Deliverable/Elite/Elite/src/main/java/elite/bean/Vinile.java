package elite.bean;

public class Vinile {
	public String id;
	public String nome;
	public String giri;
	public int idArtista;
	public String artista;
	public int idGenere;
	public String genere;
	public double prezzo;
	public int quantita;
	private boolean copertina;

	public Vinile() {
	}

	public Vinile(String id, String nome, String giri, int idArtista, int idGenere, double prezzo, int quantita) {
		this.id = id;
		this.nome = nome;
		this.giri = giri;
		this.idArtista = idArtista;
		this.idGenere = idGenere;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}

	public Vinile(String id, String nome, String giri, int idArtista, String artista, int idGenere, String genere,
			double prezzo, int quantita, boolean copertina) {
		this.id = id;
		this.nome = nome;
		this.giri = giri;
		this.idArtista = idArtista;
		this.artista = artista;
		this.idGenere = idGenere;
		this.genere = genere;
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
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getIdGenere() {
		return idGenere;
	}

	public void setIdGenere(int idGenere) {
		this.idGenere = idGenere;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
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
