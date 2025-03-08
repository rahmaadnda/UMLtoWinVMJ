package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.rencanastudi.KelasMahasiswaFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KelasMahasiswaResourceImpl extends KelasMahasiswaResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/save")
    public List<HashMap<String,Object>> saveKelasMahasiswa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KelasMahasiswa kelasmahasiswa = createKelasMahasiswa(vmjExchange);
		kelasmahasiswaRepository.saveObject(kelasmahasiswa);
		return getAllKelasMahasiswa(vmjExchange);
	}

    public KelasMahasiswa createKelasMahasiswa(VMJExchange vmjExchange){
		
		//to do: fix association attributes
		
		KelasMahasiswa kelasmahasiswa = KelasMahasiswaFactory.createKelasMahasiswa("siakreborn.rencanastudi.core.KelasMahasiswaImpl", id, kelasimpl, rencanastudi, tanggalPengisian);
			return kelasmahasiswa;
	}

    public KelasMahasiswa createKelasMahasiswa(VMJExchange vmjExchange, int id){
		
		//to do: fix association attributes
		
		KelasMahasiswa kelasmahasiswa = KelasMahasiswaFactory.createKelasMahasiswa("siakreborn.rencanastudi.core.KelasMahasiswaImpl", , kelasimpl, rencanastudi, tanggalPengisian);
			return kelasmahasiswa;
	}

    // @Restriced(permission = "")
    @Route(url="call/rencanastudi/update")
    public HashMap<String, Object> updateKelasMahasiswa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		KelasMahasiswa kelasmahasiswa = kelasmahasiswaRepository.getObject(id);
		
		kelasmahasiswaRepository.updateObject(kelasmahasiswa);
		kelasmahasiswa = kelasmahasiswaRepository.getObject(id);
		//to do: fix association attributes
		
		return kelasmahasiswa.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/detail")
    public HashMap<String, Object> getKelasMahasiswa(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		KelasMahasiswa kelasmahasiswa = kelasmahasiswaRepository.getObject(id);
		return kelasmahasiswa.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/list")
    public List<HashMap<String,Object>> getAllKelasMahasiswa(VMJExchange vmjExchange){
		List<KelasMahasiswa> kelasmahasiswaList = kelasmahasiswaRepository.getAllObject("kelasmahasiswa_impl");
		return transformKelasMahasiswaListToHashMap(kelasmahasiswaList);
	}

    public List<HashMap<String,Object>> transformKelasMahasiswaListToHashMap(List<KelasMahasiswa> kelasmahasiswaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < kelasmahasiswaList.size(); i++) {
            resultList.add(kelasmahasiswaList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/rencanastudi/delete")
    public List<HashMap<String,Object>> deleteKelasMahasiswa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		kelasmahasiswaRepository.deleteObject(id);
		return getAllKelasMahasiswa(vmjExchange);
	}

}
