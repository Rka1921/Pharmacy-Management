package com.cg.DrugsInfoService.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Drugs_Data")
public class DrugsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drugId;

    @Column(name = "Drug_Name")
    private String drugName;

    @Column(name = "Drug_Price")
    private double drugPrice;

    @Column(name = "Drug_Quantity")
    private int drugQuantity;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "Exp_Date")
    private LocalDate expiryDate;

    public DrugsData(int drugId, String drugName, double drugPrice, int drugQuantity, LocalDate expiryDate) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugPrice = drugPrice;
        this.drugQuantity = drugQuantity;
        this.expiryDate = expiryDate;
    }
    public DrugsData(){

    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
