package siakreborn.komponenpenilaian.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KomponenPenilaianResourceComponent implements KomponenPenilaianResource{
	protected RepositoryUtil<KomponenPenilaian> komponenpenilaianRepository;

    public KomponenPenilaianResourceComponent(){
        this.komponenpenilaianRepository = new RepositoryUtil<KomponenPenilaian>(siakreborn.komponenpenilaian.core.KomponenPenilaianComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveKomponenPenilaian(VMJExchange vmjExchange);
    public abstract KomponenPenilaian createKomponenPenilaian(VMJExchange vmjExchange);
	public abstract KomponenPenilaian createKomponenPenilaian(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateKomponenPenilaian(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getKomponenPenilaian(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllKomponenPenilaian(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformKomponenPenilaianListToHashMap(List<KomponenPenilaian> KomponenPenilaianList);
    public abstract List<HashMap<String,Object>> deleteKomponenPenilaian(VMJExchange vmjExchange);

}
