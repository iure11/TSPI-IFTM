package com.iftm.startexample.services;



import com.iftm.startexample.models.Developer;
import com.iftm.startexample.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Optional<Object> getDeveloperById(String id) {
        return developerRepository.findById(id);
    }

    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer updateDeveloper(String id, Developer developer) {
        if (developerRepository.existsById(id)) {
            developer.setId(id);
            return developerRepository.save(developer);
        }
        return null;
    }

    public void deleteDeveloperById(String id) {
        developerRepository.deleteById(id);
    }
}
