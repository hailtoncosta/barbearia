package com.barbershop.barbearia.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barbershop.barbearia.model.Servico;

@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	@Query("select s from Servico s where s.descricao like %?1%")
	List<Servico> findServicoByName(String descricao);
	
	default Page<Servico> findServicoByNamePage(String descricao, Pageable pageable) {
		
		Servico servico = new Servico();
		servico.setDescricao(descricao);
		
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		
		Example<Servico> example = Example.of(servico, exampleMatcher);
		
		Page<Servico> servicos = findAll(example, pageable);
		
		return servicos;
	}
}
