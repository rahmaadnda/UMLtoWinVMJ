package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PengisianRencanaStudiResourceDecorator extends PengisianRencanaStudiResourceComponent{
	protected PengisianRencanaStudiResourceComponent record;

    public PengisianRencanaStudiResourceDecorator(PengisianRencanaStudiResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> savePengisianRencanaStudi(VMJExchange vmjExchange){
		return record.savePengisianRencanaStudi(vmjExchange);
	}

    public PengisianRencanaStudi createPengisianRencanaStudi(VMJExchange vmjExchange){
		return record.createPengisianRencanaStudi(vmjExchange);
	}

    public PengisianRencanaStudi createPengisianRencanaStudi(VMJExchange vmjExchange, int id){
		return record.createPengisianRencanaStudi(vmjExchange, id);
	}

    public HashMap<String, Object> updatePengisianRencanaStudi(VMJExchange vmjExchange){
		return record.updatePengisianRencanaStudi(vmjExchange);
	}

    public HashMap<String, Object> getPengisianRencanaStudi(VMJExchange vmjExchange){
		return record.getPengisianRencanaStudi(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPengisianRencanaStudi(VMJExchange vmjExchange){
		return record.getAllPengisianRencanaStudi(vmjExchange);
	}

    public List<HashMap<String,Object>> transformPengisianRencanaStudiListToHashMap(List<PengisianRencanaStudi> pengisianrencanastudiList){
		return record.transformPengisianRencanaStudiListToHashMap(pengisianrencanastudiList);
	}

    public List<HashMap<String,Object>> deletePengisianRencanaStudi(VMJExchange vmjExchange){
		return record.deletePengisianRencanaStudi(vmjExchange);
	}

}
