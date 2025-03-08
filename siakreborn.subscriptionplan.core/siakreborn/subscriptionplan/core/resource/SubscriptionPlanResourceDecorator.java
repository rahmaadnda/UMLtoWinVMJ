package siakreborn.subscriptionplan.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class SubscriptionPlanResourceDecorator extends SubscriptionPlanResourceComponent{
	protected SubscriptionPlanResourceComponent record;

    public SubscriptionPlanResourceDecorator(SubscriptionPlanResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveSubscriptionPlan(VMJExchange vmjExchange){
		return record.saveSubscriptionPlan(vmjExchange);
	}

    public SubscriptionPlan createSubscriptionPlan(VMJExchange vmjExchange){
		return record.createSubscriptionPlan(vmjExchange);
	}

    public SubscriptionPlan createSubscriptionPlan(VMJExchange vmjExchange, int id){
		return record.createSubscriptionPlan(vmjExchange, id);
	}

    public HashMap<String, Object> updateSubscriptionPlan(VMJExchange vmjExchange){
		return record.updateSubscriptionPlan(vmjExchange);
	}

    public HashMap<String, Object> getSubscriptionPlan(VMJExchange vmjExchange){
		return record.getSubscriptionPlan(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllSubscriptionPlan(VMJExchange vmjExchange){
		return record.getAllSubscriptionPlan(vmjExchange);
	}

    public List<HashMap<String,Object>> transformSubscriptionPlanListToHashMap(List<SubscriptionPlan> subscriptionplanList){
		return record.transformSubscriptionPlanListToHashMap(subscriptionplanList);
	}

    public List<HashMap<String,Object>> deleteSubscriptionPlan(VMJExchange vmjExchange){
		return record.deleteSubscriptionPlan(vmjExchange);
	}

}
