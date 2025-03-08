package siakreborn.kelas.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Kelas {
	public UUID getId();
	public void setId(UUID id);
	public String getNama();
	public void setNama(String nama);
	public int getKapasitas();
	public void setKapasitas(int kapasitas);
	public String getRuangan();
	public void setRuangan(String ruangan);
	public String getJadwal();
	public void setJadwal(String jadwal);
	public MataKuliahImpl getMatakuliahimpl();
	public void setMatakuliahimpl(MataKuliahImpl matakuliahimpl);
	public SemesterImpl getSemesterimpl();
	public void setSemesterimpl(SemesterImpl semesterimpl);
	HashMap<String, Object> toHashMap();
}
