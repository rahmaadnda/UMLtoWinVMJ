package siakreborn.rencanastudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PengisianRencanaStudiDecorator extends PengisianRencanaStudiComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PengisianRencanaStudiComponent record;
		
	public PengisianRencanaStudiDecorator (PengisianRencanaStudiComponent record) {
		this.record = record;
	}

	public PengisianRencanaStudiDecorator (int id, PengisianRencanaStudiComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public PengisianRencanaStudiDecorator(){
		super();
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}

	public DateTime getMulai() {
		return record.getMulai();
	}
	public void setMulai(DateTime mulai) {
		record.setMulai(mulai);
	}
	public DateTime getAkhir() {
		return record.getAkhir();
	}
	public void setAkhir(DateTime akhir) {
		record.setAkhir(akhir);
	}
	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
