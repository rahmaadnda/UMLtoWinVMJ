package siakreborn.mahasiswa.mappingalumni;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import siakreborn.mahasiswa.core.MahasiswaResourceDecorator;
import siakreborn.mahasiswa.core.MahasiswaImpl;
import siakreborn.mahasiswa.core.MahasiswaResourceComponent;

public class MahasiswaResourceImpl extends MahasiswaResourceDecorator {
    public MahasiswaResourceImpl (MahasiswaResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/mappingalumni/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Mahasiswa create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.mappingalumni.core.MahasiswaImpl", , );
			return deco;
	}

    public Mahasiswa create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.mappingalumni.core.MahasiswaImpl", id, , );
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/mappingalumni/update")
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
    @Route(url="call/mappingalumni/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getMahasiswa(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/mappingalumni/list")
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
    @Route(url="call/mappingalumni/delete")
    public List<HashMap<String,Object>> deleteMahasiswa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public HashMap<String, Object> graduate(VMJExchange vmjExchange) {
		// TODO: implement this method
	}
}
