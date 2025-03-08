package siakreborn.observer.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.observer.ObserverFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ObserverResourceImpl extends ObserverResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/observer/save")
    public List<HashMap<String,Object>> saveObserver(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Observer observer = createObserver(vmjExchange);
		observerRepository.saveObject(observer);
		return getAllObserver(vmjExchange);
	}

    public Observer createObserver(VMJExchange vmjExchange){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		
		//to do: fix association attributes
		
		Observer observer = ObserverFactory.createObserver("siakreborn.observer.core.ObserverImpl", nama, id, email);
			return observer;
	}

    public Observer createObserver(VMJExchange vmjExchange, int id){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		
		//to do: fix association attributes
		
		Observer observer = ObserverFactory.createObserver("siakreborn.observer.core.ObserverImpl", nama, , email);
			return observer;
	}

    // @Restriced(permission = "")
    @Route(url="call/observer/update")
    public HashMap<String, Object> updateObserver(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Observer observer = observerRepository.getObject(id);
		observer.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		observer.setEmail((String) vmjExchange.getRequestBodyForm("email"));
		
		observerRepository.updateObject(observer);
		observer = observerRepository.getObject(id);
		//to do: fix association attributes
		
		return observer.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/observer/detail")
    public HashMap<String, Object> getObserver(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Observer observer = observerRepository.getObject(id);
		return observer.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/observer/list")
    public List<HashMap<String,Object>> getAllObserver(VMJExchange vmjExchange){
		List<Observer> observerList = observerRepository.getAllObject("observer_impl");
		return transformObserverListToHashMap(observerList);
	}

    public List<HashMap<String,Object>> transformObserverListToHashMap(List<Observer> observerList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < observerList.size(); i++) {
            resultList.add(observerList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/observer/delete")
    public List<HashMap<String,Object>> deleteObserver(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		observerRepository.deleteObject(id);
		return getAllObserver(vmjExchange);
	}

}
