package com.cursapp.Entity;

import com.cursapp.DAO.ProviderDAO;
import com.cursapp.DAO.ProviderDAOImpl;
import com.cursapp.model.Product;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Proxy(lazy = false)
@Table(name = "products", schema = "zoomarket")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "receiptDate", nullable = true)
    private String receiptDate;
    @Basic
    @Column(name = "shelfLife", nullable = true)
    private String shelfLife;
    @ManyToOne
    @JoinColumn(name = "providerID", nullable = true)
    private ProvidersEntity providersByProviderId;

    public ProductsEntity(Product p){
        setName(p.getName());
        setPrice(new BigDecimal(Double.parseDouble(p.getPrice())));
        setReceiptDate(p.getReceiptDate());
        setShelfLife(p.getShelfLife());
        ProvidersEntity pe = new ProvidersEntity();
        pe.setId(Integer.parseInt(p.getProviderID()));
        setProvidersByProviderId(pe);
    }
    public ProductsEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }


    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (receiptDate != null ? !receiptDate.equals(that.receiptDate) : that.receiptDate != null) return false;
        if (shelfLife != null ? !shelfLife.equals(that.shelfLife) : that.shelfLife != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (receiptDate != null ? receiptDate.hashCode() : 0);
        result = 31 * result + (shelfLife != null ? shelfLife.hashCode() : 0);
        return result;
    }


    public ProvidersEntity getProvidersByProviderId() {
        return providersByProviderId;
    }

    public void setProvidersByProviderId(ProvidersEntity providersByProviderId) {
        this.providersByProviderId = providersByProviderId;
    }

}
