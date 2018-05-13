package com.cursapp.model;

import com.cursapp.DAO.ProviderDAO;
import com.cursapp.DAO.ProviderDAOImpl;
import com.cursapp.Entity.ProductsEntity;
import com.cursapp.Entity.ProvidersEntity;
import com.cursapp.service.ProviderServiceImpl;
import com.cursapp.service.interfaces.ProviderService;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String price;
    private String receiptDate;
    private String shelfLife;
    private String providerName;
    private String providerID;

    public Product(ProductsEntity pe){
        ProviderService providerService=new ProviderServiceImpl();
        id=pe.getId();
        name=pe.getName();
        price=String.valueOf(pe.getPrice());
        receiptDate=pe.getReceiptDate();
        shelfLife=pe.getShelfLife();
        if(pe.getProvidersByProviderId()!=null) {
            providerID = String.valueOf(pe.getProvidersByProviderId().getId());
        } else {
            providerID="";
        }
        /*
        product.setId(pe.getId());
        product.setName(pe.getName());
        product.setPrice(pe.getPrice().toString());
        product.setReceiptDate(pe.getReceiptDate());
        product.setShelfLife(pe.getShelfLife());
        product.setProviderID(String.valueOf(pe.getProvidersByProviderId().getId()));
        System.out.println("Provider ID: "+product.getProviderID());
        product.setProviderName(providerService.getProviderById(Integer.parseInt(product.getProviderID())).getName());
        System.out.println("Provider Name: "+product.getProviderName());
        */
    }
    public Product(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }
}
