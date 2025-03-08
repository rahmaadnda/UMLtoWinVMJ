package siakreborn.mahasiswa.mappingalumni;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.mahasiswa.core.MahasiswaDecorator;
import siakreborn.mahasiswa.core.Mahasiswa;
import siakreborn.mahasiswa.core.MahasiswaComponent;

@Entity(name="mahasiswa_mappingalumni")
@Table(name="mahasiswa_mappingalumni")
public class MahasiswaImpl extends MahasiswaDecorator {

	public MahasiswaImpl(MahasiswaComponent record, ) {
		super(record);
	}


	public HashMap<String, Object> graduate(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

}
