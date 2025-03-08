package siakreborn.rencanastudi.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface KelasMahasiswaResource {
    List<HashMap<String,Object>> saveKelasMahasiswa(VMJExchange vmjExchange);
    HashMap<String, Object> updateKelasMahasiswa(VMJExchange vmjExchange);
    HashMap<String, Object> getKelasMahasiswa(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllKelasMahasiswa(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteKelasMahasiswa(VMJExchange vmjExchange);
}
