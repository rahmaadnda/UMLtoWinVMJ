package siakreborn.kurikulumsemester.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface KurikulumSemester {
	public UUID getId();
	public void setId(UUID id);
	public KurikulumImpl getKurikulumimpl();
	public void setKurikulumimpl(KurikulumImpl kurikulumimpl);
	public SemesterImpl getSemesterimpl();
	public void setSemesterimpl(SemesterImpl semesterimpl);
	HashMap<String, Object> toHashMap();
}
