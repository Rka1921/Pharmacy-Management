package com.cg.UserService.Controllers;

import com.cg.UserService.Models.DoctorsData;
import com.cg.UserService.Service.DoctorDataService;
import com.cg.UserService.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class DoctorSignUpController {

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    DoctorDataService doctorDataService;
    @PostMapping("/user")
    public ResponseEntity<DoctorsData> saveDoctorsData(@RequestBody DoctorsData doctorsData) {
        doctorsData.setDoctorId((sequenceGeneratorService.getSequenceNumber(DoctorsData.SEQUENCE_NAME)));
        DoctorsData savedDoctorsData = doctorDataService.saveDoctorsData(doctorsData);
        return ResponseEntity.ok(savedDoctorsData);
    }

}
