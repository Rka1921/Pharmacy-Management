package com.cg.DrugsInfoService.services;

import com.cg.DrugsInfoService.models.DrugsData;

import java.util.List;
import java.util.Optional;

public interface DrugService {
    DrugsData saveDrugsData(DrugsData drugsData);
    public List<DrugsData> getAllDrugsData();
    public Optional<DrugsData> findDrugsById(int drugId);

    DrugsData updateDrugsData(DrugsData drugsData, int drugId);

    // Optional<DrugsData> getDrugsById(int drugId);

    //    DrugsData updateDrugsData(DrugsData drugsData, int drugId);
    void deleteDrugsData(int drugId);
}
