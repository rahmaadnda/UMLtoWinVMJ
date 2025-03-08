package siakreborn.komponenpenilaian.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface KomponenPenilaian {
	public UUID getId();
	public void setId(UUID id);
	public String getNama();
	public void setNama(String nama);
	public KelasImpl getKelasimpl();
	public void setKelasimpl(KelasImpl kelasimpl);
	public int getBobot();
	public void setBobot(int bobot);
	HashMap<String, Object> toHashMap();
}
