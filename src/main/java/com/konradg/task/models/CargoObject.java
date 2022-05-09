package com.konradg.task.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cargo_object")
public class CargoObject {

    public CargoObject() {
    }

    public CargoObject(Long weight, String weightUnit, Long pieces) {
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.pieces = pieces;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long weight;

    @Column
    private String weightUnit;

    @Column
    private Long pieces;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Long getPieces() {
        return pieces;
    }

    public void setPieces(Long pieces) {
        this.pieces = pieces;
    }
}
