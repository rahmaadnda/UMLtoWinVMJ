package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KelasMahasiswaResourceDecorator extends KelasMahasiswaResourceComponent{
	protected KelasMahasiswaResourceComponent record;

    public KelasMahasiswaResourceDecorator(KelasMahasiswaResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveKelasMahasiswa(VMJExchange vmjExchange){
		return record.saveKelasMahasiswa(vmjExchange);
	}

    public KelasMahasiswa createKelasMahasiswa(VMJExchange vmjExchange){
		return record.createKelasMahasiswa(vmjExchange);
	}

    public KelasMahasiswa createKelasMahasiswa(VMJExchange vmjExchange, int id){
		return record.createKelasMahasiswa(vmjExchange, id);
	}

    public HashMap<String, Object> updateKelasMahasiswa(VMJExchange vmjExchange){
		return record.updateKelasMahasiswa(vmjExchange);
	}

    public HashMap<String, Object> getKelasMahasiswa(VMJExchange vmjExchange){
		return record.getKelasMahasiswa(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllKelasMahasiswa(VMJExchange vmjExchange){
		return record.getAllKelasMahasiswa(vmjExchange);
	}

    public List<HashMap<String,Object>> transformKelasMahasiswaListToHashMap(List<KelasMahasiswa> kelasmahasiswaList){
		return record.transformKelasMahasiswaListToHashMap(kelasmahasiswaList);
	}

    public List<HashMap<String,Object>> deleteKelasMahasiswa(VMJExchange vmjExchange){
		return record.deleteKelasMahasiswa(vmjExchange);
	}

}
