package siakreborn.penilaian.core;

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


@Entity(name="penilaian_impl")
@Table(name="penilaian_impl")
public class PenilaianImpl extends PenilaianComponent {

	public PenilaianImpl(UUID id, int nilai, MahasiswaImpl mahasiswaimpl, KomponenPenilaianImpl komponenpenilaianimpl) {
		this.id = id;
		this.nilai = nilai;
		this.mahasiswaimpl = mahasiswaimpl;
		this.komponenpenilaianimpl = komponenpenilaianimpl;
	}

	public PenilaianImpl(, int nilai, MahasiswaImpl mahasiswaimpl, KomponenPenilaianImpl komponenpenilaianimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nilai = nilai;
		this.mahasiswaimpl = mahasiswaimpl;
		this.komponenpenilaianimpl = komponenpenilaianimpl;
	}

	public PenilaianImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nilai = 0;
	}


}
