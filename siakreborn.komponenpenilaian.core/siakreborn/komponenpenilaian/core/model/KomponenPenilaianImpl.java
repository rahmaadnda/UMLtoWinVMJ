package siakreborn.komponenpenilaian.core;

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


@Entity(name="komponenpenilaian_impl")
@Table(name="komponenpenilaian_impl")
public class KomponenPenilaianImpl extends KomponenPenilaianComponent {

	public KomponenPenilaianImpl(UUID id, String nama, KelasImpl kelasimpl, int bobot) {
		this.id = id;
		this.nama = nama;
		this.kelasimpl = kelasimpl;
		this.bobot = bobot;
	}

	public KomponenPenilaianImpl(, String nama, KelasImpl kelasimpl, int bobot) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = nama;
		this.kelasimpl = kelasimpl;
		this.bobot = bobot;
	}

	public KomponenPenilaianImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = "";
		this.bobot = 0;
	}


}
