package siakreborn.semester.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Semester {
	public UUID getId();
	public void setId(UUID id);
	public String getKode();
	public void setKode(String kode);
	public String getStatus();
	public void setStatus(String status);
	public String getTanggalMulai();
	public void setTanggalMulai(String tanggalMulai);
	public String getTanggalSelesai();
	public void setTanggalSelesai(String tanggalSelesai);
	public String getDeskripsi();
	public void setDeskripsi(String deskripsi);
	HashMap<String, Object> toHashMap();
}
