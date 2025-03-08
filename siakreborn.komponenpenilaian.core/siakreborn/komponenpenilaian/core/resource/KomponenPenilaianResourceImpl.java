package siakreborn.komponenpenilaian.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.komponenpenilaian.KomponenPenilaianFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KomponenPenilaianResourceImpl extends KomponenPenilaianResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/komponenpenilaian/save")
    public List<HashMap<String,Object>> saveKomponenPenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KomponenPenilaian komponenpenilaian = createKomponenPenilaian(vmjExchange);
		komponenpenilaianRepository.saveObject(komponenpenilaian);
		return getAllKomponenPenilaian(vmjExchange);
	}

    public KomponenPenilaian createKomponenPenilaian(VMJExchange vmjExchange){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		int bobot = Integer.parseInt(bobotStr);
		
		//to do: fix association attributes
		
		KomponenPenilaian komponenpenilaian = KomponenPenilaianFactory.createKomponenPenilaian("siakreborn.komponenpenilaian.core.KomponenPenilaianImpl", id, nama, kelasimpl, bobot);
			return komponenpenilaian;
	}

    public KomponenPenilaian createKomponenPenilaian(VMJExchange vmjExchange, int id){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		int bobot = Integer.parseInt(bobotStr);
		
		//to do: fix association attributes
		
		KomponenPenilaian komponenpenilaian = KomponenPenilaianFactory.createKomponenPenilaian("siakreborn.komponenpenilaian.core.KomponenPenilaianImpl", , nama, kelasimpl, bobot);
			return komponenpenilaian;
	}

    // @Restriced(permission = "")
    @Route(url="call/komponenpenilaian/update")
    public HashMap<String, Object> updateKomponenPenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		KomponenPenilaian komponenpenilaian = komponenpenilaianRepository.getObject(id);
		komponenpenilaian.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		String bobotStr = (String) vmjExchange.getRequestBodyForm("bobot");
		komponenpenilaian.setBobot(Integer.parseInt(bobotStr));
		
		komponenpenilaianRepository.updateObject(komponenpenilaian);
		komponenpenilaian = komponenpenilaianRepository.getObject(id);
		//to do: fix association attributes
		
		return komponenpenilaian.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/komponenpenilaian/detail")
    public HashMap<String, Object> getKomponenPenilaian(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		KomponenPenilaian komponenpenilaian = komponenpenilaianRepository.getObject(id);
		return komponenpenilaian.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/komponenpenilaian/list")
    public List<HashMap<String,Object>> getAllKomponenPenilaian(VMJExchange vmjExchange){
		List<KomponenPenilaian> komponenpenilaianList = komponenpenilaianRepository.getAllObject("komponenpenilaian_impl");
		return transformKomponenPenilaianListToHashMap(komponenpenilaianList);
	}

    public List<HashMap<String,Object>> transformKomponenPenilaianListToHashMap(List<KomponenPenilaian> komponenpenilaianList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < komponenpenilaianList.size(); i++) {
            resultList.add(komponenpenilaianList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/komponenpenilaian/delete")
    public List<HashMap<String,Object>> deleteKomponenPenilaian(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		komponenpenilaianRepository.deleteObject(id);
		return getAllKomponenPenilaian(vmjExchange);
	}

}
