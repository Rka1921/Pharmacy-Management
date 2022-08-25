package com.cg.UserService.Controllers;


import com.cg.UserService.Exception.ResourceNotFoundException;
import com.cg.UserService.Models.DoctorsData;
import com.cg.UserService.Service.DoctorDataService;
import com.cg.UserService.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    DoctorDataService doctorDataService;

    @GetMapping("/")
    public ResponseEntity<List<DoctorsData>> getAllDoctors() throws ResourceNotFoundException {
        List<DoctorsData> list = doctorDataService.getAllDoctors();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("There are no Doctors present in the database!");
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorsData> getDoctorsById(@PathVariable("id")   int doctorId) throws ResourceNotFoundException {
        Optional<DoctorsData> doctorsData = doctorDataService.getDoctorsById(doctorId);
        if (doctorsData.isEmpty()) {
            throw new ResourceNotFoundException("No Doctors found with id: " + doctorId);
        }
        return ResponseEntity.ok(doctorsData.get());
    }

    @PostMapping("/save")
    public ResponseEntity<DoctorsData> saveDoctorsData(@RequestBody DoctorsData doctorsData)  {
        doctorsData.setDoctorId((sequenceGeneratorService.getSequenceNumber(DoctorsData.SEQUENCE_NAME)));
        DoctorsData savedDoctorsData = doctorDataService.saveDoctorsData(doctorsData);
        return ResponseEntity.ok(savedDoctorsData);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorsData> updateDoctorsData(@RequestBody DoctorsData doctorsData ,
                                                            @PathVariable("id") int doctorId){
        DoctorsData updatedDoctorsData = doctorDataService.updateDoctorsData(doctorsData,doctorId);
        return  ResponseEntity.ok(updatedDoctorsData);
    }
    @PutMapping("/update/username/{email}")
    public ResponseEntity<DoctorsData> updateDoctorsData(@RequestBody DoctorsData doctorsData ,
                                                         @PathVariable("email") String email){
        DoctorsData updatedDoctorsData = doctorDataService.updateDoctorsData(doctorsData,email);
        return  ResponseEntity.ok(updatedDoctorsData);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDrugsData(@PathVariable("id") int doctorId) throws ResourceNotFoundException
    {
        Optional<DoctorsData> doctorsData = doctorDataService.getDoctorsById(doctorId);
        if(doctorsData.isEmpty()) {
            throw new ResourceNotFoundException("No Doctor found with id " + doctorId);
        }
        doctorDataService.deleteDoctorsData(doctorId);
    }

//   @GetMapping("/username/{email}")
//    public ResponseEntity<DoctorsData> getDoctorsDataByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
//
//        Optional<DoctorsData> doctorsData = doctorDataService.getDoctorsDataByEmail(email);
//        if (doctorsData.isEmpty()) {
//            throw new ResourceNotFoundException("No Doctors found with email: " + email);
//        }
//        return ResponseEntity.ok(doctorsData.get());
//
//    }





}
