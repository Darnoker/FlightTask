package com.konradg.task.models;



import com.sun.istack.NotNull;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cargo {

    @Id
    private Long flightId;

    @Column
    @NotNull
    @OneToMany(cascade=CascadeType.ALL)
    private List<BaggageObject> baggage;

    @Column
    @NotNull
    @OneToMany(cascade=CascadeType.ALL)
    private List<CargoObject> cargo;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public List<BaggageObject> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<BaggageObject> baggage) {
        this.baggage = baggage;
    }

    public List<CargoObject> getCargo() {
        return cargo;
    }

    public void setCargo(List<CargoObject> cargo) {
        this.cargo = cargo;
    }
}
