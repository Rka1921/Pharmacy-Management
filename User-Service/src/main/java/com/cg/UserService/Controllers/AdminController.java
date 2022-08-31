package com.cg.UserService.Controllers;

import com.cg.UserService.Exception.ResourceNotFoundException;
import com.cg.UserService.Models.DoctorsData;
import com.cg.UserService.Service.DoctorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DoctorDataService doctorDataService;

    @GetMapping("/alldoctors")
    public ResponseEntity<List<DoctorsData>> getAllDoctors() throws ResourceNotFoundException {
        List<DoctorsData> list = doctorDataService.getAllDoctors();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("There are no Doctors present in the database!");
        }
        return ResponseEntity.ok(list);
    }
    @PutMapping("/doctors/update/{id}")
    public ResponseEntity<DoctorsData> updateDoctorsData(@RequestBody DoctorsData doctorsData ,
                                                         @PathVariable("id") int doctorId){
        DoctorsData updatedDoctorsData = doctorDataService.updateDoctorsData(doctorsData,doctorId);
        return  ResponseEntity.ok(updatedDoctorsData);
    }
    @DeleteMapping("/doctors/delete/{id}")
    public void deleteDoctorsData(@PathVariable("id") int doctorId) throws ResourceNotFoundException
    {
        Optional<DoctorsData> doctorsData = doctorDataService.getDoctorsById(doctorId);
        if(doctorsData.isEmpty()) {
            throw new ResourceNotFoundException("No Doctor found with id " + doctorId);
        }
        doctorDataService.deleteDoctorsData(doctorId);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DoctorsData> getDoctorsById(@PathVariable("id")   int doctorId) throws ResourceNotFoundException {
        Optional<DoctorsData> doctorsData = doctorDataService.getDoctorsById(doctorId);
        if (doctorsData.isEmpty()) {
            throw new ResourceNotFoundException("No Doctors found with id: " + doctorId);
        }
        return ResponseEntity.ok(doctorsData.get());
    }

}