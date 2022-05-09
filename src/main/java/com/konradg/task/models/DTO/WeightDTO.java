package com.konradg.task.models.DTO;

public class WeightDTO {
    private Long baggageWeight;
    private Long cargoWeight;
    private Long totalWeight;

    public WeightDTO() {
    }

    public WeightDTO(Long baggageWeight, Long cargoWeight, Long totalWeight) {
        this.baggageWeight = baggageWeight;
        this.cargoWeight = cargoWeight;
        this.totalWeight = totalWeight;
    }


    public Long getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(Long baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public Long getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Long cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }
}
