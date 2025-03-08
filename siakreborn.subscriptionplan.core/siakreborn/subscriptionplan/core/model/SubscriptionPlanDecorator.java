package siakreborn.subscriptionplan.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class SubscriptionPlanDecorator extends SubscriptionPlanComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected SubscriptionPlanComponent record;
		
	public SubscriptionPlanDecorator (SubscriptionPlanComponent record) {
		this.record = record;
	}

	public SubscriptionPlanDecorator (int id, SubscriptionPlanComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public SubscriptionPlanDecorator(){
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
	public String getDeskripsi() {
		return record.getDeskripsi();
	}
	public void setDeskripsi(String deskripsi) {
		record.setDeskripsi(deskripsi);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}
	public int getHarga() {
		return record.getHarga();
	}
	public void setHarga(int harga) {
		record.setHarga(harga);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
