package siakreborn.informasi.alumni;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.informasi.core.InformasiDecorator;
import siakreborn.informasi.core.Informasi;
import siakreborn.informasi.core.InformasiComponent;

@Entity(name="informasi_alumni")
@Table(name="informasi_alumni")
public class InformasiImpl extends InformasiDecorator {

	public InformasiImpl(InformasiComponent record, ObserverImpl observerimpl) {
		super(record);
	}



}
