package siakreborn.kelasdosen.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="kelasdosen_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KelasDosenComponent implements KelasDosen{
	@Id
	protected UUID id; 
	@ManyToOne(targetEntity=siakreborn.dosen.core.DosenComponent.class)
	public Dosen dosenimpl;
	@ManyToOne(targetEntity=siakreborn.kelas.core.KelasComponent.class)
	public Kelas kelasimpl;

	public KelasDosenComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public abstract DosenImpl getDosenimpl();
	public abstract void setDosenimpl(DosenImpl dosenimpl);
	
	public abstract KelasImpl getKelasimpl();
	public abstract void setKelasimpl(KelasImpl kelasimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " dosenimpl='" + getDosenimpl() + "'" +
            " kelasimpl='" + getKelasimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> kelasdosenMap = new HashMap<String,Object>();
		kelasdosenMap.put("id",getId());
		kelasdosenMap.put("dosenimpl",getDosenimpl());
		kelasdosenMap.put("kelasimpl",getKelasimpl());

        return kelasdosenMap;
    }
}
