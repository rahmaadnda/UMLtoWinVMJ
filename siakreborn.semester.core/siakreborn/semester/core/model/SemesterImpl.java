package siakreborn.semester.core;

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


@Entity(name="semester_impl")
@Table(name="semester_impl")
public class SemesterImpl extends SemesterComponent {

	public SemesterImpl(UUID id, String kode, String status, String tanggalMulai, String tanggalSelesai, String deskripsi) {
		this.id = id;
		this.kode = kode;
		this.status = status;
		this.tanggalMulai = tanggalMulai;
		this.tanggalSelesai = tanggalSelesai;
		this.deskripsi = deskripsi;
	}

	public SemesterImpl(, String kode, String status, String tanggalMulai, String tanggalSelesai, String deskripsi) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = kode;
		this.status = status;
		this.tanggalMulai = tanggalMulai;
		this.tanggalSelesai = tanggalSelesai;
		this.deskripsi = deskripsi;
	}

	public SemesterImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kode = "";
		this.status = "";
		this.tanggalMulai = "";
		this.tanggalSelesai = "";
		this.deskripsi = "";
	}


}
