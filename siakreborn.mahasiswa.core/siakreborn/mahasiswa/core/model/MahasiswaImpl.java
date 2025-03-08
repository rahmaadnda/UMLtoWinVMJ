package siakreborn.mahasiswa.core;

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


@Entity(name="mahasiswa_impl")
@Table(name="mahasiswa_impl")
public class MahasiswaImpl extends MahasiswaComponent {

	public MahasiswaImpl(UUID id, String nama, String npm, String email, ProgramStudiImpl programstudiimpl, String statusAkademik, int tahunAngkatan, boolean isPublic) {
		this.id = id;
		this.nama = nama;
		this.npm = npm;
		this.email = email;
		this.programstudiimpl = programstudiimpl;
		this.statusAkademik = statusAkademik;
		this.tahunAngkatan = tahunAngkatan;
		this.isPublic = isPublic;
	}

	public MahasiswaImpl(, String nama, String npm, String email, ProgramStudiImpl programstudiimpl, String statusAkademik, int tahunAngkatan, boolean isPublic) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = nama;
		this.npm = npm;
		this.email = email;
		this.programstudiimpl = programstudiimpl;
		this.statusAkademik = statusAkademik;
		this.tahunAngkatan = tahunAngkatan;
		this.isPublic = isPublic;
	}

	public MahasiswaImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = "";
		this.npm = "";
		this.email = "";
		this.statusAkademik = "";
		this.tahunAngkatan = 0;
	}

	public HashMap<String, Object> verify(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

	public HashMap<String, Object> graduate(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

}
