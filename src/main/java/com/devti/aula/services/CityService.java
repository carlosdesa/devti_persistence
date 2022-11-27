package com.devti.aula.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.aula.model.City;
import com.devti.aula.repositories.CityRepository;



@Service
public class CityService {

    @Autowired
    CityRepository rep;
    
    
    public List<City> findByUf(String uf){
    	return rep.findByUf(uf);
    }
    
    public void remove(Integer id) {
    	City cRemove = rep.findById(id).get();
    	if (cRemove != null) {
			rep.delete(cRemove);
		}
    }

    public City insert(City c) {
        
        return rep.save(c);
    }

    public List<City> listAll() {
        return rep.findAll();
    }
    
    public City alter(City c) {
    	return rep.save(c);
    }
}
