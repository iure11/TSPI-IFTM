package br.com.imobiliaria.controllers;

import br.com.imobiliaria.entities.EntitiesImovel;
import br.com.imobiliaria.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/imoveis")
public class ControllerImovel {

    @Autowired
    private ImovelService service;

    @GetMapping
    public ResponseEntity<List<EntitiesImovel>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntitiesImovel> findById(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EntitiesImovel> save(@RequestBody EntitiesImovel entitiesImovel) throws Exception{
        return ResponseEntity.ok().body(service.save(entitiesImovel));
    }

    @PutMapping
    public ResponseEntity<EntitiesImovel> update(@RequestBody EntitiesImovel entitiesImovel) throws Exception{
        return ResponseEntity.ok(service.update(entitiesImovel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
