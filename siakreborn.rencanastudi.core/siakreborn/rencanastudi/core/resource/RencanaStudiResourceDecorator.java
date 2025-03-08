package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class RencanaStudiResourceDecorator extends RencanaStudiResourceComponent{
	protected RencanaStudiResourceComponent record;

    public RencanaStudiResourceDecorator(RencanaStudiResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveRencanaStudi(VMJExchange vmjExchange){
		return record.saveRencanaStudi(vmjExchange);
	}

    public RencanaStudi createRencanaStudi(VMJExchange vmjExchange){
		return record.createRencanaStudi(vmjExchange);
	}

    public RencanaStudi createRencanaStudi(VMJExchange vmjExchange, int id){
		return record.createRencanaStudi(vmjExchange, id);
	}

    public HashMap<String, Object> updateRencanaStudi(VMJExchange vmjExchange){
		return record.updateRencanaStudi(vmjExchange);
	}

    public HashMap<String, Object> getRencanaStudi(VMJExchange vmjExchange){
		return record.getRencanaStudi(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllRencanaStudi(VMJExchange vmjExchange){
		return record.getAllRencanaStudi(vmjExchange);
	}

    public List<HashMap<String,Object>> transformRencanaStudiListToHashMap(List<RencanaStudi> rencanastudiList){
		return record.transformRencanaStudiListToHashMap(rencanastudiList);
	}

    public List<HashMap<String,Object>> deleteRencanaStudi(VMJExchange vmjExchange){
		return record.deleteRencanaStudi(vmjExchange);
	}

	public void cekPembayaran() {
		return record.cekPembayaran();
	}
}
