package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.rencanastudi.PengisianRencanaStudiFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PengisianRencanaStudiResourceImpl extends PengisianRencanaStudiResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/save")
    public List<HashMap<String,Object>> savePengisianRencanaStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		PengisianRencanaStudi pengisianrencanastudi = createPengisianRencanaStudi(vmjExchange);
		pengisianrencanastudiRepository.saveObject(pengisianrencanastudi);
		return getAllPengisianRencanaStudi(vmjExchange);
	}

    public PengisianRencanaStudi createPengisianRencanaStudi(VMJExchange vmjExchange){
		
		//to do: fix association attributes
		
		PengisianRencanaStudi pengisianrencanastudi = PengisianRencanaStudiFactory.createPengisianRencanaStudi("siakreborn.rencanastudi.core.PengisianRencanaStudiImpl", mulai, akhir, id, semesterimpl);
			return pengisianrencanastudi;
	}

    public PengisianRencanaStudi createPengisianRencanaStudi(VMJExchange vmjExchange, int id){
		
		//to do: fix association attributes
		
		PengisianRencanaStudi pengisianrencanastudi = PengisianRencanaStudiFactory.createPengisianRencanaStudi("siakreborn.rencanastudi.core.PengisianRencanaStudiImpl", mulai, akhir, , semesterimpl);
			return pengisianrencanastudi;
	}

    // @Restriced(permission = "")
    @Route(url="call/rencanastudi/update")
    public HashMap<String, Object> updatePengisianRencanaStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		PengisianRencanaStudi pengisianrencanastudi = pengisianrencanastudiRepository.getObject(id);
		
		pengisianrencanastudiRepository.updateObject(pengisianrencanastudi);
		pengisianrencanastudi = pengisianrencanastudiRepository.getObject(id);
		//to do: fix association attributes
		
		return pengisianrencanastudi.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/detail")
    public HashMap<String, Object> getPengisianRencanaStudi(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		PengisianRencanaStudi pengisianrencanastudi = pengisianrencanastudiRepository.getObject(id);
		return pengisianrencanastudi.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/list")
    public List<HashMap<String,Object>> getAllPengisianRencanaStudi(VMJExchange vmjExchange){
		List<PengisianRencanaStudi> pengisianrencanastudiList = pengisianrencanastudiRepository.getAllObject("pengisianrencanastudi_impl");
		return transformPengisianRencanaStudiListToHashMap(pengisianrencanastudiList);
	}

    public List<HashMap<String,Object>> transformPengisianRencanaStudiListToHashMap(List<PengisianRencanaStudi> pengisianrencanastudiList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < pengisianrencanastudiList.size(); i++) {
            resultList.add(pengisianrencanastudiList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/delete")
    public List<HashMap<String,Object>> deletePengisianRencanaStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		pengisianrencanastudiRepository.deleteObject(id);
		return getAllPengisianRencanaStudi(vmjExchange);
	}

}
