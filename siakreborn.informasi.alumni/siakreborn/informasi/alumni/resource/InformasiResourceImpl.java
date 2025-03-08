package siakreborn.informasi.alumni;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import siakreborn.informasi.core.InformasiResourceDecorator;
import siakreborn.informasi.core.InformasiImpl;
import siakreborn.informasi.core.InformasiResourceComponent;

public class InformasiResourceImpl extends InformasiResourceDecorator {
    public InformasiResourceImpl (InformasiResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/alumni/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Informasi create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.alumni.core.InformasiImpl", , observerimpl);
			return deco;
	}

    public Informasi create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.alumni.core.InformasiImpl", id, , observerimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/alumni/update")
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
    @Route(url="call/alumni/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getInformasi(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/alumni/list")
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
    @Route(url="call/alumni/delete")
    public List<HashMap<String,Object>> deleteInformasi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
