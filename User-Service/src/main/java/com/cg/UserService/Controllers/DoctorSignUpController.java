package com.cg.UserService.Controllers;

import com.cg.UserService.Models.DoctorsData;
import com.cg.UserService.Service.DoctorDataService;
import com.cg.UserService.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController

public class DoctorSignUpController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    DoctorDataService doctorDataService;
    @RequestMapping("/signup")
    public ResponseEntity<DoctorsData> saveDoctorsData(@RequestBody DoctorsData doctorsData) {
        doctorsData.setDoctorId((sequenceGeneratorService.getSequenceNumber(DoctorsData.SEQUENCE_NAME)));
        DoctorsData savedDoctorsData = doctorDataService.saveDoctorsData(doctorsData);
        return ResponseEntity.ok(savedDoctorsData);
    }

}
