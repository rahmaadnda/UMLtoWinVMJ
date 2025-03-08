package siakreborn.mahasiswa.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.mahasiswa.MahasiswaFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class MahasiswaResourceImpl extends MahasiswaResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/mahasiswa/save")
    public List<HashMap<String,Object>> saveMahasiswa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Mahasiswa mahasiswa = createMahasiswa(vmjExchange);
		mahasiswaRepository.saveObject(mahasiswa);
		return getAllMahasiswa(vmjExchange);
	}

    public Mahasiswa createMahasiswa(VMJExchange vmjExchange){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String npm = (String) vmjExchange.getRequestBodyForm("npm");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		String statusAkademik = (String) vmjExchange.getRequestBodyForm("statusAkademik");
		String tahunAngkatanStr = (String) vmjExchange.getRequestBodyForm("tahunAngkatan");
		int tahunAngkatan = Integer.parseInt(tahunAngkatanStr);
		boolean isPublic = (boolean) vmjExchange.getRequestBodyForm("isPublic");
		
		//to do: fix association attributes
		
		Mahasiswa mahasiswa = MahasiswaFactory.createMahasiswa("siakreborn.mahasiswa.core.MahasiswaImpl", id, nama, npm, email, programstudiimpl, statusAkademik, tahunAngkatan, isPublic);
			return mahasiswa;
	}

    public Mahasiswa createMahasiswa(VMJExchange vmjExchange, int id){
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String npm = (String) vmjExchange.getRequestBodyForm("npm");
		String email = (String) vmjExchange.getRequestBodyForm("email");
		String statusAkademik = (String) vmjExchange.getRequestBodyForm("statusAkademik");
		String tahunAngkatanStr = (String) vmjExchange.getRequestBodyForm("tahunAngkatan");
		int tahunAngkatan = Integer.parseInt(tahunAngkatanStr);
		boolean isPublic = (boolean) vmjExchange.getRequestBodyForm("isPublic");
		
		//to do: fix association attributes
		
		Mahasiswa mahasiswa = MahasiswaFactory.createMahasiswa("siakreborn.mahasiswa.core.MahasiswaImpl", , nama, npm, email, programstudiimpl, statusAkademik, tahunAngkatan, isPublic);
			return mahasiswa;
	}

    // @Restriced(permission = "")
    @Route(url="call/mahasiswa/update")
    public HashMap<String, Object> updateMahasiswa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Mahasiswa mahasiswa = mahasiswaRepository.getObject(id);
		mahasiswa.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		mahasiswa.setNpm((String) vmjExchange.getRequestBodyForm("npm"));
		mahasiswa.setEmail((String) vmjExchange.getRequestBodyForm("email"));
		mahasiswa.setStatusAkademik((String) vmjExchange.getRequestBodyForm("statusAkademik"));
		String tahunAngkatanStr = (String) vmjExchange.getRequestBodyForm("tahunAngkatan");
		mahasiswa.setTahunAngkatan(Integer.parseInt(tahunAngkatanStr));
		mahasiswa.setIsPublic((String) vmjExchange.getRequestBodyForm("isPublic"));
		
		mahasiswaRepository.updateObject(mahasiswa);
		mahasiswa = mahasiswaRepository.getObject(id);
		//to do: fix association attributes
		
		return mahasiswa.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/mahasiswa/detail")
    public HashMap<String, Object> getMahasiswa(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Mahasiswa mahasiswa = mahasiswaRepository.getObject(id);
		return mahasiswa.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/mahasiswa/list")
    public List<HashMap<String,Object>> getAllMahasiswa(VMJExchange vmjExchange){
		List<Mahasiswa> mahasiswaList = mahasiswaRepository.getAllObject("mahasiswa_impl");
		return transformMahasiswaListToHashMap(mahasiswaList);
	}

    public List<HashMap<String,Object>> transformMahasiswaListToHashMap(List<Mahasiswa> mahasiswaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < mahasiswaList.size(); i++) {
            resultList.add(mahasiswaList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/mahasiswa/delete")
    public List<HashMap<String,Object>> deleteMahasiswa(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		mahasiswaRepository.deleteObject(id);
		return getAllMahasiswa(vmjExchange);
	}

	public HashMap<String, Object> verify(VMJExchange vmjExchange) {
		// TODO: implement this method
	}

	public HashMap<String, Object> graduate(VMJExchange vmjExchange) {
		// TODO: implement this method
	}
}
