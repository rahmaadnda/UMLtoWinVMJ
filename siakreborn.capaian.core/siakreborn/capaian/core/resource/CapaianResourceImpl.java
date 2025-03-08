package siakreborn.capaian.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.capaian.CapaianFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class CapaianResourceImpl extends CapaianResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/capaian/save")
    public List<HashMap<String,Object>> saveCapaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Capaian capaian = createCapaian(vmjExchange);
		capaianRepository.saveObject(capaian);
		return getAllCapaian(vmjExchange);
	}

    public Capaian createCapaian(VMJExchange vmjExchange){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		
		//to do: fix association attributes
		
		Capaian capaian = CapaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", id, kode, deskripsi);
			return capaian;
	}

    public Capaian createCapaian(VMJExchange vmjExchange, int id){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		
		//to do: fix association attributes
		
		Capaian capaian = CapaianFactory.createCapaian("siakreborn.capaian.core.CapaianImpl", , kode, deskripsi);
			return capaian;
	}

    // @Restriced(permission = "")
    @Route(url="call/capaian/update")
    public HashMap<String, Object> updateCapaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Capaian capaian = capaianRepository.getObject(id);
		capaian.setKode((String) vmjExchange.getRequestBodyForm("kode"));
		capaian.setDeskripsi((String) vmjExchange.getRequestBodyForm("deskripsi"));
		
		capaianRepository.updateObject(capaian);
		capaian = capaianRepository.getObject(id);
		//to do: fix association attributes
		
		return capaian.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/capaian/detail")
    public HashMap<String, Object> getCapaian(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Capaian capaian = capaianRepository.getObject(id);
		return capaian.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/capaian/list")
    public List<HashMap<String,Object>> getAllCapaian(VMJExchange vmjExchange){
		List<Capaian> capaianList = capaianRepository.getAllObject("capaian_impl");
		return transformCapaianListToHashMap(capaianList);
	}

    public List<HashMap<String,Object>> transformCapaianListToHashMap(List<Capaian> capaianList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < capaianList.size(); i++) {
            resultList.add(capaianList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/capaian/delete")
    public List<HashMap<String,Object>> deleteCapaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		capaianRepository.deleteObject(id);
		return getAllCapaian(vmjExchange);
	}

}
