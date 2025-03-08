package siakreborn.informasi.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InformasiResourceComponent implements InformasiResource{
	protected RepositoryUtil<Informasi> informasiRepository;

    public InformasiResourceComponent(){
        this.informasiRepository = new RepositoryUtil<Informasi>(siakreborn.informasi.core.InformasiComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveInformasi(VMJExchange vmjExchange);
    public abstract Informasi createInformasi(VMJExchange vmjExchange);
	public abstract Informasi createInformasi(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateInformasi(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getInformasi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllInformasi(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformInformasiListToHashMap(List<Informasi> InformasiList);
    public abstract List<HashMap<String,Object>> deleteInformasi(VMJExchange vmjExchange);

}
