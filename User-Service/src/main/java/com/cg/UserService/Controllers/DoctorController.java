package com.cg.UserService.Controllers;


import com.cg.UserService.Exception.ResourceNotFoundException;
import com.cg.UserService.Models.DoctorsData;
import com.cg.UserService.Models.DrugsData;
import com.cg.UserService.Service.DoctorDataService;
import com.cg.UserService.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/doctors")
public class DoctorController {
@Autowired
    RestTemplate restTemplate;
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    DoctorDataService doctorDataService;

//    @GetMapping("/")
//    public ResponseEntity<List<DoctorsData>> getAllDoctors() throws ResourceNotFoundException {
//        List<DoctorsData> list = doctorDataService.getAllDoctors();
//        if (list.isEmpty()) {
//            throw new ResourceNotFoundException("There are no Doctors present in the database!");
//        }
//        return ResponseEntity.ok(list);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<DoctorsData> getDoctorsById(@PathVariable("id")   int doctorId) throws ResourceNotFoundException {
//        Optional<DoctorsData> doctorsData = doctorDataService.getDoctorsById(doctorId);
//        if (doctorsData.isEmpty()) {
//            throw new ResourceNotFoundException("No Doctors found with id: " + doctorId);
//        }
//        return ResponseEntity.ok(doctorsData.get());
//    }


    //    @PutMapping("/update/{id}")
//    public ResponseEntity<DoctorsData> updateDoctorsData(@RequestBody DoctorsData doctorsData ,
//                                                            @PathVariable("id") int doctorId){
//        DoctorsData updatedDoctorsData = doctorDataService.updateDoctorsData(doctorsData,doctorId);
//        return  ResponseEntity.ok(updatedDoctorsData);
//    }
    @PutMapping("/update/username/{email}")
    public ResponseEntity<DoctorsData> updateDoctorsData(@RequestBody DoctorsData doctorsData,
                                                         @PathVariable("email") String email) {
        DoctorsData updatedDoctorsData = doctorDataService.updateDoctorsData(doctorsData, email);
        return ResponseEntity.ok(updatedDoctorsData);
    }

    @GetMapping("/username/{email}")
    public ResponseEntity<DoctorsData> getDoctorsDataByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {

        Optional<DoctorsData> doctorsData = doctorDataService.getDoctorsDataByEmail(email);
        if (doctorsData.isEmpty()) {
            throw new ResourceNotFoundException("No Doctors found with email: " + email);
        }
        return ResponseEntity.ok(doctorsData.get());

    }
//************************* DRUGS DATA *************************************
    @RequestMapping("/drugs/all")
    public DrugsData[] getAllDrugsData(){
        ResponseEntity<DrugsData[]> response =
                restTemplate.getForEntity("http://Drugs-Info-Service/api/drugs/", DrugsData[].class);
        DrugsData[] drugsData = response.getBody();
        return (drugsData);
    }
    @GetMapping("/drugs/{drugsname}")
    public DrugsData getDrugsData (@PathVariable("drugsname") String drugsname){

        return restTemplate.getForObject("http://Drugs-Info-Service/api/drugs/drugsname/" + drugsname, DrugsData.class);
    }
//    @RequestMapping("/drugs/")
//    public double getDrugsData(){
//        DrugsData response =
//                restTemplate.getForObject("http://Drugs-Info-Service/drugs/", DrugsData.class);
//        double drugsData = response.getDrugPrice();
//        return (drugsData);
    }



