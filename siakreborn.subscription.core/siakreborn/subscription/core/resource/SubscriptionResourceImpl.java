package siakreborn.subscription.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.subscription.SubscriptionFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class SubscriptionResourceImpl extends SubscriptionResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/subscription/save")
    public List<HashMap<String,Object>> saveSubscription(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Subscription subscription = createSubscription(vmjExchange);
		subscriptionRepository.saveObject(subscription);
		return getAllSubscription(vmjExchange);
	}

    public Subscription createSubscription(VMJExchange vmjExchange){
		String status = (String) vmjExchange.getRequestBodyForm("status");
		
		//to do: fix association attributes
		
		Subscription subscription = SubscriptionFactory.createSubscription("siakreborn.subscription.core.SubscriptionImpl", id, status, startDate, endDate, requestDate, subscriptionplanimpl);
			return subscription;
	}

    public Subscription createSubscription(VMJExchange vmjExchange, int id){
		String status = (String) vmjExchange.getRequestBodyForm("status");
		
		//to do: fix association attributes
		
		Subscription subscription = SubscriptionFactory.createSubscription("siakreborn.subscription.core.SubscriptionImpl", , status, startDate, endDate, requestDate, subscriptionplanimpl);
			return subscription;
	}

    // @Restriced(permission = "")
    @Route(url="call/subscription/update")
    public HashMap<String, Object> updateSubscription(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Subscription subscription = subscriptionRepository.getObject(id);
		subscription.setStatus((String) vmjExchange.getRequestBodyForm("status"));
		
		subscriptionRepository.updateObject(subscription);
		subscription = subscriptionRepository.getObject(id);
		//to do: fix association attributes
		
		return subscription.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/subscription/detail")
    public HashMap<String, Object> getSubscription(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Subscription subscription = subscriptionRepository.getObject(id);
		return subscription.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/subscription/list")
    public List<HashMap<String,Object>> getAllSubscription(VMJExchange vmjExchange){
		List<Subscription> subscriptionList = subscriptionRepository.getAllObject("subscription_impl");
		return transformSubscriptionListToHashMap(subscriptionList);
	}

    public List<HashMap<String,Object>> transformSubscriptionListToHashMap(List<Subscription> subscriptionList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < subscriptionList.size(); i++) {
            resultList.add(subscriptionList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/subscription/delete")
    public List<HashMap<String,Object>> deleteSubscription(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		subscriptionRepository.deleteObject(id);
		return getAllSubscription(vmjExchange);
	}

}
