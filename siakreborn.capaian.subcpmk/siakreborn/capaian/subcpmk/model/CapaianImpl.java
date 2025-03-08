package siakreborn.capaian.subcpmk;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.capaian.core.CapaianDecorator;
import siakreborn.capaian.core.Capaian;
import siakreborn.capaian.core.CapaianComponent;

@Entity(name="capaian_subcpmk")
@Table(name="capaian_subcpmk")
public class CapaianImpl extends CapaianDecorator {

	public int bobot;
	public CapaianImpl(CapaianComponent record, int bobot) {
		super(record);
		this.bobot = bobot;
	}



}
