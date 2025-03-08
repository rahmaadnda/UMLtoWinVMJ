package siakreborn.rencanastudi.precheckpembayaran;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.rencanastudi.core.RencanaStudiDecorator;
import siakreborn.rencanastudi.core.RencanaStudi;
import siakreborn.rencanastudi.core.RencanaStudiComponent;

@Entity(name="rencanastudi_precheckpembayaran")
@Table(name="rencanastudi_precheckpembayaran")
public class RencanaStudiImpl extends RencanaStudiDecorator {

	public RencanaStudiImpl(RencanaStudiComponent record, ) {
		super(record);
	}


	public void cekPembayaran() {
		// TODO: implement this method
	}

}
