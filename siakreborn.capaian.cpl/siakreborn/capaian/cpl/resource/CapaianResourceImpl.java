package siakreborn.capaian.cpl;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import siakreborn.capaian.core.CapaianResourceDecorator;
import siakreborn.capaian.core.CapaianImpl;
import siakreborn.capaian.core.CapaianResourceComponent;

public class CapaianResourceImpl extends CapaianResourceDecorator {
    public CapaianResourceImpl (CapaianResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/cpl/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Capaian create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.cpl.core.CapaianImpl", , kurikulumimpl);
			return deco;
	}

    public Capaian create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.cpl.core.CapaianImpl", id, , kurikulumimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/cpl/update")
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
    @Route(url="call/cpl/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getCapaian(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/cpl/list")
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
    @Route(url="call/cpl/delete")
    public List<HashMap<String,Object>> deleteCapaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
