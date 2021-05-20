package com.codegym.demo.controller;

import com.codegym.demo.model.Smartphone;
import com.codegym.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView model = new ModelAndView("/phones/list");
        model.addObject("smartphones", smartphoneService.findAll());
        return model;
    }

    @GetMapping
    public ResponseEntity<List<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Smartphone smartphoneOptional = smartphoneService.findById(id);
        if (smartphoneOptional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editSmartPhone(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/phones/edit");
        Smartphone smartphone = smartphoneService.findById(id);
        modelAndView.addObject("smartPhone", smartphone);
        return  modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Smartphone> editSmartPhone(@PathVariable Long id,@RequestBody Smartphone smartphone){
        smartphone.setId(id);
        return new ResponseEntity<>(smartphoneService.save(smartphone),HttpStatus.OK);
    }
}
