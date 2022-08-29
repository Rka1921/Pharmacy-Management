//package com.cg.UserService.secuirity.model;
//
//import com.cg.UserService.Models.DoctorsData;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Optional;
//
//public class SecUserDetails implements UserDetails {
//    private Optional<DoctorsData> doctorsData;
//
//    public static SecUserDetails build(User user) {
////        List<GrantedAuthority> authorities = user.getRoles().stream()
////                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
////                .collect(Collectors.toList());
//        return new SecUserDetails(
//                //user.getId(),
//                user.getUsername(),
//                //user.getEmail(),
//                user.getPassword(),
//                authorities);
//    }
//
//    public SecUserDetails(Optional<DoctorsData> doctorsData) {
//       this.doctorsData=doctorsData;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
