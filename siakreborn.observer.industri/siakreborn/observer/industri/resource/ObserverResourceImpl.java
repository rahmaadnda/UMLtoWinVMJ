package siakreborn.observer.industri;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import siakreborn.observer.core.ObserverResourceDecorator;
import siakreborn.observer.core.ObserverImpl;
import siakreborn.observer.core.ObserverResourceComponent;

public class ObserverResourceImpl extends ObserverResourceDecorator {
    public ObserverResourceImpl (ObserverResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/industri/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Observer create(VMJExchange vmjExchange){
		String websiteUrl = (String) vmjExchange.getRequestBodyForm("websiteUrl");
		String domain = (String) vmjExchange.getRequestBodyForm("domain");
		String alamat = (String) vmjExchange.getRequestBodyForm("alamat");
		String tahunBerdiriStr = (String) vmjExchange.getRequestBodyForm("tahunBerdiri");
		int tahunBerdiri = Integer.parseInt(tahunBerdiriStr);
		String jumlahKaryawanStr = (String) vmjExchange.getRequestBodyForm("jumlahKaryawan");
		int jumlahKaryawan = Integer.parseInt(jumlahKaryawanStr);
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.industri.core.ObserverImpl", , websiteUrl, domain, alamat, tahunBerdiri, jumlahKaryawan, subscriptionimpl);
			return deco;
	}

    public Observer create(VMJExchange vmjExchange, int id){
		String websiteUrl = (String) vmjExchange.getRequestBodyForm("websiteUrl");
		String domain = (String) vmjExchange.getRequestBodyForm("domain");
		String alamat = (String) vmjExchange.getRequestBodyForm("alamat");
		String tahunBerdiriStr = (String) vmjExchange.getRequestBodyForm("tahunBerdiri");
		int tahunBerdiri = Integer.parseInt(tahunBerdiriStr);
		String jumlahKaryawanStr = (String) vmjExchange.getRequestBodyForm("jumlahKaryawan");
		int jumlahKaryawan = Integer.parseInt(jumlahKaryawanStr);
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.industri.core.ObserverImpl", id, , websiteUrl, domain, alamat, tahunBerdiri, jumlahKaryawan, subscriptionimpl);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/industri/update")
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
    @Route(url="call/industri/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getObserver(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/industri/list")
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
    @Route(url="call/industri/delete")
    public List<HashMap<String,Object>> deleteObserver(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public HashMap<String, Object> subscriptionRequest(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

	public HashMap<String, Object> subscriptionApprove(VMJExchange vmjExchange) {
		// TODO: implement this method
	}
}
