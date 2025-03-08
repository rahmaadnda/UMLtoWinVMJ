package siakreborn.kurikulum.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Kurikulum {
	public UUID getId();
	public void setId(UUID id);
	public String getKode();
	public void setKode(String kode);
	public String getNoSK();
	public void setNoSK(String noSK);
	public String getStatus();
	public void setStatus(String status);
	public String getProfilLulusan();
	public void setProfilLulusan(String profilLulusan);
	public ProgramStudiImpl getProgramstudiimpl();
	public void setProgramstudiimpl(ProgramStudiImpl programstudiimpl);
	HashMap<String, Object> toHashMap();
}
