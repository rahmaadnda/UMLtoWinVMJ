package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.rencanastudi.RencanaStudiFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class RencanaStudiResourceImpl extends RencanaStudiResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/save")
    public List<HashMap<String,Object>> saveRencanaStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		RencanaStudi rencanastudi = createRencanaStudi(vmjExchange);
		rencanastudiRepository.saveObject(rencanastudi);
		return getAllRencanaStudi(vmjExchange);
	}

    public RencanaStudi createRencanaStudi(VMJExchange vmjExchange){
		String totalSKSStr = (String) vmjExchange.getRequestBodyForm("totalSKS");
		int totalSKS = Integer.parseInt(totalSKSStr);
		String status = (String) vmjExchange.getRequestBodyForm("status");
		
		//to do: fix association attributes
		
		RencanaStudi rencanastudi = RencanaStudiFactory.createRencanaStudi("siakreborn.rencanastudi.core.RencanaStudiImpl", id, mahasiswaimpl, semesterimpl, totalSKS, status);
			return rencanastudi;
	}

    public RencanaStudi createRencanaStudi(VMJExchange vmjExchange, int id){
		String totalSKSStr = (String) vmjExchange.getRequestBodyForm("totalSKS");
		int totalSKS = Integer.parseInt(totalSKSStr);
		String status = (String) vmjExchange.getRequestBodyForm("status");
		
		//to do: fix association attributes
		
		RencanaStudi rencanastudi = RencanaStudiFactory.createRencanaStudi("siakreborn.rencanastudi.core.RencanaStudiImpl", , mahasiswaimpl, semesterimpl, totalSKS, status);
			return rencanastudi;
	}

    // @Restriced(permission = "")
    @Route(url="call/rencanastudi/update")
    public HashMap<String, Object> updateRencanaStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		RencanaStudi rencanastudi = rencanastudiRepository.getObject(id);
		String totalSKSStr = (String) vmjExchange.getRequestBodyForm("totalSKS");
		rencanastudi.setTotalSKS(Integer.parseInt(totalSKSStr));
		rencanastudi.setStatus((String) vmjExchange.getRequestBodyForm("status"));
		
		rencanastudiRepository.updateObject(rencanastudi);
		rencanastudi = rencanastudiRepository.getObject(id);
		//to do: fix association attributes
		
		return rencanastudi.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/detail")
    public HashMap<String, Object> getRencanaStudi(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		RencanaStudi rencanastudi = rencanastudiRepository.getObject(id);
		return rencanastudi.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/list")
    public List<HashMap<String,Object>> getAllRencanaStudi(VMJExchange vmjExchange){
		List<RencanaStudi> rencanastudiList = rencanastudiRepository.getAllObject("rencanastudi_impl");
		return transformRencanaStudiListToHashMap(rencanastudiList);
	}

    public List<HashMap<String,Object>> transformRencanaStudiListToHashMap(List<RencanaStudi> rencanastudiList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < rencanastudiList.size(); i++) {
            resultList.add(rencanastudiList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/delete")
    public List<HashMap<String,Object>> deleteRencanaStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		rencanastudiRepository.deleteObject(id);
		return getAllRencanaStudi(vmjExchange);
	}

	public void cekPembayaran() {
		// TODO: implement this method
	}
}
