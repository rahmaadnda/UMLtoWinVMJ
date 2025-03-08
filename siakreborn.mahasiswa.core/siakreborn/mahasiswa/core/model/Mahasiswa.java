package siakreborn.mahasiswa.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Mahasiswa {
	public UUID getId();
	public void setId(UUID id);
	public String getNama();
	public void setNama(String nama);
	public String getNpm();
	public void setNpm(String npm);
	public String getEmail();
	public void setEmail(String email);
	public ProgramStudiImpl getProgramstudiimpl();
	public void setProgramstudiimpl(ProgramStudiImpl programstudiimpl);
	public String getStatusAkademik();
	public void setStatusAkademik(String statusAkademik);
	public int getTahunAngkatan();
	public void setTahunAngkatan(int tahunAngkatan);
	public boolean getIsPublic();
	public void setIsPublic(boolean isPublic);
	HashMap<String, Object> toHashMap();
}
