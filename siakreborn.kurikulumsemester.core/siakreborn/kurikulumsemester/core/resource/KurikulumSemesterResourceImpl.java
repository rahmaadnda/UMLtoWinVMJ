package siakreborn.kurikulumsemester.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kurikulumsemester.KurikulumSemesterFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KurikulumSemesterResourceImpl extends KurikulumSemesterResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/kurikulumsemester/save")
    public List<HashMap<String,Object>> saveKurikulumSemester(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		KurikulumSemester kurikulumsemester = createKurikulumSemester(vmjExchange);
		kurikulumsemesterRepository.saveObject(kurikulumsemester);
		return getAllKurikulumSemester(vmjExchange);
	}

    public KurikulumSemester createKurikulumSemester(VMJExchange vmjExchange){
		
		//to do: fix association attributes
		
		KurikulumSemester kurikulumsemester = KurikulumSemesterFactory.createKurikulumSemester("siakreborn.kurikulumsemester.core.KurikulumSemesterImpl", id, kurikulumimpl, semesterimpl);
			return kurikulumsemester;
	}

    public KurikulumSemester createKurikulumSemester(VMJExchange vmjExchange, int id){
		
		//to do: fix association attributes
		
		KurikulumSemester kurikulumsemester = KurikulumSemesterFactory.createKurikulumSemester("siakreborn.kurikulumsemester.core.KurikulumSemesterImpl", , kurikulumimpl, semesterimpl);
			return kurikulumsemester;
	}

    // @Restriced(permission = "")
    @Route(url="call/kurikulumsemester/update")
    public HashMap<String, Object> updateKurikulumSemester(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		KurikulumSemester kurikulumsemester = kurikulumsemesterRepository.getObject(id);
		
		kurikulumsemesterRepository.updateObject(kurikulumsemester);
		kurikulumsemester = kurikulumsemesterRepository.getObject(id);
		//to do: fix association attributes
		
		return kurikulumsemester.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/kurikulumsemester/detail")
    public HashMap<String, Object> getKurikulumSemester(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		KurikulumSemester kurikulumsemester = kurikulumsemesterRepository.getObject(id);
		return kurikulumsemester.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/kurikulumsemester/list")
    public List<HashMap<String,Object>> getAllKurikulumSemester(VMJExchange vmjExchange){
		List<KurikulumSemester> kurikulumsemesterList = kurikulumsemesterRepository.getAllObject("kurikulumsemester_impl");
		return transformKurikulumSemesterListToHashMap(kurikulumsemesterList);
	}

    public List<HashMap<String,Object>> transformKurikulumSemesterListToHashMap(List<KurikulumSemester> kurikulumsemesterList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < kurikulumsemesterList.size(); i++) {
            resultList.add(kurikulumsemesterList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/kurikulumsemester/delete")
    public List<HashMap<String,Object>> deleteKurikulumSemester(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		kurikulumsemesterRepository.deleteObject(id);
		return getAllKurikulumSemester(vmjExchange);
	}

}
