package siakreborn.dosen.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Dosen {
	public UUID getId();
	public void setId(UUID id);
	public String getNama();
	public void setNama(String nama);
	public String getNip();
	public void setNip(String nip);
	public String getEmail();
	public void setEmail(String email);
	HashMap<String, Object> toHashMap();
}
