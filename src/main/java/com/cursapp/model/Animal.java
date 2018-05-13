package com.cursapp.model;

import com.cursapp.Entity.AnimalsEntity;

import java.math.BigDecimal;

public class Animal {
    private int id;
    private String kind;
    private BigDecimal weight;
    private int age;
    private String receiptDate;
    private BigDecimal price;
    private int providerID;
    private String providerName;

    public Animal(AnimalsEntity ae) {
        this.id = ae.getAnimalId();
        this.kind = ae.getKind();
        this.weight = ae.getWeight();
        this.age = ae.getAge();
        this.receiptDate = ae.getReceiptDate();
        this.price = ae.getPrice();
        if(ae.getProvidersByProviderId()!=null) {
            providerID = ae.getProvidersByProviderId().getId();
        } else {
            providerID=-1;
        }
    }
    public Animal(){}

    public int getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getProviderID() {
        return providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setAnimalId(int animalId) {
        this.id = animalId;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
