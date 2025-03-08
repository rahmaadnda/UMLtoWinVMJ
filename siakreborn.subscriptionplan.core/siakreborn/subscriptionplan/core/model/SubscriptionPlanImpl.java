package siakreborn.subscriptionplan.core;

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


@Entity(name="subscriptionplan_impl")
@Table(name="subscriptionplan_impl")
public class SubscriptionPlanImpl extends SubscriptionPlanComponent {

	public SubscriptionPlanImpl(UUID id, String deskripsi, String name, int harga) {
		this.id = id;
		this.deskripsi = deskripsi;
		this.name = name;
		this.harga = harga;
	}

	public SubscriptionPlanImpl(, String deskripsi, String name, int harga) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.deskripsi = deskripsi;
		this.name = name;
		this.harga = harga;
	}

	public SubscriptionPlanImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.deskripsi = "";
		this.name = "";
		this.harga = 0;
	}


}
