package com.alfa.alfatestapp.dto;

import java.math.BigDecimal;
import java.util.Map;

public class CurrencyConversionBean {
    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String, BigDecimal> rates;

    public CurrencyConversionBean(String disclaimer, String license, String timestamp, String base, Map<String, BigDecimal> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;
    }

    public CurrencyConversionBean() {
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    /*
    {
    disclaimer: "Usage subject to terms: https://openexchangerates.org/terms",
    license: "https://openexchangerates.org/license",
    timestamp: 1341936000,
    base: "USD",
    rates: {
        AED: 3.672914,
        AFN: 48.337601,
        ALL: 111.863334
        /* ... */
}
