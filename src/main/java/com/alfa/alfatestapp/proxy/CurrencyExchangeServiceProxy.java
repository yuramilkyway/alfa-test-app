package com.alfa.alfatestapp.proxy;

import com.alfa.alfatestapp.dto.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex-service", url="https://openexchangerates.org")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/api/historical/{from}.json?app_id=" + ("${openexchangerates.app.id}"))
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from);
}