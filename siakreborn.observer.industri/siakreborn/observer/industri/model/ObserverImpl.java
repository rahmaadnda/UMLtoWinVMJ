package siakreborn.observer.industri;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import siakreborn.observer.core.ObserverDecorator;
import siakreborn.observer.core.Observer;
import siakreborn.observer.core.ObserverComponent;

@Entity(name="observer_industri")
@Table(name="observer_industri")
public class ObserverImpl extends ObserverDecorator {

	protected String websiteUrl;
	protected String domain;
	protected String alamat;
	protected int tahunBerdiri;
	protected int jumlahKaryawan;
	public ObserverImpl(ObserverComponent record, String websiteUrl, String domain, String alamat, int tahunBerdiri, int jumlahKaryawan, SubscriptionImpl subscriptionimpl) {
		super(record);
		this.websiteUrl = websiteUrl;
		this.domain = domain;
		this.alamat = alamat;
		this.tahunBerdiri = tahunBerdiri;
		this.jumlahKaryawan = jumlahKaryawan;
	}

	public String getWebsiteUrl() {
		return this.websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public int getTahunBerdiri() {
		return this.tahunBerdiri;
	}

	public void setTahunBerdiri(int tahunBerdiri) {
		this.tahunBerdiri = tahunBerdiri;
	}
	public int getJumlahKaryawan() {
		return this.jumlahKaryawan;
	}

	public void setJumlahKaryawan(int jumlahKaryawan) {
		this.jumlahKaryawan = jumlahKaryawan;
	}

	public HashMap<String, Object> subscriptionRequest(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

	public HashMap<String, Object> subscriptionApprove(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

}
