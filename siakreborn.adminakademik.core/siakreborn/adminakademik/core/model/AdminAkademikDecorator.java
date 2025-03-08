package siakreborn.adminakademik.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AdminAkademikDecorator extends AdminAkademikComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AdminAkademikComponent record;
		
	public AdminAkademikDecorator (AdminAkademikComponent record) {
		this.record = record;
	}

	public AdminAkademikDecorator (int id, AdminAkademikComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public AdminAkademikDecorator(){
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
	public String getEmail() {
		return record.getEmail();
	}
	public void setEmail(String email) {
		record.setEmail(email);
	}
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
