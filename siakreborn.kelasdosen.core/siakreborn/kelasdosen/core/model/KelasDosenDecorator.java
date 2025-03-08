package siakreborn.kelasdosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KelasDosenDecorator extends KelasDosenComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KelasDosenComponent record;
		
	public KelasDosenDecorator (KelasDosenComponent record) {
		this.record = record;
	}

	public KelasDosenDecorator (int id, KelasDosenComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KelasDosenDecorator(){
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


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
