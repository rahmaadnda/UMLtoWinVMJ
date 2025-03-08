package siakreborn.programstudi.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface ProgramStudi {
	public UUID getId();
	public void setId(UUID id);
	public String getKode();
	public void setKode(String kode);
	public String getNoSK();
	public void setNoSK(String noSK);
	public String getNama();
	public void setNama(String nama);
	public String getKaprodi();
	public void setKaprodi(String kaprodi);
	public String getJenjang();
	public void setJenjang(String jenjang);
	HashMap<String, Object> toHashMap();
}
