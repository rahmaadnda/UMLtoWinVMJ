package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PengisianRencanaStudiResourceComponent implements PengisianRencanaStudiResource{
	protected RepositoryUtil<PengisianRencanaStudi> pengisianrencanastudiRepository;

    public PengisianRencanaStudiResourceComponent(){
        this.pengisianrencanastudiRepository = new RepositoryUtil<PengisianRencanaStudi>(siakreborn.rencanastudi.core.PengisianRencanaStudiComponent.class);
    }	

    public abstract List<HashMap<String,Object>> savePengisianRencanaStudi(VMJExchange vmjExchange);
    public abstract PengisianRencanaStudi createPengisianRencanaStudi(VMJExchange vmjExchange);
	public abstract PengisianRencanaStudi createPengisianRencanaStudi(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updatePengisianRencanaStudi(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getPengisianRencanaStudi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPengisianRencanaStudi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformPengisianRencanaStudiListToHashMap(List<PengisianRencanaStudi> PengisianRencanaStudiList);
    public abstract List<HashMap<String,Object>> deletePengisianRencanaStudi(VMJExchange vmjExchange);

}
