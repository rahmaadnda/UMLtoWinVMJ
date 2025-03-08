package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class RencanaStudiResourceComponent implements RencanaStudiResource{
	protected RepositoryUtil<RencanaStudi> rencanastudiRepository;

    public RencanaStudiResourceComponent(){
        this.rencanastudiRepository = new RepositoryUtil<RencanaStudi>(siakreborn.rencanastudi.core.RencanaStudiComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveRencanaStudi(VMJExchange vmjExchange);
    public abstract RencanaStudi createRencanaStudi(VMJExchange vmjExchange);
	public abstract RencanaStudi createRencanaStudi(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateRencanaStudi(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getRencanaStudi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllRencanaStudi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformRencanaStudiListToHashMap(List<RencanaStudi> RencanaStudiList);
    public abstract List<HashMap<String,Object>> deleteRencanaStudi(VMJExchange vmjExchange);

	public abstract void cekPembayaran();
}
