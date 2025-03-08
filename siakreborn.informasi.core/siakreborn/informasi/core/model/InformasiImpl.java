package siakreborn.informasi.core;

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


@Entity(name="informasi_impl")
@Table(name="informasi_impl")
public class InformasiImpl extends InformasiComponent {

	public InformasiImpl(String judul, UUID id, String deskripsi, Date tanggalPublikasi) {
		this.judul = judul;
		this.id = id;
		this.deskripsi = deskripsi;
		this.tanggalPublikasi = tanggalPublikasi;
	}

	public InformasiImpl(String judul, , String deskripsi, Date tanggalPublikasi) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.judul = judul;
		this.deskripsi = deskripsi;
		this.tanggalPublikasi = tanggalPublikasi;
	}

	public InformasiImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.judul = "";
		this.deskripsi = "";
	}


}
