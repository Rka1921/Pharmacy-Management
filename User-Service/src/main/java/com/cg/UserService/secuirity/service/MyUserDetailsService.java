package com.cg.UserService.secuirity.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cg.UserService.Models.DoctorsData;
import com.cg.UserService.Repository.DoctorRepository;

//import com.cg.UserService.secuirity.model.SecUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        List<SimpleGrantedAuthority> roles = null;
        Optional<DoctorsData> doctorsData= doctorRepository.getDoctorsDataByEmail(email);
        if(doctorsData == null){
            throw new UsernameNotFoundException(email);
        }
//        else{
//           String username=doctorsData.get().getEmail();
//           String password=doctorsData.get().getDoctor_password();
//           return new User(username,password,new ArrayList<>());
//        }

        else {
        //checking for Admin Role
        if (email.equals("admin"))
        {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            System.out.println("admin authenticated successfully");
            return new User("admin", "admin", roles);

        }
        //checking for User Role
        else
        {
            String username = doctorsData.get().getEmail();
            String password = doctorsData.get().getDoctor_password();
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(username, password, roles);
        }
    }
}
    }
//    @Service
//    public class MyUserDetailsService implements UserDetailsService {
//        @Autowired
//        DoctorRepository doctorRepository;
//        @Override
//        @Transactional
//        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////            User user = doctorRepository.getDoctorsDataByEmail(email)
////                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
////            return SecUserDetails.build(user);
////            return new User("test@test","hello", new ArrayList<>());
//        }





