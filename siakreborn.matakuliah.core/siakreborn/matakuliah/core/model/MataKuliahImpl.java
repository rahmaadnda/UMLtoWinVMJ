package siakreborn.matakuliah.core;

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


@Entity(name="matakuliah_impl")
@Table(name="matakuliah_impl")
public class MataKuliahImpl extends MataKuliahComponent {

	public MataKuliahImpl(UUID id, String kode, String nama, int sks, int term, KurikulumImpl kurikulumimpl) {
		this.id = id;
		this.kode = kode;
		this.nama = nama;
		this.sks = sks;
		this.term = term;
		this.kurikulumimpl = kurikulumimpl;
	}

	public MataKuliahImpl(, String kode, String nama, int sks, int term, KurikulumImpl kurikulumimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = kode;
		this.nama = nama;
		this.sks = sks;
		this.term = term;
		this.kurikulumimpl = kurikulumimpl;
	}

	public MataKuliahImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = "";
		this.nama = "";
		this.sks = 0;
		this.term = 0;
	}


}
