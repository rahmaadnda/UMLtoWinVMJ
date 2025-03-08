package siakreborn.matakuliah.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface MataKuliah {
	public UUID getId();
	public void setId(UUID id);
	public String getKode();
	public void setKode(String kode);
	public String getNama();
	public void setNama(String nama);
	public int getSks();
	public void setSks(int sks);
	public int getTerm();
	public void setTerm(int term);
	public KurikulumImpl getKurikulumimpl();
	public void setKurikulumimpl(KurikulumImpl kurikulumimpl);
	HashMap<String, Object> toHashMap();
}
