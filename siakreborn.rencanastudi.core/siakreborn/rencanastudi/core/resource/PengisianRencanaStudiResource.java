package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PengisianRencanaStudiResource {
    List<HashMap<String,Object>> savePengisianRencanaStudi(VMJExchange vmjExchange);
    HashMap<String, Object> updatePengisianRencanaStudi(VMJExchange vmjExchange);
    HashMap<String, Object> getPengisianRencanaStudi(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPengisianRencanaStudi(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deletePengisianRencanaStudi(VMJExchange vmjExchange);
}
