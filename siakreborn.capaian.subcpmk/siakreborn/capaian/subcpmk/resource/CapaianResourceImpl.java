package siakreborn.capaian.subcpmk;
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
    @Route(url="call/subcpmk/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Capaian create(VMJExchange vmjExchange){
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		int bobot = Integer.parseInt(bobotStr);
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.subcpmk.core.CapaianImpl", , bobot);
			return deco;
	}

    public Capaian create(VMJExchange vmjExchange, int id){
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		int bobot = Integer.parseInt(bobotStr);
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.subcpmk.core.CapaianImpl", id, , bobot);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/subcpmk/update")
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
    @Route(url="call/subcpmk/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getCapaian(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/subcpmk/list")
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
    @Route(url="call/subcpmk/delete")
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
