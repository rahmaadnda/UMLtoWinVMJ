package siakreborn.matakuliah.prasyarat;
import java.util.*;
import java.util.logging.Logger;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.auth.annotations.Restricted;

import siakreborn.matakuliah.core.MataKuliahResourceDecorator;
import siakreborn.matakuliah.core.MataKuliahImpl;
import siakreborn.matakuliah.core.MataKuliahResourceComponent;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.matakuliah.core.MataKuliahService;
import siakreborn.matakuliah.core.MataKuliahServiceComponent;

public class MataKuliahResourceImpl extends MataKuliahResourceDecorator {
	private MataKuliahService mataKuliahService;
	private static final Logger LOGGER = Logger.getLogger(MataKuliahResourceImpl.class.getName());


    public MataKuliahResourceImpl (MataKuliahResourceComponent recordController, MataKuliahServiceComponent recordService) {
        super(recordController);
		this.mataKuliahService = new MataKuliahServiceImpl(recordService);
    }

	@Restricted(permissionName = "SavePrasyarat")
    @Route(url="call/prasyarat/save")
    public List<HashMap<String,Object>> saveMataKuliah(VMJExchange vmjExchange){
		HashMap<String, Object> error = new HashMap<>();

		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		try {
			List<MataKuliah> mataKuliahList = mataKuliahService.saveMataKuliah((HashMap<String, Object>) vmjExchange.getPayload());
			return mataKuliahService.transformMataKuliahListToHashMap(mataKuliahList);
		} catch (Exception e) {
			LOGGER.severe("Error: " + e);
			error.put("error", e);
			return null;
		}

	}

	@Restricted(permissionName = "UpdatePrasyarat")
    @Route(url="call/prasyarat/update")
    public HashMap<String, Object> updateMataKuliah(VMJExchange vmjExchange){
		MataKuliah mataKuliah = mataKuliahService.updateMataKuliah((HashMap<String, Object>) vmjExchange.getPayload());
		return mataKuliah.toHashMap();
	}

	@Restricted(permissionName = "ReadPrasyarat")
    @Route(url="call/prasyarat/detail")
    public HashMap<String, Object> getMataKuliah(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id");
		if(idStr == null) {
		  throw new IllegalArgumentException("Invalid UUID");
		}
		UUID id = UUID.fromString(idStr);
	
		MataKuliah mataKuliah = mataKuliahService.getMataKuliah(id);
		return mataKuliah.toHashMap();
	}

	@Restricted(permissionName = "ReadPrasyarat")
    @Route(url="call/prasyarat/list")
    public List<HashMap<String,Object>> getAllMataKuliah(VMJExchange vmjExchange){
		List<MataKuliah> mataKuliahList = mataKuliahService.getAllMataKuliah();
		return mataKuliahService.transformMataKuliahListToHashMap(mataKuliahList);
	}

	@Restricted(permissionName = "ReadPrasyarat")
	@Route(url = "call/prasyarat/filter")
	public List<HashMap<String, Object>> filterMataKuliah(VMJExchange vmjExchange) {
	  String by = (String) vmjExchange.getGETParam("by");
  
	  if (by.equals("parentMataKuliah") ) {
		String idStr = (String) vmjExchange.getGETParam(by + "Id");
		if(idStr == null) {
		  throw new IllegalArgumentException("Invalid UUID");
		}
  
		UUID id = UUID.fromString(idStr);
  
		String columnName = by.toLowerCase() + "_id";
  
		List<MataKuliah> mataKuliahList = ((MataKuliahServiceImpl) mataKuliahService).filterMataKuliah(columnName, id);
		return mataKuliahService.transformMataKuliahListToHashMap(mataKuliahList);
	  }
  
	  return new ArrayList<>();
	}

	@Restricted(permissionName = "DeletePrasyarat")
    @Route(url="call/prasyarat/delete")
    public List<HashMap<String,Object>> deleteMataKuliah(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("id");
		UUID id = UUID.fromString(idStr);


		List<MataKuliah> mataKuliahList = mataKuliahService.deleteMataKuliah(id);
		return mataKuliahService.transformMataKuliahListToHashMap(mataKuliahList);
	}

}
