package elite.bean;

import elite.utils.Validator;

public class Pagamento {
	private int id;
	private String tipo;
	private int idCliente;
	private String nome;
	private String numero;
	private String scadenza;
	private int valido;

	public Pagamento() {
	}

	public Pagamento(String tipo, int idCliente, String nome, String numero, String scadenza) {
		this.tipo = tipo;
		this.idCliente = idCliente;
		this.nome = nome;
		this.numero = numero;
		this.scadenza = scadenza;
	}

	public Pagamento(int id, String tipo, int idCliente, String nome, String numero, String scadenza, int valido) {
		this.id = id;
		this.tipo = tipo;
		this.idCliente = idCliente;
		this.nome = nome;
		this.numero = numero;
		this.scadenza = scadenza;
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

	public int getValido() {
		return valido;
	}

	public void setValido(int valido) {
		this.valido = valido;
	}

	public boolean isValid() {
		return valido == 1;
	}

	public void checkPagamento() {
		if (checkTipo() && checkNumber() && checkScadenza())
			valido = 1;
		else
			valido = 0;
	}

	public boolean checkTipo() {
		if (tipo.equals("American Express") && numero.substring(0, 1).equals("3"))
			return true;
		else if (tipo.equals("VISA") && numero.substring(0, 1).equals("4"))
			return true;
		else if (tipo.equals("MasterCard") && numero.substring(0, 1).equals("5"))
			return true;
		else
			return false;
	}

	public boolean checkNumber() {
		int x = 0;
		int somma = 0;
		int n = 0;
		for (int i = numero.length() - 1; i >= 0; i--) {
			if (i == numero.length() - 1)
				x = Integer.parseInt(numero.substring(i));
			else
				n = Integer.parseInt(numero.substring(i, i + 1));
			if (i % 2 == 0) {
				n = n * 2;
				if (n >= 10) {
					int m = n / 10;
					int r = n % 10;
					n = m + r;
				}
			}
			somma = somma + n;
		}

		int molt = somma * 9;
		int y = molt % 10;
		return x == y && (somma + x) % 10 == 0;
	}

	public boolean checkScadenza() {
		Validator val = new Validator();
		String mese = scadenza.substring(0, 2);
		String anno = scadenza.substring(2);
		System.out.println(val.valida(mese, "meseP") + " --- " + val.valida(anno, "annoP"));
		return val.valida(mese, "meseP") && val.valida(anno, "annoP");
	}

	public String toString() {
		return tipo + ";" + idCliente + ";" + nome + ";" + numero + ";" + scadenza + ";";
	}

}
