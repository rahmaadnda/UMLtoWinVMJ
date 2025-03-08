package siakreborn.kurikulum.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kurikulum.KurikulumFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KurikulumResourceImpl extends KurikulumResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/kurikulum/save")
    public List<HashMap<String,Object>> saveKurikulum(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Kurikulum kurikulum = createKurikulum(vmjExchange);
		kurikulumRepository.saveObject(kurikulum);
		return getAllKurikulum(vmjExchange);
	}

    public Kurikulum createKurikulum(VMJExchange vmjExchange){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String noSK = (String) vmjExchange.getRequestBodyForm("noSK");
		String status = (String) vmjExchange.getRequestBodyForm("status");
		String profilLulusan = (String) vmjExchange.getRequestBodyForm("profilLulusan");
		
		//to do: fix association attributes
		
		Kurikulum kurikulum = KurikulumFactory.createKurikulum("siakreborn.kurikulum.core.KurikulumImpl", id, kode, noSK, status, profilLulusan, programstudiimpl);
			return kurikulum;
	}

    public Kurikulum createKurikulum(VMJExchange vmjExchange, int id){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String noSK = (String) vmjExchange.getRequestBodyForm("noSK");
		String status = (String) vmjExchange.getRequestBodyForm("status");
		String profilLulusan = (String) vmjExchange.getRequestBodyForm("profilLulusan");
		
		//to do: fix association attributes
		
		Kurikulum kurikulum = KurikulumFactory.createKurikulum("siakreborn.kurikulum.core.KurikulumImpl", , kode, noSK, status, profilLulusan, programstudiimpl);
			return kurikulum;
	}

    // @Restriced(permission = "")
    @Route(url="call/kurikulum/update")
    public HashMap<String, Object> updateKurikulum(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Kurikulum kurikulum = kurikulumRepository.getObject(id);
		kurikulum.setKode((String) vmjExchange.getRequestBodyForm("kode"));
		kurikulum.setNoSK((String) vmjExchange.getRequestBodyForm("noSK"));
		kurikulum.setStatus((String) vmjExchange.getRequestBodyForm("status"));
		kurikulum.setProfilLulusan((String) vmjExchange.getRequestBodyForm("profilLulusan"));
		
		kurikulumRepository.updateObject(kurikulum);
		kurikulum = kurikulumRepository.getObject(id);
		//to do: fix association attributes
		
		return kurikulum.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/kurikulum/detail")
    public HashMap<String, Object> getKurikulum(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Kurikulum kurikulum = kurikulumRepository.getObject(id);
		return kurikulum.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/kurikulum/list")
    public List<HashMap<String,Object>> getAllKurikulum(VMJExchange vmjExchange){
		List<Kurikulum> kurikulumList = kurikulumRepository.getAllObject("kurikulum_impl");
		return transformKurikulumListToHashMap(kurikulumList);
	}

    public List<HashMap<String,Object>> transformKurikulumListToHashMap(List<Kurikulum> kurikulumList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < kurikulumList.size(); i++) {
            resultList.add(kurikulumList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/kurikulum/delete")
    public List<HashMap<String,Object>> deleteKurikulum(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		kurikulumRepository.deleteObject(id);
		return getAllKurikulum(vmjExchange);
	}

}
