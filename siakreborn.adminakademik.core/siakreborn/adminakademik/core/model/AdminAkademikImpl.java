package siakreborn.adminakademik.core;

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


@Entity(name="adminakademik_impl")
@Table(name="adminakademik_impl")
public class AdminAkademikImpl extends AdminAkademikComponent {

	public AdminAkademikImpl(UUID id, String email, String nama) {
		this.id = id;
		this.email = email;
		this.nama = nama;
	}

	public AdminAkademikImpl(, String email, String nama) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.email = email;
		this.nama = nama;
	}

	public AdminAkademikImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.email = "";
		this.nama = "";
	}


}
