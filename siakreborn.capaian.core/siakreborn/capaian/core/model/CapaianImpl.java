package siakreborn.capaian.core;

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


@Entity(name="capaian_impl")
@Table(name="capaian_impl")
public class CapaianImpl extends CapaianComponent {

	public CapaianImpl(UUID id, String kode, String deskripsi) {
		this.id = id;
		this.kode = kode;
		this.deskripsi = deskripsi;
	}

	public CapaianImpl(, String kode, String deskripsi) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = kode;
		this.deskripsi = deskripsi;
	}

	public CapaianImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = "";
		this.deskripsi = "";
	}


}
