package siakreborn.kelasdosen.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kelasdosen.KelasDosenFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KelasDosenResourceImpl extends KelasDosenResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/kelasdosen/save")
    public List<HashMap<String,Object>> saveKelasDosen(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KelasDosen kelasdosen = createKelasDosen(vmjExchange);
		kelasdosenRepository.saveObject(kelasdosen);
		return getAllKelasDosen(vmjExchange);
	}

    public KelasDosen createKelasDosen(VMJExchange vmjExchange){
		
		//to do: fix association attributes
		
		KelasDosen kelasdosen = KelasDosenFactory.createKelasDosen("siakreborn.kelasdosen.core.KelasDosenImpl", id, dosenimpl, kelasimpl);
			return kelasdosen;
	}

    public KelasDosen createKelasDosen(VMJExchange vmjExchange, int id){
		
		//to do: fix association attributes
		
		KelasDosen kelasdosen = KelasDosenFactory.createKelasDosen("siakreborn.kelasdosen.core.KelasDosenImpl", , dosenimpl, kelasimpl);
			return kelasdosen;
	}

    // @Restriced(permission = "")
    @Route(url="call/kelasdosen/update")
    public HashMap<String, Object> updateKelasDosen(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		KelasDosen kelasdosen = kelasdosenRepository.getObject(id);
		
		kelasdosenRepository.updateObject(kelasdosen);
		kelasdosen = kelasdosenRepository.getObject(id);
		//to do: fix association attributes
		
		return kelasdosen.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/kelasdosen/detail")
    public HashMap<String, Object> getKelasDosen(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		KelasDosen kelasdosen = kelasdosenRepository.getObject(id);
		return kelasdosen.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/kelasdosen/list")
    public List<HashMap<String,Object>> getAllKelasDosen(VMJExchange vmjExchange){
		List<KelasDosen> kelasdosenList = kelasdosenRepository.getAllObject("kelasdosen_impl");
		return transformKelasDosenListToHashMap(kelasdosenList);
	}

    public List<HashMap<String,Object>> transformKelasDosenListToHashMap(List<KelasDosen> kelasdosenList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < kelasdosenList.size(); i++) {
            resultList.add(kelasdosenList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/kelasdosen/delete")
    public List<HashMap<String,Object>> deleteKelasDosen(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		kelasdosenRepository.deleteObject(id);
		return getAllKelasDosen(vmjExchange);
	}

}
