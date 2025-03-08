package siakreborn.rencanastudi.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="pengisianrencanastudi_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PengisianRencanaStudiComponent implements PengisianRencanaStudi{
	@Id
	protected UUID id; 
	protected DateTime mulai;
	protected DateTime akhir;
	@ManyToOne(targetEntity=siakreborn.semester.core.SemesterComponent.class)
	public Semester semesterimpl;

	public PengisianRencanaStudiComponent() {

	} 

	public DateTime getMulai() {
		return this.mulai;
	}

	public void setMulai(DateTime mulai) {
		this.mulai = mulai;
	}
	public DateTime getAkhir() {
		return this.akhir;
	}

	public void setAkhir(DateTime akhir) {
		this.akhir = akhir;
	}
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public abstract SemesterImpl getSemesterimpl();
	public abstract void setSemesterimpl(SemesterImpl semesterimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " mulai='" + getMulai() + "'" +
            " akhir='" + getAkhir() + "'" +
            " id='" + getId() + "'" +
            " semesterimpl='" + getSemesterimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> pengisianrencanastudiMap = new HashMap<String,Object>();
		pengisianrencanastudiMap.put("mulai",getMulai());
		pengisianrencanastudiMap.put("akhir",getAkhir());
		pengisianrencanastudiMap.put("id",getId());
		pengisianrencanastudiMap.put("semesterimpl",getSemesterimpl());

        return pengisianrencanastudiMap;
    }
}
