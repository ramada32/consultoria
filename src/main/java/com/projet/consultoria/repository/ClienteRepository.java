package com.projet.consultoria.repository;

import com.projet.consultoria.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes,Integer> {

    Iterable<Clientes> findByName(String name);
}
