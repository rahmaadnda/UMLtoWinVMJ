package siakreborn.kelasdosen.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KelasDosenResourceDecorator extends KelasDosenResourceComponent{
	protected KelasDosenResourceComponent record;

    public KelasDosenResourceDecorator(KelasDosenResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveKelasDosen(VMJExchange vmjExchange){
		return record.saveKelasDosen(vmjExchange);
	}

    public KelasDosen createKelasDosen(VMJExchange vmjExchange){
		return record.createKelasDosen(vmjExchange);
	}

    public KelasDosen createKelasDosen(VMJExchange vmjExchange, int id){
		return record.createKelasDosen(vmjExchange, id);
	}

    public HashMap<String, Object> updateKelasDosen(VMJExchange vmjExchange){
		return record.updateKelasDosen(vmjExchange);
	}

    public HashMap<String, Object> getKelasDosen(VMJExchange vmjExchange){
		return record.getKelasDosen(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllKelasDosen(VMJExchange vmjExchange){
		return record.getAllKelasDosen(vmjExchange);
	}

    public List<HashMap<String,Object>> transformKelasDosenListToHashMap(List<KelasDosen> kelasdosenList){
		return record.transformKelasDosenListToHashMap(kelasdosenList);
	}

    public List<HashMap<String,Object>> deleteKelasDosen(VMJExchange vmjExchange){
		return record.deleteKelasDosen(vmjExchange);
	}

}
