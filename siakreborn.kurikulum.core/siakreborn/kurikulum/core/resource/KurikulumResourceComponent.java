package siakreborn.kurikulum.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KurikulumResourceComponent implements KurikulumResource{
	protected RepositoryUtil<Kurikulum> kurikulumRepository;

    public KurikulumResourceComponent(){
        this.kurikulumRepository = new RepositoryUtil<Kurikulum>(siakreborn.kurikulum.core.KurikulumComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveKurikulum(VMJExchange vmjExchange);
    public abstract Kurikulum createKurikulum(VMJExchange vmjExchange);
	public abstract Kurikulum createKurikulum(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateKurikulum(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getKurikulum(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllKurikulum(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformKurikulumListToHashMap(List<Kurikulum> KurikulumList);
    public abstract List<HashMap<String,Object>> deleteKurikulum(VMJExchange vmjExchange);

}
