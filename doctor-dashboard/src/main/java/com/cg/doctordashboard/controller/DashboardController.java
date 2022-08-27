package com.cg.doctordashboard.controller;

import com.cg.doctordashboard.models.DrugsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/dash")
public class DashboardController {
    @Autowired
    RestTemplate restTemplate;
   @RequestMapping("/{drugsname}")
    public DrugsData getDrugsData(@PathVariable("drugsname")String drugsname) {

       return restTemplate.getForObject("http://Drugs-Info-Service/drugs/drugsname/" + drugsname, DrugsData.class);
    }

@RequestMapping("/all")
    public DrugsData[] getAllDrugsData(){
       // getting all the drugs name
//    ResponseEntity<Object[]> responseEntity =
//            restTemplate.getForEntity("http://Drugs-Info-Service/drugs/", Object[].class);
//        Object[] objects = responseEntity.getBody();
//        ObjectMapper mapper = new ObjectMapper();
//    return Arrays.stream(objects)
//            .map(object -> mapper.convertValue(object, DrugsData.class))
//            .map(DrugsData::getDrugName)
//            .collect(Collectors.toList());
 // for getting all the drugs data on dashboard
    ResponseEntity<DrugsData[]> response =
            restTemplate.getForEntity("http://Drugs-Info-Service/drugs/", DrugsData[].class);
           DrugsData[] drugsData = response.getBody();
            return (drugsData);
}
//    @RequestMapping("/")
//    public DrugsData getDrugsData() {
//        return restTemplate.getForObject("http://Drugs-Info-Service/drugs", DrugsData.class);
//    }
}
