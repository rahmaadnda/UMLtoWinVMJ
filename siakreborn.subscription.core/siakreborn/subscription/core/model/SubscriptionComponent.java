package siakreborn.subscription.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="subscription_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SubscriptionComponent implements Subscription{
	@Id
	protected UUID id; 
	protected String status;
	protected Date startDate;
	protected Date endDate;
	protected Date requestDate;
	@ManyToOne(targetEntity=siakreborn.subscriptionplan.core.SubscriptionPlanComponent.class)
	public SubscriptionPlan subscriptionplanimpl;

	public SubscriptionComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public abstract SubscriptionPlanImpl getSubscriptionplanimpl();
	public abstract void setSubscriptionplanimpl(SubscriptionPlanImpl subscriptionplanimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " status='" + getStatus() + "'" +
            " startDate='" + getStartDate() + "'" +
            " endDate='" + getEndDate() + "'" +
            " requestDate='" + getRequestDate() + "'" +
            " subscriptionplanimpl='" + getSubscriptionplanimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> subscriptionMap = new HashMap<String,Object>();
		subscriptionMap.put("id",getId());
		subscriptionMap.put("status",getStatus());
		subscriptionMap.put("startDate",getStartDate());
		subscriptionMap.put("endDate",getEndDate());
		subscriptionMap.put("requestDate",getRequestDate());
		subscriptionMap.put("subscriptionplanimpl",getSubscriptionplanimpl());

        return subscriptionMap;
    }
}
