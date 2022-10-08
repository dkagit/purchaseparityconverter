package com.dkadev.purchaseparity.Controllers;

import com.dkadev.purchaseparity.Services.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan
@RestController
@RequestMapping(path="/convert")
public class ConversionController {
    @Autowired
    ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping
    public String convert()
    {
        return this.conversionService.convert();
    }
}
