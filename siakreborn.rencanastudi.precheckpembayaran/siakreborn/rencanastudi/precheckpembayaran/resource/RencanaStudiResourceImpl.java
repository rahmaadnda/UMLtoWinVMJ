package siakreborn.rencanastudi.precheckpembayaran;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import siakreborn.rencanastudi.core.RencanaStudiResourceDecorator;
import siakreborn.rencanastudi.core.RencanaStudiImpl;
import siakreborn.rencanastudi.core.RencanaStudiResourceComponent;

public class RencanaStudiResourceImpl extends RencanaStudiResourceDecorator {
    public RencanaStudiResourceImpl (RencanaStudiResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/precheckpembayaran/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public RencanaStudi create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.precheckpembayaran.core.RencanaStudiImpl", , );
			return deco;
	}

    public RencanaStudi create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.precheckpembayaran.core.RencanaStudiImpl", id, , );
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/precheckpembayaran/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/precheckpembayaran/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getRencanaStudi(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/precheckpembayaran/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/precheckpembayaran/delete")
    public List<HashMap<String,Object>> deleteRencanaStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void cekPembayaran() {
		// TODO: implement this method
	}
}
