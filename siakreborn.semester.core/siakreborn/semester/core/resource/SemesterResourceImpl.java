package siakreborn.semester.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.semester.SemesterFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class SemesterResourceImpl extends SemesterResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/semester/save")
    public List<HashMap<String,Object>> saveSemester(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Semester semester = createSemester(vmjExchange);
		semesterRepository.saveObject(semester);
		return getAllSemester(vmjExchange);
	}

    public Semester createSemester(VMJExchange vmjExchange){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String status = (String) vmjExchange.getRequestBodyForm("status");
		String tanggalMulai = (String) vmjExchange.getRequestBodyForm("tanggalMulai");
		String tanggalSelesai = (String) vmjExchange.getRequestBodyForm("tanggalSelesai");
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		
		//to do: fix association attributes
		
		Semester semester = SemesterFactory.createSemester("siakreborn.semester.core.SemesterImpl", id, kode, status, tanggalMulai, tanggalSelesai, deskripsi);
			return semester;
	}

    public Semester createSemester(VMJExchange vmjExchange, int id){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String status = (String) vmjExchange.getRequestBodyForm("status");
		String tanggalMulai = (String) vmjExchange.getRequestBodyForm("tanggalMulai");
		String tanggalSelesai = (String) vmjExchange.getRequestBodyForm("tanggalSelesai");
		String deskripsi = (String) vmjExchange.getRequestBodyForm("deskripsi");
		
		//to do: fix association attributes
		
		Semester semester = SemesterFactory.createSemester("siakreborn.semester.core.SemesterImpl", , kode, status, tanggalMulai, tanggalSelesai, deskripsi);
			return semester;
	}

    // @Restriced(permission = "")
    @Route(url="call/semester/update")
    public HashMap<String, Object> updateSemester(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		Semester semester = semesterRepository.getObject(id);
		semester.setKode((String) vmjExchange.getRequestBodyForm("kode"));
		semester.setStatus((String) vmjExchange.getRequestBodyForm("status"));
		semester.setTanggalMulai((String) vmjExchange.getRequestBodyForm("tanggalMulai"));
		semester.setTanggalSelesai((String) vmjExchange.getRequestBodyForm("tanggalSelesai"));
		semester.setDeskripsi((String) vmjExchange.getRequestBodyForm("deskripsi"));
		
		semesterRepository.updateObject(semester);
		semester = semesterRepository.getObject(id);
		//to do: fix association attributes
		
		return semester.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/semester/detail")
    public HashMap<String, Object> getSemester(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		Semester semester = semesterRepository.getObject(id);
		return semester.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/semester/list")
    public List<HashMap<String,Object>> getAllSemester(VMJExchange vmjExchange){
		List<Semester> semesterList = semesterRepository.getAllObject("semester_impl");
		return transformSemesterListToHashMap(semesterList);
	}

    public List<HashMap<String,Object>> transformSemesterListToHashMap(List<Semester> semesterList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < semesterList.size(); i++) {
            resultList.add(semesterList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/semester/delete")
    public List<HashMap<String,Object>> deleteSemester(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		semesterRepository.deleteObject(id);
		return getAllSemester(vmjExchange);
	}

}
