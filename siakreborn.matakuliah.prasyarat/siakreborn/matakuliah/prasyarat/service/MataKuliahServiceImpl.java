package siakreborn.matakuliah.prasyarat;

import java.util.*;
import java.util.logging.Logger;

import siakreborn.matakuliah.MataKuliahFactory;
import siakreborn.matakuliah.core.MataKuliahServiceDecorator;
import siakreborn.matakuliah.core.MataKuliahServiceComponent;
import siakreborn.matakuliah.core.MataKuliah;
import siakreborn.matakuliah.core.MataKuliahComponent;
import siakreborn.matakuliah.core.MataKuliahDecorator;
import siakreborn.kurikulum.core.Kurikulum;

public class MataKuliahServiceImpl extends MataKuliahServiceDecorator {
  private MataKuliahFactory mataKuliahFactory = new MataKuliahFactory();
	private static final Logger LOGGER = Logger.getLogger(MataKuliahResourceImpl.class.getName());

  public MataKuliahServiceImpl(MataKuliahServiceComponent record) {
    super(record);
  }

  public List<MataKuliah> saveMataKuliah(HashMap<String, Object> body) {
    try {
        String syarat = (String) body.get("syarat");
        String mataKuliahIdStr = (String) body.get("mataKuliahId");
        String parentMataKuliahIdStr = (String) body.get("parentMataKuliahId");

        LOGGER.info("Syarat: " + syarat);
        LOGGER.info("Mata Kuliah ID: " + mataKuliahIdStr);
        LOGGER.info("Parent Mata Kuliah ID: " + parentMataKuliahIdStr);

        MataKuliah parentMataKuliah = null;
        if (parentMataKuliahIdStr != null) {
            UUID parentMataKuliahId = UUID.fromString(parentMataKuliahIdStr);
            parentMataKuliah = mataKuliahRepository.getObject(parentMataKuliahId);
            LOGGER.info("Parent Mata Kuliah fetched successfully: " + parentMataKuliah);
        }

        MataKuliah mataKuliah = null;
        if (mataKuliahIdStr != null) {
            UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
            mataKuliah = mataKuliahRepository.getObject(mataKuliahId);
            LOGGER.info("Mata Kuliah fetched successfully: " + mataKuliah);
        }

        MataKuliah mataKuliahPrasyarat = mataKuliahFactory.createMataKuliah(
            "siakreborn.matakuliah.prasyarat.MataKuliahImpl", mataKuliah, syarat, parentMataKuliah);

        LOGGER.info("MataKuliah Prasyarat created: " + mataKuliahPrasyarat);

        mataKuliahRepository.saveObject(mataKuliahPrasyarat);

        LOGGER.info("MataKuliah saved successfully");

        return getAllMataKuliah();
    } catch (Exception e) {
        LOGGER.severe("Error in saveMataKuliah: " + e.getMessage());
        e.printStackTrace(); // Print stack trace for debugging
        return Collections.emptyList();
    }
}


  public MataKuliah updateMataKuliah(HashMap<String, Object> body) {
    String idStr = (String) body.get("id");
    UUID id = UUID.fromString(idStr);

    String syarat = (String) body.get("syarat");
    String mataKuliahIdStr = (String) body.get("mataKuliahId");
    String parentMataKuliahIdStr = (String) body.get("parentMataKuliahId");

    MataKuliah parentMataKuliah = null;
    if (parentMataKuliahIdStr != null) {
        UUID parentMataKuliahId = UUID.fromString(parentMataKuliahIdStr);
        parentMataKuliah = mataKuliahRepository.getObject(parentMataKuliahId);
        LOGGER.info("Parent Mata Kuliah fetched successfully: " + parentMataKuliah);
    }

    MataKuliah mataKuliah = null;
    if (mataKuliahIdStr != null) {
        UUID mataKuliahId = UUID.fromString(mataKuliahIdStr);
        mataKuliah = mataKuliahRepository.getObject(mataKuliahId);
        LOGGER.info("Mata Kuliah fetched successfully: " + mataKuliah);
    }

    MataKuliah savedMataKuliah = mataKuliahRepository.getObject(id);
    UUID recordMataKuliahId = ((MataKuliahDecorator) savedMataKuliah).getRecord().getId();

    MataKuliah mataKuliahPrasyarat = mataKuliahFactory.createMataKuliah(
      "siakreborn.matakuliah.prasyarat.MataKuliahImpl", id, mataKuliah, syarat, parentMataKuliah);

    LOGGER.info("MataKuliah Prasyarat updated: " + mataKuliahPrasyarat);

    mataKuliahRepository.updateObject(mataKuliahPrasyarat);
    mataKuliah = mataKuliahRepository.getObject(id);

    return mataKuliah;
  }

  public MataKuliah getMataKuliah(UUID id) {
    return record.getMataKuliah(id);
  }

  public List<MataKuliah> getAllMataKuliah() {
    List<MataKuliah> mataKuliahList = mataKuliahRepository.getAllObject("matakuliah_prasyarat");
    return mataKuliahList;
  }

  public List<MataKuliah> filterMataKuliah(String columnName, UUID id) {
    List<MataKuliah> mataKuliahList = mataKuliahRepository.getListObject("matakuliah_prasyarat", columnName, id);
    return mataKuliahList;
  }

  public List<MataKuliah> deleteMataKuliah(UUID id) {
    MataKuliah savedMataKuliah = mataKuliahRepository.getObject(id);
    LOGGER.info("id " + id);

    LOGGER.info("saved " + savedMataKuliah);
    
    UUID recordMataKuliahId = ((MataKuliahDecorator) savedMataKuliah).getRecord().getId();

    LOGGER.info("record" + recordMataKuliahId);
    mataKuliahRepository.deleteObject(id);
    mataKuliahRepository.deleteObject(recordMataKuliahId)
    mataKuliahRepository.deleteObject(savedMataKuliah)
    return getAllMataKuliah();
  }
}
