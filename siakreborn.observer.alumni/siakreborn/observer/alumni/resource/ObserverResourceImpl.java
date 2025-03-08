package siakreborn.observer.alumni;
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
    @Route(url="call/alumni/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Observer create(VMJExchange vmjExchange){
		String portofolioUrl = (String) vmjExchange.getRequestBodyForm("portofolioUrl");
		String linkedinUrl = (String) vmjExchange.getRequestBodyForm("linkedinUrl");
		String npm = (String) vmjExchange.getRequestBodyForm("npm");
		String pekerjaan = (String) vmjExchange.getRequestBodyForm("pekerjaan");
		String tempatKerja = (String) vmjExchange.getRequestBodyForm("tempatKerja");
		String tahunLulusStr = (String) vmjExchange.getRequestBodyForm("tahunLulus");
		int tahunLulus = Integer.parseInt(tahunLulusStr);
		boolean isPublic = (boolean) vmjExchange.getRequestBodyForm("isPublic");
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.alumni.core.ObserverImpl", , portofolioUrl, linkedinUrl, npm, pekerjaan, tempatKerja, tahunLulus, isPublic, mahasiswaimpl);
			return deco;
	}

    public Observer create(VMJExchange vmjExchange, int id){
		String portofolioUrl = (String) vmjExchange.getRequestBodyForm("portofolioUrl");
		String linkedinUrl = (String) vmjExchange.getRequestBodyForm("linkedinUrl");
		String npm = (String) vmjExchange.getRequestBodyForm("npm");
		String pekerjaan = (String) vmjExchange.getRequestBodyForm("pekerjaan");
		String tempatKerja = (String) vmjExchange.getRequestBodyForm("tempatKerja");
		String tahunLulusStr = (String) vmjExchange.getRequestBodyForm("tahunLulus");
		int tahunLulus = Integer.parseInt(tahunLulusStr);
		boolean isPublic = (boolean) vmjExchange.getRequestBodyForm("isPublic");
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("siakreborn.alumni.core.ObserverImpl", id, , portofolioUrl, linkedinUrl, npm, pekerjaan, tempatKerja, tahunLulus, isPublic, mahasiswaimpl);
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
		return record.getObserver(vmjExchange);
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
    public List<HashMap<String,Object>> deleteObserver(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

	public HashMap<String, Object> verify(VMJExchange vmjExchange) {
		// TODO: implement this method
	}
}
