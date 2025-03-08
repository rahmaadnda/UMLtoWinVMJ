package siakreborn.matakuliah.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="matakuliah_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MataKuliahComponent implements MataKuliah{
	@Id
	protected UUID id; 
	protected String kode;
	protected String nama;
	protected int sks;
	protected int term;
	@ManyToOne(targetEntity=siakreborn.kurikulum.core.KurikulumComponent.class)
	public Kurikulum kurikulumimpl;

	public MataKuliahComponent() {

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
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getSks() {
		return this.sks;
	}

	public void setSks(int sks) {
		this.sks = sks;
	}
	public int getTerm() {
		return this.term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
	public abstract KurikulumImpl getKurikulumimpl();
	public abstract void setKurikulumimpl(KurikulumImpl kurikulumimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " kode='" + getKode() + "'" +
            " nama='" + getNama() + "'" +
            " sks='" + getSks() + "'" +
            " term='" + getTerm() + "'" +
            " kurikulumimpl='" + getKurikulumimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> matakuliahMap = new HashMap<String,Object>();
		matakuliahMap.put("id",getId());
		matakuliahMap.put("kode",getKode());
		matakuliahMap.put("nama",getNama());
		matakuliahMap.put("sks",getSks());
		matakuliahMap.put("term",getTerm());
		matakuliahMap.put("kurikulumimpl",getKurikulumimpl());

        return matakuliahMap;
    }
}
