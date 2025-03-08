package siakreborn.dosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="dosen_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DosenComponent implements Dosen{
	@Id
	protected UUID id; 
	protected String nama;
	protected String nip;
	protected String email;

	public DosenComponent() {

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
	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " nama='" + getNama() + "'" +
            " nip='" + getNip() + "'" +
            " email='" + getEmail() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> dosenMap = new HashMap<String,Object>();
		dosenMap.put("id",getId());
		dosenMap.put("nama",getNama());
		dosenMap.put("nip",getNip());
		dosenMap.put("email",getEmail());

        return dosenMap;
    }
}
