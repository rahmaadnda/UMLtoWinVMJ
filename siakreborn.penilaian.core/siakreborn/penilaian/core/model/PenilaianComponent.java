package siakreborn.penilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="penilaian_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PenilaianComponent implements Penilaian{
	@Id
	protected UUID id; 
	protected int nilai;
	@ManyToOne(targetEntity=siakreborn.mahasiswa.core.MahasiswaComponent.class)
	public Mahasiswa mahasiswaimpl;
	@ManyToOne(targetEntity=siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class)
	public KomponenPenilaian komponenpenilaianimpl;

	public PenilaianComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public int getNilai() {
		return this.nilai;
	}

	public void setNilai(int nilai) {
		this.nilai = nilai;
	}
	public abstract MahasiswaImpl getMahasiswaimpl();
	public abstract void setMahasiswaimpl(MahasiswaImpl mahasiswaimpl);
	
	public abstract KomponenPenilaianImpl getKomponenpenilaianimpl();
	public abstract void setKomponenpenilaianimpl(KomponenPenilaianImpl komponenpenilaianimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " nilai='" + getNilai() + "'" +
            " mahasiswaimpl='" + getMahasiswaimpl() + "'" +
            " komponenpenilaianimpl='" + getKomponenpenilaianimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> penilaianMap = new HashMap<String,Object>();
		penilaianMap.put("id",getId());
		penilaianMap.put("nilai",getNilai());
		penilaianMap.put("mahasiswaimpl",getMahasiswaimpl());
		penilaianMap.put("komponenpenilaianimpl",getKomponenpenilaianimpl());

        return penilaianMap;
    }
}
