package siakreborn.informasi.industri;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.informasi.core.InformasiDecorator;
import siakreborn.informasi.core.Informasi;
import siakreborn.informasi.core.InformasiComponent;

@Entity(name="informasi_industri")
@Table(name="informasi_industri")
public class InformasiImpl extends InformasiDecorator {

	public InformasiImpl(InformasiComponent record, ObserverImpl observerimpl) {
		super(record);
	}



}
