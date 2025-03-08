package siakreborn.bobotkomponenpenilaian.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="bobotkomponenpenilaian_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BobotKomponenPenilaianComponent implements BobotKomponenPenilaian{
	@Id
	protected UUID id; 
	protected int bobot;
	@ManyToOne(targetEntity=siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class)
	public KomponenPenilaian komponenpenilaianimpl;
	@ManyToOne(targetEntity=siakreborn..core.Component.class)
	public  capaianimpl;
	@ManyToOne(targetEntity=siakreborn..core.Component.class)
	public  capaianimpl;

	public BobotKomponenPenilaianComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public int getBobot() {
		return this.bobot;
	}

	public void setBobot(int bobot) {
		this.bobot = bobot;
	}
	public abstract KomponenPenilaianImpl getKomponenpenilaianimpl();
	public abstract void setKomponenpenilaianimpl(KomponenPenilaianImpl komponenpenilaianimpl);
	
	public abstract CapaianImpl getCapaianimpl();
	public abstract void setCapaianimpl(CapaianImpl capaianimpl);
	
	public abstract CapaianImpl getCapaianimpl();
	public abstract void setCapaianimpl(CapaianImpl capaianimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " bobot='" + getBobot() + "'" +
            " komponenpenilaianimpl='" + getKomponenpenilaianimpl() + "'" +
            " capaianimpl='" + getCapaianimpl() + "'" +
            " capaianimpl='" + getCapaianimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bobotkomponenpenilaianMap = new HashMap<String,Object>();
		bobotkomponenpenilaianMap.put("id",getId());
		bobotkomponenpenilaianMap.put("bobot",getBobot());
		bobotkomponenpenilaianMap.put("komponenpenilaianimpl",getKomponenpenilaianimpl());
		bobotkomponenpenilaianMap.put("capaianimpl",getCapaianimpl());
		bobotkomponenpenilaianMap.put("capaianimpl",getCapaianimpl());

        return bobotkomponenpenilaianMap;
    }
}
