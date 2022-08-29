package com.cg.UserService.secuirity.service;

import com.cg.UserService.Models.DoctorsData;
import com.cg.UserService.Repository.DoctorRepository;

//import com.cg.UserService.secuirity.model.SecUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//    @Autowired
//    private DoctorRepository doctorRepository;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        // TODO Auto-generated method stub
//        Optional<DoctorsData> doctorsData= doctorRepository.getDoctorsDataByEmail(email);
//        if(doctorsData == null){
//            throw new UsernameNotFoundException(email);
//        }else{
//           String username=doctorsData.get().getEmail();
//           String password=doctorsData.get().getDoctor_password();
//           return new User(username,password,new ArrayList<>());
//        }
//    }
    @Service
    public class MyUserDetailsService implements UserDetailsService {
        @Autowired
        DoctorRepository doctorRepository;
        @Override
        @Transactional
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//            User user = doctorRepository.getDoctorsDataByEmail(email)
//                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
//            return SecUserDetails.build(user);
            return new User("test@test","hello", new ArrayList<>());
        }
    }




