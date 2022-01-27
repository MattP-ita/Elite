package elite.bean;

public class Indirizzo {
	private int id;
	private int idCliente;
	private String nome;
	private String telefono;
	private String indirizzo;
	private String regione;
	private String provincia;
	private String citta;
	private String cap;
	private String descrizione;
	
	public Indirizzo() {}
	
	public Indirizzo(int idCliente, String nome, String telefono, String indirizzo, String regione,
			String provincia, String citta, String cap, String descrizione) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.regione = regione;
		this.provincia = provincia;
		this.citta = citta;
		this.cap = cap;
		this.descrizione = descrizione;
	}
	
	public Indirizzo(int id, int idCliente, String nome, String telefono, String indirizzo, String regione,
			String provincia, String citta, String cap, String descrizione) {
		this.id = id;
		this.idCliente = idCliente;
		this.nome = nome;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.regione = regione;
		this.provincia = provincia;
		this.citta = citta;
		this.cap = cap;
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizo) {
		this.indirizzo = indirizo;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String toString() {
		return idCliente+";"+nome+";"+telefono+";"+indirizzo+";"+regione+";"+provincia+";"+citta+";"+cap+";"+descrizione+";";
	}
}
