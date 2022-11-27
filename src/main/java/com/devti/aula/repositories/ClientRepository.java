package com.devti.aula.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devti.aula.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	public List<Client> findByCityName(String name);
}
