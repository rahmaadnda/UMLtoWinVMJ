package siakreborn.dosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class DosenDecorator extends DosenComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected DosenComponent record;
		
	public DosenDecorator (DosenComponent record) {
		this.record = record;
	}

	public DosenDecorator (int id, DosenComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public DosenDecorator(){
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
	public String getNip() {
		return record.getNip();
	}
	public void setNip(String nip) {
		record.setNip(nip);
	}
	public String getEmail() {
		return record.getEmail();
	}
	public void setEmail(String email) {
		record.setEmail(email);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
