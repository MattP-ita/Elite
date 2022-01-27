package elite.bean;

public class Pagamento {
	private int id;
	private String tipo;
	private int idCliente;
	private String nome;
	private String numero;
	private String scadenza;
	private String codice;
	private int valido;

	public Pagamento() {
	}

	public Pagamento(String tipo, int idCliente, String nome, String numero, String scadenza, String codice) {
		this.tipo=tipo;
		this.idCliente = idCliente;
		this.nome = nome;
		this.numero = numero;
		this.scadenza = scadenza;
		this.codice = codice;
	}
	
	public Pagamento(int id, String tipo, int idCliente, String nome, String numero, String scadenza, String codice, int valido) {
		this.id = id;
		this.tipo=tipo;
		this.idCliente = idCliente;
		this.nome = nome;
		this.numero = numero;
		this.scadenza = scadenza;
		this.codice = codice;
		this.valido = valido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}	
	
	public int getValido() {
		return valido;
	}

	public void setValido(int valido) {
		this.valido = valido;
	}

	public boolean isValid() {
		if(valido==0) return false;
		
		return true;
	}
	
	public String toString() {
		return tipo+";"+idCliente+";"+nome+";"+numero+";"+scadenza+";"+codice+";";
	}
	
}
