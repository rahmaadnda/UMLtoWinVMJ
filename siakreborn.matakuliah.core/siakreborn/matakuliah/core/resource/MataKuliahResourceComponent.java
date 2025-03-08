package siakreborn.matakuliah.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class MataKuliahResourceComponent implements MataKuliahResource{
	protected RepositoryUtil<MataKuliah> matakuliahRepository;

    public MataKuliahResourceComponent(){
        this.matakuliahRepository = new RepositoryUtil<MataKuliah>(siakreborn.matakuliah.core.MataKuliahComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveMataKuliah(VMJExchange vmjExchange);
    public abstract MataKuliah createMataKuliah(VMJExchange vmjExchange);
	public abstract MataKuliah createMataKuliah(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateMataKuliah(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getMataKuliah(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllMataKuliah(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformMataKuliahListToHashMap(List<MataKuliah> MataKuliahList);
    public abstract List<HashMap<String,Object>> deleteMataKuliah(VMJExchange vmjExchange);

}
