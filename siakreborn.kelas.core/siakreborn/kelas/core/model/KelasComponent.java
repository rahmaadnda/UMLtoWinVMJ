package siakreborn.kelas.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="kelas_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KelasComponent implements Kelas{
	@Id
	protected UUID id; 
	protected String nama;
	protected int kapasitas;
	protected String ruangan;
	protected String jadwal;
	@ManyToOne(targetEntity=siakreborn.matakuliah.core.MataKuliahComponent.class)
	public MataKuliah matakuliahimpl;
	@ManyToOne(targetEntity=siakreborn.semester.core.SemesterComponent.class)
	public Semester semesterimpl;

	public KelasComponent() {

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
	public int getKapasitas() {
		return this.kapasitas;
	}

	public void setKapasitas(int kapasitas) {
		this.kapasitas = kapasitas;
	}
	public String getRuangan() {
		return this.ruangan;
	}

	public void setRuangan(String ruangan) {
		this.ruangan = ruangan;
	}
	public String getJadwal() {
		return this.jadwal;
	}

	public void setJadwal(String jadwal) {
		this.jadwal = jadwal;
	}
	public abstract MataKuliahImpl getMatakuliahimpl();
	public abstract void setMatakuliahimpl(MataKuliahImpl matakuliahimpl);
	
	public abstract SemesterImpl getSemesterimpl();
	public abstract void setSemesterimpl(SemesterImpl semesterimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " nama='" + getNama() + "'" +
            " kapasitas='" + getKapasitas() + "'" +
            " ruangan='" + getRuangan() + "'" +
            " jadwal='" + getJadwal() + "'" +
            " matakuliahimpl='" + getMatakuliahimpl() + "'" +
            " semesterimpl='" + getSemesterimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> kelasMap = new HashMap<String,Object>();
		kelasMap.put("id",getId());
		kelasMap.put("nama",getNama());
		kelasMap.put("kapasitas",getKapasitas());
		kelasMap.put("ruangan",getRuangan());
		kelasMap.put("jadwal",getJadwal());
		kelasMap.put("matakuliahimpl",getMatakuliahimpl());
		kelasMap.put("semesterimpl",getSemesterimpl());

        return kelasMap;
    }
}
