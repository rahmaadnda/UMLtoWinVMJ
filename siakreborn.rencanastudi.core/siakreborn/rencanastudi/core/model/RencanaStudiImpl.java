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


@Entity(name="rencanastudi_impl")
@Table(name="rencanastudi_impl")
public class RencanaStudiImpl extends RencanaStudiComponent {

	public RencanaStudiImpl(UUID id, MahasiswaImpl mahasiswaimpl, SemesterImpl semesterimpl, int totalSKS, String status) {
		this.id = id;
		this.mahasiswaimpl = mahasiswaimpl;
		this.semesterimpl = semesterimpl;
		this.totalSKS = totalSKS;
		this.status = status;
	}

	public RencanaStudiImpl(, MahasiswaImpl mahasiswaimpl, SemesterImpl semesterimpl, int totalSKS, String status) {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.mahasiswaimpl = mahasiswaimpl;
		this.semesterimpl = semesterimpl;
		this.totalSKS = totalSKS;
		this.status = status;
	}

	public RencanaStudiImpl() {
		Random r = new Random();
		this.id =  Math.abs(r.nextInt());
		this.totalSKS = 0;
		this.status = "";
	}

	public void cekPembayaran() {
		// TODO: implement this method
	}

}
