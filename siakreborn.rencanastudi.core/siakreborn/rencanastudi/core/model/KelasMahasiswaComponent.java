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
@Table(name="kelasmahasiswa_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KelasMahasiswaComponent implements KelasMahasiswa{
	@Id
	protected UUID id; 
	@ManyToOne(targetEntity=siakreborn.kelas.core.KelasComponent.class)
	public Kelas kelasimpl;
	@ManyToOne(targetEntity=siakreborn.rencanastudi.core.RencanaStudiComponent.class)
	public RencanaStudi rencanastudi;
	protected DateTime tanggalPengisian;

	public KelasMahasiswaComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public abstract KelasImpl getKelasimpl();
	public abstract void setKelasimpl(KelasImpl kelasimpl);
	
	public abstract RencanaStudiImpl getRencanastudi();
	public abstract void setRencanastudi(RencanaStudiImpl rencanastudi);
	
	public DateTime getTanggalPengisian() {
		return this.tanggalPengisian;
	}

	public void setTanggalPengisian(DateTime tanggalPengisian) {
		this.tanggalPengisian = tanggalPengisian;
	}
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " kelasimpl='" + getKelasimpl() + "'" +
            " rencanastudi='" + getRencanastudi() + "'" +
            " tanggalPengisian='" + getTanggalPengisian() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> kelasmahasiswaMap = new HashMap<String,Object>();
		kelasmahasiswaMap.put("id",getId());
		kelasmahasiswaMap.put("kelasimpl",getKelasimpl());
		kelasmahasiswaMap.put("rencanastudi",getRencanastudi());
		kelasmahasiswaMap.put("tanggalPengisian",getTanggalPengisian());

        return kelasmahasiswaMap;
    }
}
