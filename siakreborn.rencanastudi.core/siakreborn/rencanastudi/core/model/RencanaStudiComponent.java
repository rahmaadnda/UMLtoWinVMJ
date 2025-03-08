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
@Table(name="rencanastudi_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RencanaStudiComponent implements RencanaStudi{
	@Id
	protected UUID id; 
	@ManyToOne(targetEntity=siakreborn.mahasiswa.core.MahasiswaComponent.class)
	public Mahasiswa mahasiswaimpl;
	@ManyToOne(targetEntity=siakreborn.semester.core.SemesterComponent.class)
	public Semester semesterimpl;
	protected int totalSKS;
	protected String status;

	public RencanaStudiComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public abstract MahasiswaImpl getMahasiswaimpl();
	public abstract void setMahasiswaimpl(MahasiswaImpl mahasiswaimpl);
	
	public abstract SemesterImpl getSemesterimpl();
	public abstract void setSemesterimpl(SemesterImpl semesterimpl);
	
	public int getTotalSKS() {
		return this.totalSKS;
	}

	public void setTotalSKS(int totalSKS) {
		this.totalSKS = totalSKS;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
 
	public abstract void cekPembayaran();

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " mahasiswaimpl='" + getMahasiswaimpl() + "'" +
            " semesterimpl='" + getSemesterimpl() + "'" +
            " totalSKS='" + getTotalSKS() + "'" +
            " status='" + getStatus() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> rencanastudiMap = new HashMap<String,Object>();
		rencanastudiMap.put("id",getId());
		rencanastudiMap.put("mahasiswaimpl",getMahasiswaimpl());
		rencanastudiMap.put("semesterimpl",getSemesterimpl());
		rencanastudiMap.put("totalSKS",getTotalSKS());
		rencanastudiMap.put("status",getStatus());

        return rencanastudiMap;
    }
}
