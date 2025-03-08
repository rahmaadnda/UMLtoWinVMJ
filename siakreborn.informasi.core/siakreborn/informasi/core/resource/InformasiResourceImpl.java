package siakreborn.informasi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.informasi.InformasiFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class InformasiResourceImpl extends InformasiResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/informasi/save")
    public List<HashMap<String,Object>> saveInformasi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Informasi informasi = createInformasi(vmjExchange);
		informasiRepository.saveObject(informasi);
		return getAllInformasi(vmjExchange);
	}

    public Informasi createInformasi(VMJExchange vmjExchange){
		String judul = (String) vmjExchange.getRequestBodyForm("judul");
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		
		//to do: fix association attributes
		
		Informasi informasi = InformasiFactory.createInformasi("siakreborn.informasi.core.InformasiImpl", judul, id, deskripsi, tanggalPublikasi);
			return informasi;
	}

    public Informasi createInformasi(VMJExchange vmjExchange, int id){
		String judul = (String) vmjExchange.getRequestBodyForm("judul");
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		
		//to do: fix association attributes
		
		Informasi informasi = InformasiFactory.createInformasi("siakreborn.informasi.core.InformasiImpl", judul, , deskripsi, tanggalPublikasi);
			return informasi;
	}

    // @Restriced(permission = "")
    @Route(url="call/informasi/update")
    public HashMap<String, Object> updateInformasi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Informasi informasi = informasiRepository.getObject(id);
		informasi.setJudul((String) vmjExchange.getRequestBodyForm("judul"));
		informasi.setDeskripsi((String) vmjExchange.getRequestBodyForm("deskripsi"));
		
		informasiRepository.updateObject(informasi);
		informasi = informasiRepository.getObject(id);
		//to do: fix association attributes
		
		return informasi.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/informasi/detail")
    public HashMap<String, Object> getInformasi(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Informasi informasi = informasiRepository.getObject(id);
		return informasi.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/informasi/list")
    public List<HashMap<String,Object>> getAllInformasi(VMJExchange vmjExchange){
		List<Informasi> informasiList = informasiRepository.getAllObject("informasi_impl");
		return transformInformasiListToHashMap(informasiList);
	}

    public List<HashMap<String,Object>> transformInformasiListToHashMap(List<Informasi> informasiList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < informasiList.size(); i++) {
            resultList.add(informasiList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/informasi/delete")
    public List<HashMap<String,Object>> deleteInformasi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		informasiRepository.deleteObject(id);
		return getAllInformasi(vmjExchange);
	}

}
