package org.iftm.gerenciadorveterinarios.model.repository;

import org.iftm.gerenciadorveterinarios.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

   public List<Veterinario> findByNomeContains(String nome);
}
