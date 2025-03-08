package siakreborn.penilaian.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.penilaian.PenilaianFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class PenilaianResourceImpl extends PenilaianResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/penilaian/save")
    public List<HashMap<String,Object>> savePenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Penilaian penilaian = createPenilaian(vmjExchange);
		penilaianRepository.saveObject(penilaian);
		return getAllPenilaian(vmjExchange);
	}

    public Penilaian createPenilaian(VMJExchange vmjExchange){
		String nilaiStr = (String) vmjExchange.getRequestBodyForm("nilai");
		int nilai = Integer.parseInt(nilaiStr);
		
		//to do: fix association attributes
		
		Penilaian penilaian = PenilaianFactory.createPenilaian("siakreborn.penilaian.core.PenilaianImpl", id, nilai, mahasiswaimpl, komponenpenilaianimpl);
			return penilaian;
	}

    public Penilaian createPenilaian(VMJExchange vmjExchange, int id){
		String nilaiStr = (String) vmjExchange.getRequestBodyForm("nilai");
		int nilai = Integer.parseInt(nilaiStr);
		
		//to do: fix association attributes
		
		Penilaian penilaian = PenilaianFactory.createPenilaian("siakreborn.penilaian.core.PenilaianImpl", , nilai, mahasiswaimpl, komponenpenilaianimpl);
			return penilaian;
	}

    // @Restriced(permission = "")
    @Route(url="call/penilaian/update")
    public HashMap<String, Object> updatePenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Penilaian penilaian = penilaianRepository.getObject(id);
		String nilaiStr = (String) vmjExchange.getRequestBodyForm("nilai");
		penilaian.setNilai(Integer.parseInt(nilaiStr));
		
		penilaianRepository.updateObject(penilaian);
		penilaian = penilaianRepository.getObject(id);
		//to do: fix association attributes
		
		return penilaian.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/penilaian/detail")
    public HashMap<String, Object> getPenilaian(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Penilaian penilaian = penilaianRepository.getObject(id);
		return penilaian.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/penilaian/list")
    public List<HashMap<String,Object>> getAllPenilaian(VMJExchange vmjExchange){
		List<Penilaian> penilaianList = penilaianRepository.getAllObject("penilaian_impl");
		return transformPenilaianListToHashMap(penilaianList);
	}

    public List<HashMap<String,Object>> transformPenilaianListToHashMap(List<Penilaian> penilaianList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < penilaianList.size(); i++) {
            resultList.add(penilaianList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/penilaian/delete")
    public List<HashMap<String,Object>> deletePenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		penilaianRepository.deleteObject(id);
		return getAllPenilaian(vmjExchange);
	}

}
