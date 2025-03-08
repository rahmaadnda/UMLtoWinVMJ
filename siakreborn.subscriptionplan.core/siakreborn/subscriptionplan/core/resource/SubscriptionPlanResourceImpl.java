package siakreborn.subscriptionplan.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.subscriptionplan.SubscriptionPlanFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class SubscriptionPlanResourceImpl extends SubscriptionPlanResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/subscriptionplan/save")
    public List<HashMap<String,Object>> saveSubscriptionPlan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SubscriptionPlan subscriptionplan = createSubscriptionPlan(vmjExchange);
		subscriptionplanRepository.saveObject(subscriptionplan);
		return getAllSubscriptionPlan(vmjExchange);
	}

    public SubscriptionPlan createSubscriptionPlan(VMJExchange vmjExchange){
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		String name = (String) vmjExchange.getRequestBodyForm("name");
		String hargaStr = (String) vmjExchange.getRequestBodyForm("harga");
		int harga = Integer.parseInt(hargaStr);
		
		//to do: fix association attributes
		
		SubscriptionPlan subscriptionplan = SubscriptionPlanFactory.createSubscriptionPlan("siakreborn.subscriptionplan.core.SubscriptionPlanImpl", id, deskripsi, name, harga);
			return subscriptionplan;
	}

    public SubscriptionPlan createSubscriptionPlan(VMJExchange vmjExchange, int id){
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		String name = (String) vmjExchange.getRequestBodyForm("name");
		String hargaStr = (String) vmjExchange.getRequestBodyForm("harga");
		int harga = Integer.parseInt(hargaStr);
		
		//to do: fix association attributes
		
		SubscriptionPlan subscriptionplan = SubscriptionPlanFactory.createSubscriptionPlan("siakreborn.subscriptionplan.core.SubscriptionPlanImpl", , deskripsi, name, harga);
			return subscriptionplan;
	}

    // @Restriced(permission = "")
    @Route(url="call/subscriptionplan/update")
    public HashMap<String, Object> updateSubscriptionPlan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		SubscriptionPlan subscriptionplan = subscriptionplanRepository.getObject(id);
		subscriptionplan.setDeskripsi((String) vmjExchange.getRequestBodyForm("deskripsi"));
		subscriptionplan.setName((String) vmjExchange.getRequestBodyForm("name"));
		String hargaStr = (String) vmjExchange.getRequestBodyForm("harga");
		subscriptionplan.setHarga(Integer.parseInt(hargaStr));
		
		subscriptionplanRepository.updateObject(subscriptionplan);
		subscriptionplan = subscriptionplanRepository.getObject(id);
		//to do: fix association attributes
		
		return subscriptionplan.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/subscriptionplan/detail")
    public HashMap<String, Object> getSubscriptionPlan(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		SubscriptionPlan subscriptionplan = subscriptionplanRepository.getObject(id);
		return subscriptionplan.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/subscriptionplan/list")
    public List<HashMap<String,Object>> getAllSubscriptionPlan(VMJExchange vmjExchange){
		List<SubscriptionPlan> subscriptionplanList = subscriptionplanRepository.getAllObject("subscriptionplan_impl");
		return transformSubscriptionPlanListToHashMap(subscriptionplanList);
	}

    public List<HashMap<String,Object>> transformSubscriptionPlanListToHashMap(List<SubscriptionPlan> subscriptionplanList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < subscriptionplanList.size(); i++) {
            resultList.add(subscriptionplanList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/subscriptionplan/delete")
    public List<HashMap<String,Object>> deleteSubscriptionPlan(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		subscriptionplanRepository.deleteObject(id);
		return getAllSubscriptionPlan(vmjExchange);
	}

}
