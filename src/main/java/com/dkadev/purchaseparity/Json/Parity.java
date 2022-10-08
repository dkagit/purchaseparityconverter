package com.dkadev.purchaseparity.Json;

import java.math.BigDecimal;

public class Parity {
    private Indicator indicator;
    private Country country;
    private String countryiso3code;
    private Integer date;
    private BigDecimal value;
    private String unit;
    private String obs_status;
    private Integer decimal;

    public Parity(Indicator indicator, Country country, String countryiso3code, Integer date, BigDecimal value, String unit, String obs_status, Integer decimal) {
        this.indicator = indicator;
        this.country = country;
        this.countryiso3code = countryiso3code;
        this.date = date;
        this.value = value;
        this.unit = unit;
        this.obs_status = obs_status;
        this.decimal = decimal;
    }

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCountryiso3code() {
        return countryiso3code;
    }

    public void setCountryiso3code(String countryiso3code) {
        this.countryiso3code = countryiso3code;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getObs_status() {
        return obs_status;
    }

    public void setObs_status(String obs_status) {
        this.obs_status = obs_status;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return "Parity{" +
                "indicator=" + indicator +
                ", country=" + country +
                ", countryiso3code='" + countryiso3code + '\'' +
                ", date=" + date +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", obs_status='" + obs_status + '\'' +
                ", decimal=" + decimal +
                '}';
    }
}
