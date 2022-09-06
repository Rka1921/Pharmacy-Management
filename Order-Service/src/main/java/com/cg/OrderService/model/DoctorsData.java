package com.cg.OrderService.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

//@Document(collection = "DoctorsData")
public class DoctorsData {

//    @Transient
//    public static final String SEQUENCE_NAME="user-sequence";

//    @Id
//    private int doctorId;
    private String name;
    private String phNo;
    private int exp;

    @NotNull(message = "required")
    private String email;

//    @NotNull
//    @Size(min=4, message = "Password must be 4 characters long")
//    private String doctor_password;


   // private List<Order> orders;

}
