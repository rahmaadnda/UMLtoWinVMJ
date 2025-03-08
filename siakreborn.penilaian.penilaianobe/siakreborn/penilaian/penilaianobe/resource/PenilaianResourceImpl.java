package siakreborn.penilaian.penilaianobe;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import siakreborn.penilaian.core.PenilaianResourceDecorator;
import siakreborn.penilaian.core.PenilaianImpl;
import siakreborn.penilaian.core.PenilaianResourceComponent;

public class PenilaianResourceImpl extends PenilaianResourceDecorator {
    public PenilaianResourceImpl (PenilaianResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/penilaianobe/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Penilaian create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.penilaianobe.core.PenilaianImpl", , bobotkomponenpenilaianimpl, komponenpenilaianimpl);
			return deco;
	}

    public Penilaian create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.penilaianobe.core.PenilaianImpl", id, , bobotkomponenpenilaianimpl, komponenpenilaianimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/penilaianobe/update")
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
    @Route(url="call/penilaianobe/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getPenilaian(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/penilaianobe/list")
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
    @Route(url="call/penilaianobe/delete")
    public List<HashMap<String,Object>> deletePenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public void getLaporanCPLKurikulum() {
		// TODO: implement this method
	}

	public void getLaporanCPLMahasiswa() {
		// TODO: implement this method
	}

	public void getLaporanCPMK() {
		// TODO: implement this method
	}
}
