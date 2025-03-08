package siakreborn.kurikulumsemester.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KurikulumSemesterResourceComponent implements KurikulumSemesterResource{
	protected RepositoryUtil<KurikulumSemester> kurikulumsemesterRepository;

    public KurikulumSemesterResourceComponent(){
        this.kurikulumsemesterRepository = new RepositoryUtil<KurikulumSemester>(siakreborn.kurikulumsemester.core.KurikulumSemesterComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveKurikulumSemester(VMJExchange vmjExchange);
    public abstract KurikulumSemester createKurikulumSemester(VMJExchange vmjExchange);
	public abstract KurikulumSemester createKurikulumSemester(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateKurikulumSemester(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getKurikulumSemester(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllKurikulumSemester(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformKurikulumSemesterListToHashMap(List<KurikulumSemester> KurikulumSemesterList);
    public abstract List<HashMap<String,Object>> deleteKurikulumSemester(VMJExchange vmjExchange);

}
