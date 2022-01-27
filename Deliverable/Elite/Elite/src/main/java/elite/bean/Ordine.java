package elite.bean;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ordine {
	public String id;
	public int idCliente;
	public Indirizzo indirizzo;
	public Pagamento pagamento;
	public LocalDate data;
	public ArrayList<Vinile> vinili;
	
	public Ordine() {}
	
	public Ordine(String id, int idCliente, Indirizzo indirizzo, Pagamento pagamento, LocalDate data) {
		this.id = id;
		this.idCliente = idCliente;
		this.indirizzo = indirizzo;
		this.pagamento = pagamento;
		this.data = data;
		vinili=new ArrayList<Vinile>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void addVinile(Vinile v) {
		vinili.add(v);
	}
	
	public void getIndirizzoDB(String i) {
		String[] data=i.split(";");
		this.indirizzo=new Indirizzo(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
	}
	
	public void getPagamentoDB(String p) {
		String[] data=p.split(";");
		this.pagamento=new Pagamento(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4], data[5]);
	}
	
}
