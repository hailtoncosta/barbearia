package com.barbershop.barbearia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barbershop.barbearia.model.Agendamento;

@Repository
@Transactional
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
	@Query("select a from Agendamento a where a.cliente like %?1%")
	List<Agendamento> findAgendamentoByName(String cliente);

}
