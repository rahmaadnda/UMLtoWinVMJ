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


@Entity(name="kelasmahasiswa_impl")
@Table(name="kelasmahasiswa_impl")
public class KelasMahasiswaImpl extends KelasMahasiswaComponent {

	public KelasMahasiswaImpl(UUID id, KelasImpl kelasimpl, RencanaStudiImpl rencanastudi, DateTime tanggalPengisian) {
		this.id = id;
		this.kelasimpl = kelasimpl;
		this.rencanastudi = rencanastudi;
		this.tanggalPengisian = tanggalPengisian;
	}

	public KelasMahasiswaImpl(, KelasImpl kelasimpl, RencanaStudiImpl rencanastudi, DateTime tanggalPengisian) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.kelasimpl = kelasimpl;
		this.rencanastudi = rencanastudi;
		this.tanggalPengisian = tanggalPengisian;
	}

	public KelasMahasiswaImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
	}


}
