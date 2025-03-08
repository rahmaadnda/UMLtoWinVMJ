package siakreborn.kelasdosen.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KelasDosenResourceComponent implements KelasDosenResource{
	protected RepositoryUtil<KelasDosen> kelasdosenRepository;

    public KelasDosenResourceComponent(){
        this.kelasdosenRepository = new RepositoryUtil<KelasDosen>(siakreborn.kelasdosen.core.KelasDosenComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveKelasDosen(VMJExchange vmjExchange);
    public abstract KelasDosen createKelasDosen(VMJExchange vmjExchange);
	public abstract KelasDosen createKelasDosen(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateKelasDosen(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getKelasDosen(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllKelasDosen(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformKelasDosenListToHashMap(List<KelasDosen> KelasDosenList);
    public abstract List<HashMap<String,Object>> deleteKelasDosen(VMJExchange vmjExchange);

}
