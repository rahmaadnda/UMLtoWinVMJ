package siakreborn.bobotkomponenpenilaian.core;

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


@Entity(name="bobotkomponenpenilaian_impl")
@Table(name="bobotkomponenpenilaian_impl")
public class BobotKomponenPenilaianImpl extends BobotKomponenPenilaianComponent {

	public BobotKomponenPenilaianImpl(UUID id, int bobot, KomponenPenilaianImpl komponenpenilaianimpl, CapaianImpl capaianimpl, CapaianImpl capaianimpl) {
		this.id = id;
		this.bobot = bobot;
		this.komponenpenilaianimpl = komponenpenilaianimpl;
		this.capaianimpl = capaianimpl;
		this.capaianimpl = capaianimpl;
	}

	public BobotKomponenPenilaianImpl(, int bobot, KomponenPenilaianImpl komponenpenilaianimpl, CapaianImpl capaianimpl, CapaianImpl capaianimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.bobot = bobot;
		this.komponenpenilaianimpl = komponenpenilaianimpl;
		this.capaianimpl = capaianimpl;
		this.capaianimpl = capaianimpl;
	}

	public BobotKomponenPenilaianImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.bobot = 0;
	}


}
