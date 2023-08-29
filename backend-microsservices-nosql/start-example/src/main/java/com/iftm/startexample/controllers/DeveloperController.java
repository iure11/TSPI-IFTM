package com.iftm.startexample.controllers;

import com.iftm.startexample.repositories.DeveloperRepository;




import com.iftm.startexample.models.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developer")
public class DeveloperController {
    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@PathVariable String id) {
        return (Developer) developerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Developer createDeveloper(@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }

    @PutMapping
    public Developer updateDeveloper(@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeveloper(@PathVariable String id) {
        developerRepository.deleteById(id);
    }
}
