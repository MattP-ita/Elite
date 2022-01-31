package elite.bean;

import java.util.ArrayList;

public class Carrello {
	ArrayList<Vinile> items;
	
	public Carrello(){
		items=new ArrayList<Vinile>();
	}
	
	public void addItem(Vinile v) {
		boolean chiave=true;
		if(items.size()>0){
			for(Vinile bean:items) {
				if(bean.getId().equals(v.getId())) {
					bean.setQuantita(bean.getQuantita()+v.getQuantita());
					chiave=false;
					break;
				}
			}
			if(chiave) {
				items.add(v);
			}
		}else if(items.size()==0) {
			items.add(v);
		}		
	}
	
	public void deleteItem(Vinile item) {
		for(Vinile v:items) {
			if(v.getId().equals(item.getId())) {
				items.remove(v);
				break;
			}
		}
	}
	public void setItems(ArrayList<Vinile> items) {
		this.items = items;
	}

	public ArrayList<Vinile> getItems(){
		return items;
	}
	public int getSize() {
		return items.size();
	}
	
	public void deleteItems() {
		items.clear();		
	}
	
	public double calcolaTotale() {
		double somma=0;
		for(Vinile v:items) {
			somma=somma+(v.getPrezzo()*v.getQuantita());
		}
		return somma;
	}
}
