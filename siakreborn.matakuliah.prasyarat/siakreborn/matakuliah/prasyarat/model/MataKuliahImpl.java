package siakreborn.matakuliah.prasyarat;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import siakreborn.matakuliah.core.MataKuliahDecorator;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.matakuliah.core.MataKuliahComponent;
import siakreborn.util.core.Util;

@Entity(name="matakuliah_prasyarat")
@Table(name="matakuliah_prasyarat")
public class MataKuliahImpl extends MataKuliahDecorator {

	protected String syarat;
	@ManyToOne(targetEntity = siakreborn.matakuliah.core.MataKuliahComponent.class)
	public MataKuliah parentMataKuliah;

	public MataKuliahImpl() {
		super();
		this.objectName = MataKuliahImpl.class.getName();
	}

	public MataKuliahImpl(String syarat, MataKuliah parentMataKuliah) {
		super();
		this.syarat = syarat;
		this.parentMataKuliah = parentMataKuliah;
		this.objectName = MataKuliahImpl.class.getName();
	}
	
	public MataKuliahImpl(MataKuliahComponent record, String syarat, MataKuliah parentMataKuliah) {
		super(record, MataKuliahImpl.class.getName());
		this.syarat = syarat;
		this.parentMataKuliah = parentMataKuliah;
		this.objectName = MataKuliahImpl.class.getName();
	}

	public MataKuliahImpl(UUID id, MataKuliahComponent record, String syarat, MataKuliah parentMataKuliah) {
		super(id, record);
		this.syarat = syarat;
		this.parentMataKuliah = parentMataKuliah;
		this.objectName = MataKuliahImpl.class.getName();
	}

	public String getSyarat() {
		return this.syarat;
	}

	public void setSyarat(String syarat) {
		this.syarat = syarat;
	}

	public MataKuliah getParentMataKuliah() {
		return parentMataKuliah;
	}

	public void setParentMataKuliah(MataKuliah parentMataKuliah) {
		this.parentMataKuliah = parentMataKuliah;
	}

	@Override
	public String toString() {
	  return "{" +
		  " id='" + getId() + "'" +
		  " record='" + getRecord() + "'" +
		  " syarat='" + getSyarat() + "'" +
		  " parentMataKuliah='" + getParentMataKuliah() + "'" +
		  "}";
	}
  
	public HashMap<String, Object> toHashMap() {
	  HashMap<String, Object> mataKuliahMap = record.toHashMap();
	  mataKuliahMap.put("id", this.getId());
	  mataKuliahMap.put("syarat", this.getSyarat());
	  mataKuliahMap = Util.combine(mataKuliahMap, this.getParentMataKuliah().toHashMap(), "parentMataKuliah");
	  return mataKuliahMap;
	}
}
