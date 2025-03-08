package siakreborn.kelas.core;

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


@Entity(name="kelas_impl")
@Table(name="kelas_impl")
public class KelasImpl extends KelasComponent {

	public KelasImpl(UUID id, String nama, int kapasitas, String ruangan, String jadwal, MataKuliahImpl matakuliahimpl, SemesterImpl semesterimpl) {
		this.id = id;
		this.nama = nama;
		this.kapasitas = kapasitas;
		this.ruangan = ruangan;
		this.jadwal = jadwal;
		this.matakuliahimpl = matakuliahimpl;
		this.semesterimpl = semesterimpl;
	}

	public KelasImpl(, String nama, int kapasitas, String ruangan, String jadwal, MataKuliahImpl matakuliahimpl, SemesterImpl semesterimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = nama;
		this.kapasitas = kapasitas;
		this.ruangan = ruangan;
		this.jadwal = jadwal;
		this.matakuliahimpl = matakuliahimpl;
		this.semesterimpl = semesterimpl;
	}

	public KelasImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.nama = "";
		this.kapasitas = 0;
		this.ruangan = "";
		this.jadwal = "";
	}


}
