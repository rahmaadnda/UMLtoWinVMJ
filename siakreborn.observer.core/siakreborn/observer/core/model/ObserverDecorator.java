package siakreborn.observer.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ObserverDecorator extends ObserverComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ObserverComponent record;
		
	public ObserverDecorator (ObserverComponent record) {
		this.record = record;
	}

	public ObserverDecorator (int id, ObserverComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public ObserverDecorator(){
		super();
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}

	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
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
