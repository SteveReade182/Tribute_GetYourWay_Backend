package com.qa.cardatabase.data.entity.Flight;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price {
    @JsonProperty("formatted")
    private String formattedPrice;

    // getters and setters


    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }
}
