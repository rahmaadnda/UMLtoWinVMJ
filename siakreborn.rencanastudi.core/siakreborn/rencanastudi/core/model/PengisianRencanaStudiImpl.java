package siakreborn.rencanastudi.core;

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


@Entity(name="pengisianrencanastudi_impl")
@Table(name="pengisianrencanastudi_impl")
public class PengisianRencanaStudiImpl extends PengisianRencanaStudiComponent {

	public PengisianRencanaStudiImpl(DateTime mulai, DateTime akhir, UUID id, SemesterImpl semesterimpl) {
		this.mulai = mulai;
		this.akhir = akhir;
		this.id = id;
		this.semesterimpl = semesterimpl;
	}

	public PengisianRencanaStudiImpl(DateTime mulai, DateTime akhir, , SemesterImpl semesterimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.mulai = mulai;
		this.akhir = akhir;
		this.semesterimpl = semesterimpl;
	}

	public PengisianRencanaStudiImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}


}
