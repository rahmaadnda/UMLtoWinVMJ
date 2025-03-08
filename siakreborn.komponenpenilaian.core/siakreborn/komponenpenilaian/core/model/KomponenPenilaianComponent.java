package siakreborn.komponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="komponenpenilaian_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KomponenPenilaianComponent implements KomponenPenilaian{
	@Id
	protected UUID id; 
	protected String nama;
	@ManyToOne(targetEntity=siakreborn.kelas.core.KelasComponent.class)
	public Kelas kelasimpl;
	protected int bobot;

	public KomponenPenilaianComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	public abstract KelasImpl getKelasimpl();
	public abstract void setKelasimpl(KelasImpl kelasimpl);
	
	public int getBobot() {
		return this.bobot;
	}

	public void setBobot(int bobot) {
		this.bobot = bobot;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " nama='" + getNama() + "'" +
            " kelasimpl='" + getKelasimpl() + "'" +
            " bobot='" + getBobot() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> komponenpenilaianMap = new HashMap<String,Object>();
		komponenpenilaianMap.put("id",getId());
		komponenpenilaianMap.put("nama",getNama());
		komponenpenilaianMap.put("kelasimpl",getKelasimpl());
		komponenpenilaianMap.put("bobot",getBobot());

        return komponenpenilaianMap;
    }
}
