package com.devti.aula.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devti.aula.model.City;



@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
    
	public List<City> findByUf(String uf);
}
