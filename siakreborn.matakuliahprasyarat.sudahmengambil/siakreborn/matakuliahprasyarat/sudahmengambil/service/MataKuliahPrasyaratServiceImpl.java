package siakreborn.matakuliahprasyarat.sudahmengambil;

import java.util.*;
import java.util.logging.Logger;

import siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratServiceDecorator;
import siakreborn.matakuliahprasyarat.core.MataKuliahPrasyaratServiceComponent;

public class MataKuliahPrasyaratServiceImpl extends MataKuliahPrasyaratServiceDecorator {
	private static final Logger LOGGER = Logger.getLogger(MataKuliahPrasyaratServiceImpl.class.getName());

    public MataKuliahPrasyaratServiceImpl(MataKuliahPrasyaratServiceComponent record) {
        super(record);
    }

    public HashMap<String, String> listSyarat() {
        HashMap<String, String> syaratList = new HashMap<>();
        syaratList.put("0", "Sudah Lulus");
        syaratList.put("1", "Sudah Mengambil");
        LOGGER.info("SyaratList: " + syaratList);
        return syaratList;
    }
}