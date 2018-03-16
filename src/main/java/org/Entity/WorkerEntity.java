package org.Entity;

import javax.persistence.*;

@Entity
@Table(name = "workers", schema = "zoomarket")
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long ID;
    @Column(name="firstName")
    private String firstName;
    @Column(name="secondName")
    private String secondName;

    public long getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
