package com.alfa.alfatestapp.controller;

import com.alfa.alfatestapp.proxy.GiphyServiceProxy;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Autowired
    private CurrencyExchangeServiceProxy proxy;*/
    @Autowired
    private GiphyServiceProxy giphyServiceProxy;

    @GetMapping("/api/historical/{from}")
    public Response convertCurrencyFeign(@PathVariable String from) {
        //CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from);
        //return response.getRates().get("RUB");
        Response gif = giphyServiceProxy.getGif(from);
        return gif;
    }
}
