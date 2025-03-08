package siakreborn.semester.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="semester_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SemesterComponent implements Semester{
	@Id
	protected UUID id; 
	protected String kode;
	protected String status;
	protected String tanggalMulai;
	protected String tanggalSelesai;
	protected String deskripsi;

	public SemesterComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getKode() {
		return this.kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getTanggalMulai() {
		return this.tanggalMulai;
	}

	public void setTanggalMulai(String tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}
	public String getTanggalSelesai() {
		return this.tanggalSelesai;
	}

	public void setTanggalSelesai(String tanggalSelesai) {
		this.tanggalSelesai = tanggalSelesai;
	}
	public String getDeskripsi() {
		return this.deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " kode='" + getKode() + "'" +
            " status='" + getStatus() + "'" +
            " tanggalMulai='" + getTanggalMulai() + "'" +
            " tanggalSelesai='" + getTanggalSelesai() + "'" +
            " deskripsi='" + getDeskripsi() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> semesterMap = new HashMap<String,Object>();
		semesterMap.put("id",getId());
		semesterMap.put("kode",getKode());
		semesterMap.put("status",getStatus());
		semesterMap.put("tanggalMulai",getTanggalMulai());
		semesterMap.put("tanggalSelesai",getTanggalSelesai());
		semesterMap.put("deskripsi",getDeskripsi());

        return semesterMap;
    }
}
