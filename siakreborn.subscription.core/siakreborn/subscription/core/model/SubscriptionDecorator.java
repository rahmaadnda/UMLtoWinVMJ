package siakreborn.subscription.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class SubscriptionDecorator extends SubscriptionComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected SubscriptionComponent record;
		
	public SubscriptionDecorator (SubscriptionComponent record) {
		this.record = record;
	}

	public SubscriptionDecorator (int id, SubscriptionComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public SubscriptionDecorator(){
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
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}
	public Date getStartDate() {
		return record.getStartDate();
	}
	public void setStartDate(Date startDate) {
		record.setStartDate(startDate);
	}
	public Date getEndDate() {
		return record.getEndDate();
	}
	public void setEndDate(Date endDate) {
		record.setEndDate(endDate);
	}
	public Date getRequestDate() {
		return record.getRequestDate();
	}
	public void setRequestDate(Date requestDate) {
		record.setRequestDate(requestDate);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
