package org.vedruna.pricing.domain.model;

import java.time.LocalDateTime;

public class Discount {

    private final Integer id;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Float discount;
    private final Price price;

    public Discount(Integer id, LocalDateTime startDate, LocalDateTime endDate, Float discount, Price price){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.price = price;
    }

    // Getters
    public Integer getId(){ return id; }
    public LocalDateTime getStartDate(){ return startDate; }
    public LocalDateTime getEndDate(){ return endDate; }
    public Float getDiscount(){ return discount; }
    public Price getPrice(){ return price; }


}
