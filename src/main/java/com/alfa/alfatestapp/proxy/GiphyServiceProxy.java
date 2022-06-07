package com.alfa.alfatestapp.proxy;

import com.alfa.alfatestapp.dto.CurrencyConversionBean;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="giphy-service", url="https://api.giphy.com")
public interface GiphyServiceProxy {
    @GetMapping("/v1/gifs/random?api_key=cKDkKF28vJveiyHqA3qep9JcAoOzE9Y1&tag={from}&rating=g")
    public Response getGif(@PathVariable("from") String from);
}

