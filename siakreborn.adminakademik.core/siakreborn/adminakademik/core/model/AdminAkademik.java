package siakreborn.adminakademik.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface AdminAkademik {
	public UUID getId();
	public void setId(UUID id);
	public String getEmail();
	public void setEmail(String email);
	public String getNama();
	public void setNama(String nama);
	HashMap<String, Object> toHashMap();
}
