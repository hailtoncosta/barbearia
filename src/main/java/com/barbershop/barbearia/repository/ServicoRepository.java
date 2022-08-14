package com.barbershop.barbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barbershop.barbearia.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	@Query("select s from Servico s where s.descricao like %?1%")
	List<Servico> findServicoByName(String descricao);

}
