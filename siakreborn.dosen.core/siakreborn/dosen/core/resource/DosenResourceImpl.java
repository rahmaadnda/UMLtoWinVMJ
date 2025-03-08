package siakreborn.dosen.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.dosen.DosenFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class DosenResourceImpl extends DosenResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/dosen/save")
    public List<HashMap<String,Object>> saveDosen(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Dosen dosen = createDosen(vmjExchange);
		dosenRepository.saveObject(dosen);
		return getAllDosen(vmjExchange);
	}

    public Dosen createDosen(VMJExchange vmjExchange){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String nip = (String) vmjExchange.getRequestBodyForm("nip");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		
		//to do: fix association attributes
		
		Dosen dosen = DosenFactory.createDosen("siakreborn.dosen.core.DosenImpl", id, nama, nip, email);
			return dosen;
	}

    public Dosen createDosen(VMJExchange vmjExchange, int id){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String nip = (String) vmjExchange.getRequestBodyForm("nip");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		
		//to do: fix association attributes
		
		Dosen dosen = DosenFactory.createDosen("siakreborn.dosen.core.DosenImpl", , nama, nip, email);
			return dosen;
	}

    // @Restriced(permission = "")
    @Route(url="call/dosen/update")
    public HashMap<String, Object> updateDosen(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Dosen dosen = dosenRepository.getObject(id);
		dosen.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		dosen.setNip((String) vmjExchange.getRequestBodyForm("nip"));
		dosen.setEmail((String) vmjExchange.getRequestBodyForm("email"));
		
		dosenRepository.updateObject(dosen);
		dosen = dosenRepository.getObject(id);
		//to do: fix association attributes
		
		return dosen.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/dosen/detail")
    public HashMap<String, Object> getDosen(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Dosen dosen = dosenRepository.getObject(id);
		return dosen.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/dosen/list")
    public List<HashMap<String,Object>> getAllDosen(VMJExchange vmjExchange){
		List<Dosen> dosenList = dosenRepository.getAllObject("dosen_impl");
		return transformDosenListToHashMap(dosenList);
	}

    public List<HashMap<String,Object>> transformDosenListToHashMap(List<Dosen> dosenList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < dosenList.size(); i++) {
            resultList.add(dosenList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/dosen/delete")
    public List<HashMap<String,Object>> deleteDosen(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		dosenRepository.deleteObject(id);
		return getAllDosen(vmjExchange);
	}

}
