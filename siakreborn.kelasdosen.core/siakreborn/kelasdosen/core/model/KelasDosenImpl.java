package siakreborn.kelasdosen.core;

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


@Entity(name="kelasdosen_impl")
@Table(name="kelasdosen_impl")
public class KelasDosenImpl extends KelasDosenComponent {

	public KelasDosenImpl(UUID id, DosenImpl dosenimpl, KelasImpl kelasimpl) {
		this.id = id;
		this.dosenimpl = dosenimpl;
		this.kelasimpl = kelasimpl;
	}

	public KelasDosenImpl(, DosenImpl dosenimpl, KelasImpl kelasimpl) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.dosenimpl = dosenimpl;
		this.kelasimpl = kelasimpl;
	}

	public KelasDosenImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}


}
