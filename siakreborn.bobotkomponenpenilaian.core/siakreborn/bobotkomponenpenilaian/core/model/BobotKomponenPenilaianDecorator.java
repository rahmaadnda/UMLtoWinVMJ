package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BobotKomponenPenilaianDecorator extends BobotKomponenPenilaianComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BobotKomponenPenilaianComponent record;
		
	public BobotKomponenPenilaianDecorator (BobotKomponenPenilaianComponent record) {
		this.record = record;
	}

	public BobotKomponenPenilaianDecorator (int id, BobotKomponenPenilaianComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public BobotKomponenPenilaianDecorator(){
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
