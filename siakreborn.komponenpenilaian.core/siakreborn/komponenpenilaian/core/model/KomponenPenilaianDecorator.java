package siakreborn.komponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KomponenPenilaianDecorator extends KomponenPenilaianComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KomponenPenilaianComponent record;
		
	public KomponenPenilaianDecorator (KomponenPenilaianComponent record) {
		this.record = record;
	}

	public KomponenPenilaianDecorator (int id, KomponenPenilaianComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KomponenPenilaianDecorator(){
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
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public int getBobot() {
		return record.getBobot();
	}
	public void setBobot(int bobot) {
		record.setBobot(bobot);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
