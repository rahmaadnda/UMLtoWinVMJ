package siakreborn.capaian.cpl;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.capaian.core.CapaianDecorator;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;

@Entity(name="capaian_cpl")
@Table(name="capaian_cpl")
public class CapaianImpl extends CapaianDecorator {

	public CapaianImpl(CapaianComponent record, KurikulumImpl kurikulumimpl) {
		super(record);
	}



}
