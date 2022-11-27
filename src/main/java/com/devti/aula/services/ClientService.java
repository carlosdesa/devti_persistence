package com.devti.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.aula.model.Client;
import com.devti.aula.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository rep;
	
	public List<Client> listAll(){
		return rep.findAll();
	}
	
	public void remove(Integer id) {
		Client cRemove = rep.findById(id).get();
		if (cRemove != null) {
			rep.delete(cRemove);
		}
	}
	
	public Client insert(Client c) {
		return rep.save(c);
	}
	
	public Client alter(Client c) {
		return rep.save(c);
	}
	
	public List<Client> findByCity(String name){
		return rep.findByCityName(name);
	}
}
