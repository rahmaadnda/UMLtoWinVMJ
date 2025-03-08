package siakreborn.mahasiswa.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="mahasiswa_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MahasiswaComponent implements Mahasiswa{
	@Id
	protected UUID id; 
	protected String nama;
	protected String npm;
	protected String email;
	@ManyToOne(targetEntity=siakreborn.programstudi.core.ProgramStudiComponent.class)
	public ProgramStudi programstudiimpl;
	protected String statusAkademik;
	protected int tahunAngkatan;
	protected boolean isPublic;

	public MahasiswaComponent() {

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
	public String getNpm() {
		return this.npm;
	}

	public void setNpm(String npm) {
		this.npm = npm;
	}
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public abstract ProgramStudiImpl getProgramstudiimpl();
	public abstract void setProgramstudiimpl(ProgramStudiImpl programstudiimpl);
	
	public String getStatusAkademik() {
		return this.statusAkademik;
	}

	public void setStatusAkademik(String statusAkademik) {
		this.statusAkademik = statusAkademik;
	}
	public int getTahunAngkatan() {
		return this.tahunAngkatan;
	}

	public void setTahunAngkatan(int tahunAngkatan) {
		this.tahunAngkatan = tahunAngkatan;
	}
	public boolean getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
 
	public abstract HashMap<String, Object> verify(VMJExchange vmjExchange);

	public abstract HashMap<String, Object> graduate(VMJExchange vmjExchange);

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " nama='" + getNama() + "'" +
            " npm='" + getNpm() + "'" +
            " email='" + getEmail() + "'" +
            " programstudiimpl='" + getProgramstudiimpl() + "'" +
            " statusAkademik='" + getStatusAkademik() + "'" +
            " tahunAngkatan='" + getTahunAngkatan() + "'" +
            " isPublic='" + getIsPublic() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> mahasiswaMap = new HashMap<String,Object>();
		mahasiswaMap.put("id",getId());
		mahasiswaMap.put("nama",getNama());
		mahasiswaMap.put("npm",getNpm());
		mahasiswaMap.put("email",getEmail());
		mahasiswaMap.put("programstudiimpl",getProgramstudiimpl());
		mahasiswaMap.put("statusAkademik",getStatusAkademik());
		mahasiswaMap.put("tahunAngkatan",getTahunAngkatan());
		mahasiswaMap.put("isPublic",getIsPublic());

        return mahasiswaMap;
    }
}
