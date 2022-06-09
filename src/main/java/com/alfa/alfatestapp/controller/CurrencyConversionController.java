package com.alfa.alfatestapp.controller;

import com.alfa.alfatestapp.proxy.GiphyServiceProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Controller
public class CurrencyConversionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Autowired
    private CurrencyExchangeServiceProxy proxy;*/
    @Autowired
    private GiphyServiceProxy giphyServiceProxy;

    @GetMapping("/api/historical/{from}")
    public @ResponseBody byte[] convertCurrencyFeign(@PathVariable String from, Model model) throws IOException {
        //CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from);
        //return response.getRates().get("RUB");
        JsonNode gif = giphyServiceProxy.getGif(from);
        JsonNode data= gif.get("data");
        JsonNode images = data.get("images");
        JsonNode hd = images.get("original_mp4");
        JsonNode mp4 = hd.get("mp4");

        String string = new ObjectMapper().writeValueAsString(mp4);
        String gifUrl = string.substring(1, string.length()-1);

        //return "forward:" + request.getScheme() + string.substring(1, string.length()-1);
        //return new ModelAndView("redirect:" + url);

        /*BufferedInputStream bufferedImage = new BufferedInputStream(new URL(gifUrl).openStream());

        model.addAttribute("gif", bufferedImage);
        return "main";*/

        BufferedInputStream in = new BufferedInputStream(new URL(gifUrl).openStream());

        in.readAllBytes();
        return in.readAllBytes();
    }
}
