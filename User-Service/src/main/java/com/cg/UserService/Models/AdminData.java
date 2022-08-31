package com.cg.UserService.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "AdminData")
public class AdminData {

//    private String adminName="admin";
//    private String admin_password="admin";
    @Id
    private int id;
    private String adminName;
    private String admin_password;
}