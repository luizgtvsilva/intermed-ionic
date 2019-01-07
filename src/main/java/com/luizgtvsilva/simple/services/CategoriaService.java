package com.luizgtvsilva.simple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgtvsilva.simple.domain.Categoria;
import com.luizgtvsilva.simple.repositories.CategoriaRepository;
import com.luizgtvsilva.simple.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	
	//O Objetivo deste serviço é retornar o ID de Categoria
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
		}
	
}
