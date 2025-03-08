package siakreborn.penilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PenilaianDecorator extends PenilaianComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PenilaianComponent record;
		
	public PenilaianDecorator (PenilaianComponent record) {
		this.record = record;
	}

	public PenilaianDecorator (int id, PenilaianComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public PenilaianDecorator(){
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
	public int getNilai() {
		return record.getNilai();
	}
	public void setNilai(int nilai) {
		record.setNilai(nilai);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
