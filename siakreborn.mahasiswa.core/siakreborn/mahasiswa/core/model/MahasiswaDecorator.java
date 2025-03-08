package siakreborn.mahasiswa.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class MahasiswaDecorator extends MahasiswaComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected MahasiswaComponent record;
		
	public MahasiswaDecorator (MahasiswaComponent record) {
		this.record = record;
	}

	public MahasiswaDecorator (int id, MahasiswaComponent record) {
		this.id =  id;
		this.record = record;
	}
	
	public MahasiswaDecorator(){
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
	public String getNpm() {
		return record.getNpm();
	}
	public void setNpm(String npm) {
		record.setNpm(npm);
	}
	public String getEmail() {
		return record.getEmail();
	}
	public void setEmail(String email) {
		record.setEmail(email);
	}
	public String getStatusAkademik() {
		return record.getStatusAkademik();
	}
	public void setStatusAkademik(String statusAkademik) {
		record.setStatusAkademik(statusAkademik);
	}
	public int getTahunAngkatan() {
		return record.getTahunAngkatan();
	}
	public void setTahunAngkatan(int tahunAngkatan) {
		record.setTahunAngkatan(tahunAngkatan);
	}
	public boolean getIsPublic() {
		return record.getIsPublic();
	}
	public void setIsPublic(boolean isPublic) {
		record.setIsPublic(isPublic);
	}

	public HashMap<String, Object> verify(VMJExchange vmjExchange) {
		return record.verify(vmjExchange);
	}

	public HashMap<String, Object> graduate(VMJExchange vmjExchange) {
		return record.graduate(vmjExchange);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
