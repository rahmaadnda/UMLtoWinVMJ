package siakreborn.observer.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Observer {
	public String getNama();
	public void setNama(String nama);
	public UUID getId();
	public void setId(UUID id);
	public String getEmail();
	public void setEmail(String email);
	HashMap<String, Object> toHashMap();
}
