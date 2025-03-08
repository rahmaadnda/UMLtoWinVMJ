package siakreborn.penilaian.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Penilaian {
	public UUID getId();
	public void setId(UUID id);
	public int getNilai();
	public void setNilai(int nilai);
	public MahasiswaImpl getMahasiswaimpl();
	public void setMahasiswaimpl(MahasiswaImpl mahasiswaimpl);
	public KomponenPenilaianImpl getKomponenpenilaianimpl();
	public void setKomponenpenilaianimpl(KomponenPenilaianImpl komponenpenilaianimpl);
	HashMap<String, Object> toHashMap();
}
