package org.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "animals", schema = "zoomarket")
public class AnimalsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalID")
    private int animalId;

    @Basic
    @Column(name = "kind", nullable = true)
    private Long kind;

    @Basic
    @Column(name = "weight", nullable = true, precision = 2)
    private BigDecimal weight;
    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;
    @Basic
    @Column(name = "receiptDate", nullable = true)
    private Date receiptDate;
    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providerID")
    private ProvidersEntity providersByProviderId;

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }


    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
        this.kind = kind;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalsEntity that = (AnimalsEntity) o;

        if (animalId != that.animalId) return false;
        if (providersByProviderId.equals(that.providersByProviderId)) return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (receiptDate != null ? !receiptDate.equals(that.receiptDate) : that.receiptDate != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (animalId ^ (animalId >>> 32));
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (receiptDate != null ? receiptDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (int) (providersByProviderId.hashCode() ^ (providersByProviderId.hashCode() >>> 32));
        return result;
    }
}
