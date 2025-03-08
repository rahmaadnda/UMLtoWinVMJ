package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class KelasMahasiswaResourceComponent implements KelasMahasiswaResource{
	protected RepositoryUtil<KelasMahasiswa> kelasmahasiswaRepository;

    public KelasMahasiswaResourceComponent(){
        this.kelasmahasiswaRepository = new RepositoryUtil<KelasMahasiswa>(siakreborn.rencanastudi.core.KelasMahasiswaComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveKelasMahasiswa(VMJExchange vmjExchange);
    public abstract KelasMahasiswa createKelasMahasiswa(VMJExchange vmjExchange);
	public abstract KelasMahasiswa createKelasMahasiswa(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateKelasMahasiswa(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getKelasMahasiswa(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllKelasMahasiswa(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformKelasMahasiswaListToHashMap(List<KelasMahasiswa> KelasMahasiswaList);
    public abstract List<HashMap<String,Object>> deleteKelasMahasiswa(VMJExchange vmjExchange);

}
