package siakreborn.kurikulum.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="kurikulum_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KurikulumComponent implements Kurikulum{
	@Id
	protected UUID id; 
	protected String kode;
	protected String noSK;
	protected String status;
	protected String profilLulusan;
	@ManyToOne(targetEntity=siakreborn.programstudi.core.ProgramStudiComponent.class)
	public ProgramStudi programstudiimpl;

	public KurikulumComponent() {

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
	public String getNoSK() {
		return this.noSK;
	}

	public void setNoSK(String noSK) {
		this.noSK = noSK;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getProfilLulusan() {
		return this.profilLulusan;
	}

	public void setProfilLulusan(String profilLulusan) {
		this.profilLulusan = profilLulusan;
	}
	public abstract ProgramStudiImpl getProgramstudiimpl();
	public abstract void setProgramstudiimpl(ProgramStudiImpl programstudiimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " kode='" + getKode() + "'" +
            " noSK='" + getNoSK() + "'" +
            " status='" + getStatus() + "'" +
            " profilLulusan='" + getProfilLulusan() + "'" +
            " programstudiimpl='" + getProgramstudiimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> kurikulumMap = new HashMap<String,Object>();
		kurikulumMap.put("id",getId());
		kurikulumMap.put("kode",getKode());
		kurikulumMap.put("noSK",getNoSK());
		kurikulumMap.put("status",getStatus());
		kurikulumMap.put("profilLulusan",getProfilLulusan());
		kurikulumMap.put("programstudiimpl",getProgramstudiimpl());

        return kurikulumMap;
    }
}
