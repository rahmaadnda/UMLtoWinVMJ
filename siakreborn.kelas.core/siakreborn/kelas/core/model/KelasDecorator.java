package siakreborn.kelas.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KelasDecorator extends KelasComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KelasComponent record;
		
	public KelasDecorator (KelasComponent record) {
		this.record = record;
	}

	public KelasDecorator (int id, KelasComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KelasDecorator(){
		super();
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}

	public UUID getId() {
		return record.getId();
	}
	public void setId(UUID id) {
		record.setId(id);
	}
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public int getKapasitas() {
		return record.getKapasitas();
	}
	public void setKapasitas(int kapasitas) {
		record.setKapasitas(kapasitas);
	}
	public String getRuangan() {
		return record.getRuangan();
	}
	public void setRuangan(String ruangan) {
		record.setRuangan(ruangan);
	}
	public String getJadwal() {
		return record.getJadwal();
	}
	public void setJadwal(String jadwal) {
		record.setJadwal(jadwal);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
