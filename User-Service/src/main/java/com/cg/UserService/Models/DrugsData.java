package com.cg.UserService.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Document("DrugsData")
public class DrugsData {
//    @Transient
//    public static  final String SEQUENCE_NAME="user_sequence";

//    @Id

    private  int drugId;

    private String drugName;


    private double drugPrice;


    private int drugQuantity;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")

    private LocalDate expiryDate;

//    public DrugsData(int drugId, String drugName, double drugPrice, int drugQuantity, LocalDate expiryDate) {
//        this.drugId = drugId;
//        this.drugName = drugName;
//        this.drugPrice = drugPrice;
//        this.drugQuantity = drugQuantity;
//        this.expiryDate = expiryDate;
//    }
//    public DrugsData(){
//
//    }
//
//    public int getDrugId() {
//        return drugId;
//    }
//
//    public void setDrugId(int drugId) {
//        this.drugId = drugId;
//    }
//
//    public String getDrugName() {
//        return drugName;
//    }
//
//    public void setDrugName(String drugName) {
//
//        this.drugName = drugName;
//    }
//
//    public double getDrugPrice() {
//        return drugPrice;
//    }
//
//    public void setDrugPrice(double drugPrice) {
//        this.drugPrice = drugPrice;
//    }
//
//    public int getDrugQuantity() {
//        return drugQuantity;
//    }
//
//    public void setDrugQuantity(int drugQuantity) {
//
//        this.drugQuantity = drugQuantity;
//    }
//
//    public LocalDate getExpiryDate() {
//
//        return expiryDate;
//    }
//
//    public void setExpiryDate(LocalDate expiryDate) {
//
//        this.expiryDate = expiryDate;
//    }
}
