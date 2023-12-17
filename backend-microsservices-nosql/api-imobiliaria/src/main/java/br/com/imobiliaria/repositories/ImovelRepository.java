package br.com.imobiliaria.repositories;

import br.com.imobiliaria.entities.EntitiesImovel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImovelRepository extends CassandraRepository<EntitiesImovel, UUID> {
}
