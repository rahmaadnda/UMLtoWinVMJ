package siakreborn.observer.core;

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


@Entity(name="observer_impl")
@Table(name="observer_impl")
public class ObserverImpl extends ObserverComponent {

	public ObserverImpl(String nama, UUID id, String email) {
		this.nama = nama;
		this.id = id;
		this.email = email;
	}

	public ObserverImpl(String nama, , String email) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = nama;
		this.email = email;
	}

	public ObserverImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = "";
		this.email = "";
	}


}
