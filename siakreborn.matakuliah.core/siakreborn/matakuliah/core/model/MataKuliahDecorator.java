package siakreborn.matakuliah.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class MataKuliahDecorator extends MataKuliahComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected MataKuliahComponent record;
		
	public MataKuliahDecorator (MataKuliahComponent record) {
		this.record = record;
	}

	public MataKuliahDecorator (int id, MataKuliahComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public MataKuliahDecorator(){
		super();
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}

	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}
	public String getKode() {
		return record.getKode();
	}
	public void setKode(String kode) {
		record.setKode(kode);
	}
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public int getSks() {
		return record.getSks();
	}
	public void setSks(int sks) {
		record.setSks(sks);
	}
	public int getTerm() {
		return record.getTerm();
	}
	public void setTerm(int term) {
		record.setTerm(term);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
