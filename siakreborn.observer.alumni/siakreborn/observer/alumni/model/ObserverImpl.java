package siakreborn.observer.alumni;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.observer.core.ObserverDecorator;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverComponent;

@Entity(name="observer_alumni")
@Table(name="observer_alumni")
public class ObserverImpl extends ObserverDecorator {

	protected String portofolioUrl;
	protected String linkedinUrl;
	protected String npm;
	protected String pekerjaan;
	protected String tempatKerja;
	protected int tahunLulus;
	protected boolean isPublic;
	public ObserverImpl(ObserverComponent record, String portofolioUrl, String linkedinUrl, String npm, String pekerjaan, String tempatKerja, int tahunLulus, boolean isPublic, MahasiswaImpl mahasiswaimpl) {
		super(record);
		this.portofolioUrl = portofolioUrl;
		this.linkedinUrl = linkedinUrl;
		this.npm = npm;
		this.pekerjaan = pekerjaan;
		this.tempatKerja = tempatKerja;
		this.tahunLulus = tahunLulus;
		this.isPublic = isPublic;
	}

	public String getPortofolioUrl() {
		return this.portofolioUrl;
	}

	public void setPortofolioUrl(String portofolioUrl) {
		this.portofolioUrl = portofolioUrl;
	}
	public String getLinkedinUrl() {
		return this.linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}
	public String getNpm() {
		return this.npm;
	}

	public void setNpm(String npm) {
		this.npm = npm;
	}
	public String getPekerjaan() {
		return this.pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}
	public String getTempatKerja() {
		return this.tempatKerja;
	}

	public void setTempatKerja(String tempatKerja) {
		this.tempatKerja = tempatKerja;
	}
	public int getTahunLulus() {
		return this.tahunLulus;
	}

	public void setTahunLulus(int tahunLulus) {
		this.tahunLulus = tahunLulus;
	}
	public boolean getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public HashMap<String, Object> verify(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

}
