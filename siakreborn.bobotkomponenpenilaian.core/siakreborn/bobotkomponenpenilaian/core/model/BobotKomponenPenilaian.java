package siakreborn.bobotkomponenpenilaian.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface BobotKomponenPenilaian {
	public UUID getId();
	public void setId(UUID id);
	public int getBobot();
	public void setBobot(int bobot);
	public KomponenPenilaianImpl getKomponenpenilaianimpl();
	public void setKomponenpenilaianimpl(KomponenPenilaianImpl komponenpenilaianimpl);
	public CapaianImpl getCapaianimpl();
	public void setCapaianimpl(CapaianImpl capaianimpl);
	public CapaianImpl getCapaianimpl();
	public void setCapaianimpl(CapaianImpl capaianimpl);
	HashMap<String, Object> toHashMap();
}
