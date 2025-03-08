package siakreborn.programstudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ProgramStudiDecorator extends ProgramStudiComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ProgramStudiComponent record;
		
	public ProgramStudiDecorator (ProgramStudiComponent record) {
		this.record = record;
	}

	public ProgramStudiDecorator (int id, ProgramStudiComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public ProgramStudiDecorator(){
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
	public String getNama() {
		return record.getNama();
	}
	public void setNama(String nama) {
		record.setNama(nama);
	}
	public String getKaprodi() {
		return record.getKaprodi();
	}
	public void setKaprodi(String kaprodi) {
		record.setKaprodi(kaprodi);
	}
	public String getJenjang() {
		return record.getJenjang();
	}
	public void setJenjang(String jenjang) {
		record.setJenjang(jenjang);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
