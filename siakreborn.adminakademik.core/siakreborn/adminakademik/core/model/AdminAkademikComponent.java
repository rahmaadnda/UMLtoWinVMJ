package siakreborn.adminakademik.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="adminakademik_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AdminAkademikComponent implements AdminAkademik{
	@Id
	protected UUID id; 
	protected String email;
	protected String nama;

	public AdminAkademikComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " email='" + getEmail() + "'" +
            " nama='" + getNama() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> adminakademikMap = new HashMap<String,Object>();
		adminakademikMap.put("id",getId());
		adminakademikMap.put("email",getEmail());
		adminakademikMap.put("nama",getNama());

        return adminakademikMap;
    }
}
