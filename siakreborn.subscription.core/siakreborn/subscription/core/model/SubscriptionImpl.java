package siakreborn.subscription.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="subscription_impl")
@Table(name="subscription_impl")
public class SubscriptionImpl extends SubscriptionComponent {

	public SubscriptionImpl(UUID id, String status, Date startDate, Date endDate, Date requestDate, SubscriptionPlanImpl subscriptionplanimpl) {
		this.id = id;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.requestDate = requestDate;
		this.subscriptionplanimpl = subscriptionplanimpl;
	}

	public SubscriptionImpl(, String status, Date startDate, Date endDate, Date requestDate, SubscriptionPlanImpl subscriptionplanimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.requestDate = requestDate;
		this.subscriptionplanimpl = subscriptionplanimpl;
	}

	public SubscriptionImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.status = "";
	}


}
