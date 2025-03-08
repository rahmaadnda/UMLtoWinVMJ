package siakreborn.subscription.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Subscription {
	public UUID getId();
	public void setId(UUID id);
	public String getStatus();
	public void setStatus(String status);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public Date getRequestDate();
	public void setRequestDate(Date requestDate);
	public SubscriptionPlanImpl getSubscriptionplanimpl();
	public void setSubscriptionplanimpl(SubscriptionPlanImpl subscriptionplanimpl);
	HashMap<String, Object> toHashMap();
}
