package siakreborn.kelas.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KelasResourceDecorator extends KelasResourceComponent{
	protected KelasResourceComponent record;

    public KelasResourceDecorator(KelasResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveKelas(VMJExchange vmjExchange){
		return record.saveKelas(vmjExchange);
	}

    public Kelas createKelas(VMJExchange vmjExchange){
		return record.createKelas(vmjExchange);
	}

    public Kelas createKelas(VMJExchange vmjExchange, int id){
		return record.createKelas(vmjExchange, id);
	}

    public HashMap<String, Object> updateKelas(VMJExchange vmjExchange){
		return record.updateKelas(vmjExchange);
	}

    public HashMap<String, Object> getKelas(VMJExchange vmjExchange){
		return record.getKelas(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllKelas(VMJExchange vmjExchange){
		return record.getAllKelas(vmjExchange);
	}

    public List<HashMap<String,Object>> transformKelasListToHashMap(List<Kelas> kelasList){
		return record.transformKelasListToHashMap(kelasList);
	}

    public List<HashMap<String,Object>> deleteKelas(VMJExchange vmjExchange){
		return record.deleteKelas(vmjExchange);
	}

}
