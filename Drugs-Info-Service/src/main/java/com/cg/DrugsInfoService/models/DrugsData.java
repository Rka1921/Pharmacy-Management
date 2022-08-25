package com.cg.DrugsInfoService.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

//import javax.persistence.*;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("DrugsData")
public class DrugsData {
    @Transient
    public static  final String SEQUENCE_NAME="user_sequence";

    @Id
    private int drugId;


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
