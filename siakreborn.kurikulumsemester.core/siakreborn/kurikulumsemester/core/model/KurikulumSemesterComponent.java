package siakreborn.kurikulumsemester.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="kurikulumsemester_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class KurikulumSemesterComponent implements KurikulumSemester{
	@Id
	protected UUID id; 
	@ManyToOne(targetEntity=siakreborn.kurikulum.core.KurikulumComponent.class)
	public Kurikulum kurikulumimpl;
	@ManyToOne(targetEntity=siakreborn.semester.core.SemesterComponent.class)
	public Semester semesterimpl;

	public KurikulumSemesterComponent() {

	} 

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	public abstract KurikulumImpl getKurikulumimpl();
	public abstract void setKurikulumimpl(KurikulumImpl kurikulumimpl);
	
	public abstract SemesterImpl getSemesterimpl();
	public abstract void setSemesterimpl(SemesterImpl semesterimpl);
	
 

	@Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " kurikulumimpl='" + getKurikulumimpl() + "'" +
            " semesterimpl='" + getSemesterimpl() + "'" +
            "}";
    }
	
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> kurikulumsemesterMap = new HashMap<String,Object>();
		kurikulumsemesterMap.put("id",getId());
		kurikulumsemesterMap.put("kurikulumimpl",getKurikulumimpl());
		kurikulumsemesterMap.put("semesterimpl",getSemesterimpl());

        return kurikulumsemesterMap;
    }
}
