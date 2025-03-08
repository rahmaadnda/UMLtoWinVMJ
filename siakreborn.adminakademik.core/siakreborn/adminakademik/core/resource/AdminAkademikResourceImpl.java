package siakreborn.adminakademik.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.adminakademik.AdminAkademikFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class AdminAkademikResourceImpl extends AdminAkademikResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/adminakademik/save")
    public List<HashMap<String,Object>> saveAdminAkademik(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		AdminAkademik adminakademik = createAdminAkademik(vmjExchange);
		adminakademikRepository.saveObject(adminakademik);
		return getAllAdminAkademik(vmjExchange);
	}

    public AdminAkademik createAdminAkademik(VMJExchange vmjExchange){
		String email = (String) vmjExchange.getRequestBodyForm("email");
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		
		//to do: fix association attributes
		
		AdminAkademik adminakademik = AdminAkademikFactory.createAdminAkademik("siakreborn.adminakademik.core.AdminAkademikImpl", id, email, nama);
			return adminakademik;
	}

    public AdminAkademik createAdminAkademik(VMJExchange vmjExchange, int id){
		String email = (String) vmjExchange.getRequestBodyForm("email");
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		
		//to do: fix association attributes
		
		AdminAkademik adminakademik = AdminAkademikFactory.createAdminAkademik("siakreborn.adminakademik.core.AdminAkademikImpl", , email, nama);
			return adminakademik;
	}

    // @Restriced(permission = "")
    @Route(url="call/adminakademik/update")
    public HashMap<String, Object> updateAdminAkademik(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		AdminAkademik adminakademik = adminakademikRepository.getObject(id);
		adminakademik.setEmail((String) vmjExchange.getRequestBodyForm("email"));
		adminakademik.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		
		adminakademikRepository.updateObject(adminakademik);
		adminakademik = adminakademikRepository.getObject(id);
		//to do: fix association attributes
		
		return adminakademik.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/adminakademik/detail")
    public HashMap<String, Object> getAdminAkademik(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		AdminAkademik adminakademik = adminakademikRepository.getObject(id);
		return adminakademik.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/adminakademik/list")
    public List<HashMap<String,Object>> getAllAdminAkademik(VMJExchange vmjExchange){
		List<AdminAkademik> adminakademikList = adminakademikRepository.getAllObject("adminakademik_impl");
		return transformAdminAkademikListToHashMap(adminakademikList);
	}

    public List<HashMap<String,Object>> transformAdminAkademikListToHashMap(List<AdminAkademik> adminakademikList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < adminakademikList.size(); i++) {
            resultList.add(adminakademikList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/adminakademik/delete")
    public List<HashMap<String,Object>> deleteAdminAkademik(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		adminakademikRepository.deleteObject(id);
		return getAllAdminAkademik(vmjExchange);
	}

}
