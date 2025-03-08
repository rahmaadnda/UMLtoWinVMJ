package siakreborn.matakuliah.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.matakuliah.MataKuliahFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class MataKuliahResourceImpl extends MataKuliahResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/matakuliah/save")
    public List<HashMap<String,Object>> saveMataKuliah(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		MataKuliah matakuliah = createMataKuliah(vmjExchange);
		matakuliahRepository.saveObject(matakuliah);
		return getAllMataKuliah(vmjExchange);
	}

    public MataKuliah createMataKuliah(VMJExchange vmjExchange){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String sksStr = (String) vmjExchange.getRequestBodyForm("sks");
		int sks = Integer.parseInt(sksStr);
		String termStr = (String) vmjExchange.getRequestBodyForm("term");
		int term = Integer.parseInt(termStr);
		
		//to do: fix association attributes
		
		MataKuliah matakuliah = MataKuliahFactory.createMataKuliah("siakreborn.matakuliah.core.MataKuliahImpl", id, kode, nama, sks, term, kurikulumimpl);
			return matakuliah;
	}

    public MataKuliah createMataKuliah(VMJExchange vmjExchange, int id){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String sksStr = (String) vmjExchange.getRequestBodyForm("sks");
		int sks = Integer.parseInt(sksStr);
		String termStr = (String) vmjExchange.getRequestBodyForm("term");
		int term = Integer.parseInt(termStr);
		
		//to do: fix association attributes
		
		MataKuliah matakuliah = MataKuliahFactory.createMataKuliah("siakreborn.matakuliah.core.MataKuliahImpl", , kode, nama, sks, term, kurikulumimpl);
			return matakuliah;
	}

    // @Restriced(permission = "")
    @Route(url="call/matakuliah/update")
    public HashMap<String, Object> updateMataKuliah(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		MataKuliah matakuliah = matakuliahRepository.getObject(id);
		matakuliah.setKode((String) vmjExchange.getRequestBodyForm("kode"));
		matakuliah.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		String sksStr = (String) vmjExchange.getRequestBodyForm("sks");
		matakuliah.setSks(Integer.parseInt(sksStr));
		String termStr = (String) vmjExchange.getRequestBodyForm("term");
		matakuliah.setTerm(Integer.parseInt(termStr));
		
		matakuliahRepository.updateObject(matakuliah);
		matakuliah = matakuliahRepository.getObject(id);
		//to do: fix association attributes
		
		return matakuliah.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/matakuliah/detail")
    public HashMap<String, Object> getMataKuliah(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		MataKuliah matakuliah = matakuliahRepository.getObject(id);
		return matakuliah.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/matakuliah/list")
    public List<HashMap<String,Object>> getAllMataKuliah(VMJExchange vmjExchange){
		List<MataKuliah> matakuliahList = matakuliahRepository.getAllObject("matakuliah_impl");
		return transformMataKuliahListToHashMap(matakuliahList);
	}

    public List<HashMap<String,Object>> transformMataKuliahListToHashMap(List<MataKuliah> matakuliahList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < matakuliahList.size(); i++) {
            resultList.add(matakuliahList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/matakuliah/delete")
    public List<HashMap<String,Object>> deleteMataKuliah(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		matakuliahRepository.deleteObject(id);
		return getAllMataKuliah(vmjExchange);
	}

}
