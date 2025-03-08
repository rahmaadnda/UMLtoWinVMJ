package siakreborn.rencanastudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class KelasMahasiswaDecorator extends KelasMahasiswaComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected KelasMahasiswaComponent record;
		
	public KelasMahasiswaDecorator (KelasMahasiswaComponent record) {
		this.record = record;
	}

	public KelasMahasiswaDecorator (int id, KelasMahasiswaComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public KelasMahasiswaDecorator(){
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
	public DateTime getTanggalPengisian() {
		return record.getTanggalPengisian();
	}
	public void setTanggalPengisian(DateTime tanggalPengisian) {
		record.setTanggalPengisian(tanggalPengisian);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
