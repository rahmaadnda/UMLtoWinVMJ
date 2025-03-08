package siakreborn.bobotkomponenpenilaian.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.bobotkomponenpenilaian.BobotKomponenPenilaianFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class BobotKomponenPenilaianResourceImpl extends BobotKomponenPenilaianResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/bobotkomponenpenilaian/save")
    public List<HashMap<String,Object>> saveBobotKomponenPenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		BobotKomponenPenilaian bobotkomponenpenilaian = createBobotKomponenPenilaian(vmjExchange);
		bobotkomponenpenilaianRepository.saveObject(bobotkomponenpenilaian);
		return getAllBobotKomponenPenilaian(vmjExchange);
	}

    public BobotKomponenPenilaian createBobotKomponenPenilaian(VMJExchange vmjExchange){
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		int bobot = Integer.parseInt(bobotStr);
		
		//to do: fix association attributes
		
		BobotKomponenPenilaian bobotkomponenpenilaian = BobotKomponenPenilaianFactory.createBobotKomponenPenilaian("siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianImpl", id, bobot, komponenpenilaianimpl, capaianimpl, capaianimpl);
			return bobotkomponenpenilaian;
	}

    public BobotKomponenPenilaian createBobotKomponenPenilaian(VMJExchange vmjExchange, int id){
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		int bobot = Integer.parseInt(bobotStr);
		
		//to do: fix association attributes
		
		BobotKomponenPenilaian bobotkomponenpenilaian = BobotKomponenPenilaianFactory.createBobotKomponenPenilaian("siakreborn.bobotkomponenpenilaian.core.BobotKomponenPenilaianImpl", , bobot, komponenpenilaianimpl, capaianimpl, capaianimpl);
			return bobotkomponenpenilaian;
	}

    // @Restriced(permission = "")
    @Route(url="call/bobotkomponenpenilaian/update")
    public HashMap<String, Object> updateBobotKomponenPenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		BobotKomponenPenilaian bobotkomponenpenilaian = bobotkomponenpenilaianRepository.getObject(id);
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		bobotkomponenpenilaian.setBobot(Integer.parseInt(bobotStr));
		
		bobotkomponenpenilaianRepository.updateObject(bobotkomponenpenilaian);
		bobotkomponenpenilaian = bobotkomponenpenilaianRepository.getObject(id);
		//to do: fix association attributes
		
		return bobotkomponenpenilaian.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/bobotkomponenpenilaian/detail")
    public HashMap<String, Object> getBobotKomponenPenilaian(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		BobotKomponenPenilaian bobotkomponenpenilaian = bobotkomponenpenilaianRepository.getObject(id);
		return bobotkomponenpenilaian.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/bobotkomponenpenilaian/list")
    public List<HashMap<String,Object>> getAllBobotKomponenPenilaian(VMJExchange vmjExchange){
		List<BobotKomponenPenilaian> bobotkomponenpenilaianList = bobotkomponenpenilaianRepository.getAllObject("bobotkomponenpenilaian_impl");
		return transformBobotKomponenPenilaianListToHashMap(bobotkomponenpenilaianList);
	}

    public List<HashMap<String,Object>> transformBobotKomponenPenilaianListToHashMap(List<BobotKomponenPenilaian> bobotkomponenpenilaianList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < bobotkomponenpenilaianList.size(); i++) {
            resultList.add(bobotkomponenpenilaianList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/bobotkomponenpenilaian/delete")
    public List<HashMap<String,Object>> deleteBobotKomponenPenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		bobotkomponenpenilaianRepository.deleteObject(id);
		return getAllBobotKomponenPenilaian(vmjExchange);
	}

}
