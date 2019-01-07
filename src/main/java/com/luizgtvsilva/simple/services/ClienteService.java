package com.luizgtvsilva.simple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgtvsilva.simple.domain.Cliente;
import com.luizgtvsilva.simple.repositories.ClienteRepository;
import com.luizgtvsilva.simple.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	
	//O Objetivo deste serviço é retornar o ID de Cliente
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	
}
