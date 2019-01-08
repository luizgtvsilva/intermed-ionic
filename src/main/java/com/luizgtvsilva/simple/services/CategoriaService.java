package com.luizgtvsilva.simple.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.luizgtvsilva.simple.domain.Categoria;
import com.luizgtvsilva.simple.repositories.CategoriaRepository;
import com.luizgtvsilva.simple.services.exception.DataIntegrityException;
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
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possível excluir uma Categoria que possui Produtos");
		}
		
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
}
