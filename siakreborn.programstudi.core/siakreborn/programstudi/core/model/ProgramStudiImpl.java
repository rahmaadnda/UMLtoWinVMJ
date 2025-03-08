package siakreborn.programstudi.core;

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


@Entity(name="programstudi_impl")
@Table(name="programstudi_impl")
public class ProgramStudiImpl extends ProgramStudiComponent {

	public ProgramStudiImpl(UUID id, String kode, String noSK, String nama, String kaprodi, String jenjang) {
		this.id = id;
		this.kode = kode;
		this.noSK = noSK;
		this.nama = nama;
		this.kaprodi = kaprodi;
		this.jenjang = jenjang;
	}

	public ProgramStudiImpl(, String kode, String noSK, String nama, String kaprodi, String jenjang) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = kode;
		this.noSK = noSK;
		this.nama = nama;
		this.kaprodi = kaprodi;
		this.jenjang = jenjang;
	}

	public ProgramStudiImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = "";
		this.noSK = "";
		this.nama = "";
		this.kaprodi = "";
		this.jenjang = "";
	}


}
