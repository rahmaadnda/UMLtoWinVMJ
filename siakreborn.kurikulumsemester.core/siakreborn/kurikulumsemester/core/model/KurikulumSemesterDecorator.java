package siakreborn.kurikulumsemester.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KurikulumSemesterDecorator extends KurikulumSemesterComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KurikulumSemesterComponent record;
		
	public KurikulumSemesterDecorator (KurikulumSemesterComponent record) {
		this.record = record;
	}

	public KurikulumSemesterDecorator (int id, KurikulumSemesterComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KurikulumSemesterDecorator(){
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
