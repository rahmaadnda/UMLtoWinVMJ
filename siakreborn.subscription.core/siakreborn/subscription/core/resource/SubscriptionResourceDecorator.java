package siakreborn.subscription.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class SubscriptionResourceDecorator extends SubscriptionResourceComponent{
	protected SubscriptionResourceComponent record;

    public SubscriptionResourceDecorator(SubscriptionResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveSubscription(VMJExchange vmjExchange){
		return record.saveSubscription(vmjExchange);
	}

    public Subscription createSubscription(VMJExchange vmjExchange){
		return record.createSubscription(vmjExchange);
	}

    public Subscription createSubscription(VMJExchange vmjExchange, int id){
		return record.createSubscription(vmjExchange, id);
	}

    public HashMap<String, Object> updateSubscription(VMJExchange vmjExchange){
		return record.updateSubscription(vmjExchange);
	}

    public HashMap<String, Object> getSubscription(VMJExchange vmjExchange){
		return record.getSubscription(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllSubscription(VMJExchange vmjExchange){
		return record.getAllSubscription(vmjExchange);
	}

    public List<HashMap<String,Object>> transformSubscriptionListToHashMap(List<Subscription> subscriptionList){
		return record.transformSubscriptionListToHashMap(subscriptionList);
	}

    public List<HashMap<String,Object>> deleteSubscription(VMJExchange vmjExchange){
		return record.deleteSubscription(vmjExchange);
	}

}
