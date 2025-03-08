package siakreborn.kurikulumsemester.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class KurikulumSemesterResourceDecorator extends KurikulumSemesterResourceComponent{
	protected KurikulumSemesterResourceComponent record;

    public KurikulumSemesterResourceDecorator(KurikulumSemesterResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveKurikulumSemester(VMJExchange vmjExchange){
		return record.saveKurikulumSemester(vmjExchange);
	}

    public KurikulumSemester createKurikulumSemester(VMJExchange vmjExchange){
		return record.createKurikulumSemester(vmjExchange);
	}

    public KurikulumSemester createKurikulumSemester(VMJExchange vmjExchange, int id){
		return record.createKurikulumSemester(vmjExchange, id);
	}

    public HashMap<String, Object> updateKurikulumSemester(VMJExchange vmjExchange){
		return record.updateKurikulumSemester(vmjExchange);
	}

    public HashMap<String, Object> getKurikulumSemester(VMJExchange vmjExchange){
		return record.getKurikulumSemester(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllKurikulumSemester(VMJExchange vmjExchange){
		return record.getAllKurikulumSemester(vmjExchange);
	}

    public List<HashMap<String,Object>> transformKurikulumSemesterListToHashMap(List<KurikulumSemester> kurikulumsemesterList){
		return record.transformKurikulumSemesterListToHashMap(kurikulumsemesterList);
	}

    public List<HashMap<String,Object>> deleteKurikulumSemester(VMJExchange vmjExchange){
		return record.deleteKurikulumSemester(vmjExchange);
	}

}
