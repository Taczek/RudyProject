package com.Taczek.RudyProject.train;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table
public class Train {
    @Id
    @SequenceGenerator(
            name = "train_sequence",
            sequenceName = "train_sequence",
            allocationSize =  1
    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "train_sequence"
//    )

    private Long id;
    private String owner;
    private String number;
    private String type;
    private LocalDate lastMaintain;

    @Transient //calculate dflm
    private Integer dflm; //days from last maintain

    public Train(Long id, String owner, String number, String type, LocalDate lastMaintain) {
        this.id = id;
        this.owner = owner;
        this.number = number;
        this.type = type;
        this.lastMaintain = lastMaintain;
    }

    public Train() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getLastMaintain() {
        return lastMaintain;
    }

    public void setLastMaintain(LocalDate lastMaintain) {
        this.lastMaintain = lastMaintain;
    }

    public Integer getDflm() {
        return (int) ChronoUnit.DAYS.between(this.lastMaintain, LocalDate.now());
    }

    public void setDflm(Integer dflm) {
        this.dflm = dflm;
    }



    @Override
    public String toString() {
        return "Train{" +
                " id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", lastMaintain=" + lastMaintain +
                '}';
    }
}
