package siakreborn.kurikulum.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KurikulumDecorator extends KurikulumComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KurikulumComponent record;
		
	public KurikulumDecorator (KurikulumComponent record) {
		this.record = record;
	}

	public KurikulumDecorator (int id, KurikulumComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KurikulumDecorator(){
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
	public String getKode() {
		return record.getKode();
	}
	public void setKode(String kode) {
		record.setKode(kode);
	}
	public String getNoSK() {
		return record.getNoSK();
	}
	public void setNoSK(String noSK) {
		record.setNoSK(noSK);
	}
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}
	public String getProfilLulusan() {
		return record.getProfilLulusan();
	}
	public void setProfilLulusan(String profilLulusan) {
		record.setProfilLulusan(profilLulusan);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
