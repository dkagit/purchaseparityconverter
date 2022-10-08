package com.dkadev.purchaseparity.Json;

import java.math.BigDecimal;

public class CoreData {
    private String country;
    private Integer year;
    private BigDecimal parityValue;

    public CoreData(String country, Integer year, BigDecimal parityValue) {
        this.country = country;
        this.year = year;
        this.parityValue = parityValue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getParityValue() {
        return parityValue;
    }

    public void setParityValue(BigDecimal parityValue) {
        this.parityValue = parityValue;
    }
}
