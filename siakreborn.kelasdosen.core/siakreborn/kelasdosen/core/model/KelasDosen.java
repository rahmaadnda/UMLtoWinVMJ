package siakreborn.kelasdosen.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface KelasDosen {
	public UUID getId();
	public void setId(UUID id);
	public DosenImpl getDosenimpl();
	public void setDosenimpl(DosenImpl dosenimpl);
	public KelasImpl getKelasimpl();
	public void setKelasimpl(KelasImpl kelasimpl);
	HashMap<String, Object> toHashMap();
}
