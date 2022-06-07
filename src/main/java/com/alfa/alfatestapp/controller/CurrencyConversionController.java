package com.alfa.alfatestapp.controller;

import com.alfa.alfatestapp.proxy.GiphyServiceProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class CurrencyConversionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Autowired
    private CurrencyExchangeServiceProxy proxy;*/
    @Autowired
    private GiphyServiceProxy giphyServiceProxy;

    @GetMapping("/api/historical/{from}")
    public ModelAndView convertCurrencyFeign(@PathVariable String from, HttpServletRequest request) throws JsonProcessingException {
        //CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from);
        //return response.getRates().get("RUB");
        JsonNode gif = giphyServiceProxy.getGif(from);
        JsonNode data= gif.get("data");
        JsonNode images = data.get("images");
        JsonNode hd = images.get("original_mp4");
        JsonNode mp4 = hd.get("mp4");

        String string = new ObjectMapper().writeValueAsString(mp4);
        //return "forward:" + request.getScheme() + string.substring(1, string.length()-1);
        return new ModelAndView("redirect:" + string.substring(1, string.length()-1));
    }
}
