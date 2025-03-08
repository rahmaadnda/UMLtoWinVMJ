package siakreborn.kelas.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.kelas.KelasFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class KelasResourceImpl extends KelasResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/kelas/save")
    public List<HashMap<String,Object>> saveKelas(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Kelas kelas = createKelas(vmjExchange);
		kelasRepository.saveObject(kelas);
		return getAllKelas(vmjExchange);
	}

    public Kelas createKelas(VMJExchange vmjExchange){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String kapasitasStr = (String) vmjExchange.getRequestBodyForm("kapasitas");
		int kapasitas = Integer.parseInt(kapasitasStr);
		String ruangan = (String) vmjExchange.getRequestBodyForm("ruangan");
		String jadwal = (String) vmjExchange.getRequestBodyForm("jadwal");
		
		//to do: fix association attributes
		
		Kelas kelas = KelasFactory.createKelas("siakreborn.kelas.core.KelasImpl", id, nama, kapasitas, ruangan, jadwal, matakuliahimpl, semesterimpl);
			return kelas;
	}

    public Kelas createKelas(VMJExchange vmjExchange, int id){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String kapasitasStr = (String) vmjExchange.getRequestBodyForm("kapasitas");
		int kapasitas = Integer.parseInt(kapasitasStr);
		String ruangan = (String) vmjExchange.getRequestBodyForm("ruangan");
		String jadwal = (String) vmjExchange.getRequestBodyForm("jadwal");
		
		//to do: fix association attributes
		
		Kelas kelas = KelasFactory.createKelas("siakreborn.kelas.core.KelasImpl", , nama, kapasitas, ruangan, jadwal, matakuliahimpl, semesterimpl);
			return kelas;
	}

    // @Restriced(permission = "")
    @Route(url="call/kelas/update")
    public HashMap<String, Object> updateKelas(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Kelas kelas = kelasRepository.getObject(id);
		kelas.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		String kapasitasStr = (String) vmjExchange.getRequestBodyForm("kapasitas");
		kelas.setKapasitas(Integer.parseInt(kapasitasStr));
		kelas.setRuangan((String) vmjExchange.getRequestBodyForm("ruangan"));
		kelas.setJadwal((String) vmjExchange.getRequestBodyForm("jadwal"));
		
		kelasRepository.updateObject(kelas);
		kelas = kelasRepository.getObject(id);
		//to do: fix association attributes
		
		return kelas.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/kelas/detail")
    public HashMap<String, Object> getKelas(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Kelas kelas = kelasRepository.getObject(id);
		return kelas.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/kelas/list")
    public List<HashMap<String,Object>> getAllKelas(VMJExchange vmjExchange){
		List<Kelas> kelasList = kelasRepository.getAllObject("kelas_impl");
		return transformKelasListToHashMap(kelasList);
	}

    public List<HashMap<String,Object>> transformKelasListToHashMap(List<Kelas> kelasList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < kelasList.size(); i++) {
            resultList.add(kelasList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/kelas/delete")
    public List<HashMap<String,Object>> deleteKelas(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		kelasRepository.deleteObject(id);
		return getAllKelas(vmjExchange);
	}

}
