package com.cg.DrugsInfoService.controllers;

import com.cg.DrugsInfoService.exception.ResourceNotFoundException;
import com.cg.DrugsInfoService.models.DrugsData;
import com.cg.DrugsInfoService.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drugs")
public class DrugsController {

    @Autowired
    DrugService drugService;

    @GetMapping("/")
    public ResponseEntity<List<DrugsData>> getAllDrugsData() throws ResourceNotFoundException {
        List<DrugsData> list = drugService.getAllDrugsData();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("There are no medicines present in the database!");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugsData> findDrugsById(@PathVariable("id") int drugId) throws ResourceNotFoundException {
        Optional<DrugsData> drugsDataOptional = drugService.findDrugsById(drugId);
        if (drugsDataOptional.isEmpty()) {
            throw new ResourceNotFoundException("No medicine found with id: " + drugId);
        }
        return ResponseEntity.ok(drugsDataOptional.get());
    }

    @PostMapping("/save")
    public ResponseEntity<DrugsData> saveDrugs(@RequestBody DrugsData drugsData) {
        DrugsData savedDrugsData = drugService.saveDrugsData(drugsData);
        return ResponseEntity.ok(savedDrugsData);
    }

    //update function
    @PutMapping("/update/{id}")
    public ResponseEntity<DrugsData> updateDrugsData(@RequestBody DrugsData drugsData ,
                                                     @PathVariable("id") int drugId){
        DrugsData updatedDrugsData = drugService.updateDrugsData(drugsData,drugId);
        return  ResponseEntity.ok(updatedDrugsData);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteDrugsData(@PathVariable("id") int drugId) throws ResourceNotFoundException
    {
        Optional<DrugsData> drugsData = drugService.findDrugsById(drugId);
        if(drugsData.isEmpty()) {
            throw new ResourceNotFoundException("No medicine found with id " + drugId);
        }
        drugService.deleteDrugsData(drugId);
    }

}
