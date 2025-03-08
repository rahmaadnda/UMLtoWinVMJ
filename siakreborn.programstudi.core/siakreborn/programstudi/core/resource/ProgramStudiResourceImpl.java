package siakreborn.programstudi.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import siakreborn.programstudi.ProgramStudiFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ProgramStudiResourceImpl extends ProgramStudiResourceComponent{

	// @Restriced(permission = "")
    @Route(url="call/programstudi/save")
    public List<HashMap<String,Object>> saveProgramStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ProgramStudi programstudi = createProgramStudi(vmjExchange);
		programstudiRepository.saveObject(programstudi);
		return getAllProgramStudi(vmjExchange);
	}

    public ProgramStudi createProgramStudi(VMJExchange vmjExchange){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String noSK = (String) vmjExchange.getRequestBodyForm("noSK");
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String kaprodi = (String) vmjExchange.getRequestBodyForm("kaprodi");
		String jenjang = (String) vmjExchange.getRequestBodyForm("jenjang");
		
		//to do: fix association attributes
		
		ProgramStudi programstudi = ProgramStudiFactory.createProgramStudi("siakreborn.programstudi.core.ProgramStudiImpl", id, kode, noSK, nama, kaprodi, jenjang);
			return programstudi;
	}

    public ProgramStudi createProgramStudi(VMJExchange vmjExchange, int id){
		String kode = (String) vmjExchange.getRequestBodyForm("kode");
		String noSK = (String) vmjExchange.getRequestBodyForm("noSK");
		String nama = (String) vmjExchange.getRequestBodyForm("nama");
		String kaprodi = (String) vmjExchange.getRequestBodyForm("kaprodi");
		String jenjang = (String) vmjExchange.getRequestBodyForm("jenjang");
		
		//to do: fix association attributes
		
		ProgramStudi programstudi = ProgramStudiFactory.createProgramStudi("siakreborn.programstudi.core.ProgramStudiImpl", , kode, noSK, nama, kaprodi, jenjang);
			return programstudi;
	}

    // @Restriced(permission = "")
    @Route(url="call/programstudi/update")
    public HashMap<String, Object> updateProgramStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		
		ProgramStudi programstudi = programstudiRepository.getObject(id);
		programstudi.setKode((String) vmjExchange.getRequestBodyForm("kode"));
		programstudi.setNoSK((String) vmjExchange.getRequestBodyForm("noSK"));
		programstudi.setNama((String) vmjExchange.getRequestBodyForm("nama"));
		programstudi.setKaprodi((String) vmjExchange.getRequestBodyForm("kaprodi"));
		programstudi.setJenjang((String) vmjExchange.getRequestBodyForm("jenjang"));
		
		programstudiRepository.updateObject(programstudi);
		programstudi = programstudiRepository.getObject(id);
		//to do: fix association attributes
		
		return programstudi.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/programstudi/detail")
    public HashMap<String, Object> getProgramStudi(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id"); 
		int id = Integer.parseInt(idStr);
		ProgramStudi programstudi = programstudiRepository.getObject(id);
		return programstudi.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/programstudi/list")
    public List<HashMap<String,Object>> getAllProgramStudi(VMJExchange vmjExchange){
		List<ProgramStudi> programstudiList = programstudiRepository.getAllObject("programstudi_impl");
		return transformProgramStudiListToHashMap(programstudiList);
	}

    public List<HashMap<String,Object>> transformProgramStudiListToHashMap(List<ProgramStudi> programstudiList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < programstudiList.size(); i++) {
            resultList.add(programstudiList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/programstudi/delete")
    public List<HashMap<String,Object>> deleteProgramStudi(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		int id = Integer.parseInt(idStr);
		programstudiRepository.deleteObject(id);
		return getAllProgramStudi(vmjExchange);
	}

}
