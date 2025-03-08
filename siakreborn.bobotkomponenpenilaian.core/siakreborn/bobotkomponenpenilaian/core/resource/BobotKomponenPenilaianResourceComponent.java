package siakreborn.bobotkomponenpenilaian.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BobotKomponenPenilaianResourceComponent implements BobotKomponenPenilaianResource{
	protected RepositoryUtil<BobotKomponenPenilaian> bobotkomponenpenilaianRepository;

    public BobotKomponenPenilaianResourceComponent(){
        this.bobotkomponenpenilaianRepository = new RepositoryUtil<BobotKomponenPenilaian>(siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveBobotKomponenPenilaian(VMJExchange vmjExchange);
    public abstract BobotKomponenPenilaian createBobotKomponenPenilaian(VMJExchange vmjExchange);
	public abstract BobotKomponenPenilaian createBobotKomponenPenilaian(VMJExchange vmjExchange, int id);    
	public abstract HashMap<String, Object> updateBobotKomponenPenilaian(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getBobotKomponenPenilaian(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBobotKomponenPenilaian(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> transformBobotKomponenPenilaianListToHashMap(List<BobotKomponenPenilaian> BobotKomponenPenilaianList);
    public abstract List<HashMap<String,Object>> deleteBobotKomponenPenilaian(VMJExchange vmjExchange);

}
