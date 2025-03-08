package siakreborn.penilaian.penilaianobe;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.penilaian.core.PenilaianDecorator;
import siakreborn.penilaian.core.Penilaian;
import siakreborn.penilaian.core.PenilaianComponent;

@Entity(name="penilaian_penilaianobe")
@Table(name="penilaian_penilaianobe")
public class PenilaianImpl extends PenilaianDecorator {

	public PenilaianImpl(PenilaianComponent record, BobotKomponenPenilaianImpl bobotkomponenpenilaianimpl, KomponenPenilaianImpl komponenpenilaianimpl) {
		super(record);
	}


	public void getLaporanCPLKurikulum() {
		// TODO: implement this method
	}

	public void getLaporanCPLMahasiswa() {
		// TODO: implement this method
	}

	public void getLaporanCPMK() {
		// TODO: implement this method
	}

}
