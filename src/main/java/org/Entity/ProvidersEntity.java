package org.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "providers", schema = "zoomarket")
public class ProvidersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "webSite", nullable = true, length = 45)
    private String webSite;
    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 45)
    private String phoneNumber;
    @Basic
    @Column(name = "officeAdress", nullable = true, length = 45)
    private String officeAdress;
    @OneToMany(mappedBy = "providersByProviderId", fetch = FetchType.LAZY)
    private Collection<AnimalsEntity> animalsById;
    @OneToMany(mappedBy = "providersByProviderId", fetch = FetchType.LAZY)
    private Collection<ProductsEntity> productsById;


    public long getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getOfficeAdress() {
        return officeAdress;
    }

    public void setOfficeAdress(String officeAdress) {
        this.officeAdress = officeAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvidersEntity that = (ProvidersEntity) o;

        if (ID != that.ID) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (webSite != null ? !webSite.equals(that.webSite) : that.webSite != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (officeAdress != null ? !officeAdress.equals(that.officeAdress) : that.officeAdress != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (ID ^ (ID >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (officeAdress != null ? officeAdress.hashCode() : 0);
        return result;
    }


    public Collection<AnimalsEntity> getAnimalsById() {
        return animalsById;
    }

    public void setAnimalsById(Collection<AnimalsEntity> animalsById) {
        this.animalsById = animalsById;
    }


    public Collection<ProductsEntity> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<ProductsEntity> productsById) {
        this.productsById = productsById;
    }
}
