package com.konradg.task.models.DTO;

public class AirportInfoDTO {
    private Long numberOfDepartures;
    private Long numberOfArrivals;
    private Long baggageDepartures;
    private Long baggageArrivals;

    public AirportInfoDTO() {}

    public AirportInfoDTO(Long numberOfDepartures, Long numberOfArrivals, Long baggageDepartures, Long baggageArrivals) {
        this.numberOfDepartures = numberOfDepartures;
        this.numberOfArrivals = numberOfArrivals;
        this.baggageDepartures = baggageDepartures;
        this.baggageArrivals = baggageArrivals;
    }

    public Long getNumberOfDepartures() {
        return numberOfDepartures;
    }

    public void setNumberOfDepartures(Long numberOfDepartures) {
        this.numberOfDepartures = numberOfDepartures;
    }

    public Long getNumberOfArrivals() {
        return numberOfArrivals;
    }

    public void setNumberOfArrivals(Long numberOfArrivals) {
        this.numberOfArrivals = numberOfArrivals;
    }

    public Long getBaggageDepartures() {
        return baggageDepartures;
    }

    public void setBaggageDepartures(Long baggageDepartures) {
        this.baggageDepartures = baggageDepartures;
    }

    public Long getBaggageArrivals() {
        return baggageArrivals;
    }

    public void setBaggageArrivals(Long baggageArrivals) {
        this.baggageArrivals = baggageArrivals;
    }
}
