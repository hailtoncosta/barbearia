package com.barbershop.barbearia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbershop.barbearia.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
