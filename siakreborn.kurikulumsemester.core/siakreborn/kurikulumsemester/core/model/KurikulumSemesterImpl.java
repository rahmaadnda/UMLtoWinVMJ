package siakreborn.kurikulumsemester.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="kurikulumsemester_impl")
@Table(name="kurikulumsemester_impl")
public class KurikulumSemesterImpl extends KurikulumSemesterComponent {

	public KurikulumSemesterImpl(UUID id, KurikulumImpl kurikulumimpl, SemesterImpl semesterimpl) {
		this.id = id;
		this.kurikulumimpl = kurikulumimpl;
		this.semesterimpl = semesterimpl;
	}

	public KurikulumSemesterImpl(, KurikulumImpl kurikulumimpl, SemesterImpl semesterimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kurikulumimpl = kurikulumimpl;
		this.semesterimpl = semesterimpl;
	}

	public KurikulumSemesterImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}


}
