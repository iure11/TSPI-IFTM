package br.com.imobiliaria.services;

import br.com.imobiliaria.entities.EntitiesImovel;
import br.com.imobiliaria.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository repository;

    @Cacheable(value = "imoveis")
    public List<EntitiesImovel> findAll(){
        return repository.findAll();
    }

    @Cacheable(value = "imoveis", key = "#id")
    public EntitiesImovel findById(UUID id) throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("Imóvel com ID " + id + " não encontrado."));
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public EntitiesImovel save(EntitiesImovel imovel) throws Exception {
        if(imovel == null)
            throw new IllegalArgumentException("O imóvel não pode ser nulo.");
        return repository.save(imovel);
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public EntitiesImovel update(EntitiesImovel imovelAtualizado) throws Exception{
        if(imovelAtualizado.getId() == null)
            throw new IllegalArgumentException("O ID do imóvel não pode ser nulo.");

        EntitiesImovel imovelExistente = repository.findById(imovelAtualizado.getId())
                .orElseThrow(() -> new Exception("Imóvel com ID " + imovelAtualizado.getId() + " não encontrado."));

        imovelExistente.setEndereco(imovelAtualizado.getEndereco());
        imovelExistente.setTipo_imovel(imovelAtualizado.getTipo_imovel());
        imovelExistente.setArea(imovelAtualizado.getArea());
        imovelExistente.setPreco(imovelAtualizado.getPreco());

        return repository.save(imovelExistente);
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public void delete(UUID id) throws Exception {
        if(!repository.existsById(id)){
            throw new Exception("Imóvel com ID " + id + " não existe e não pode ser deletado.");
        }
        repository.deleteById(id);
    }
}
