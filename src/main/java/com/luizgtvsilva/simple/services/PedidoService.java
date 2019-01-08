package com.luizgtvsilva.simple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizgtvsilva.simple.domain.Pedido;
import com.luizgtvsilva.simple.repositories.PedidoRepository;
import com.luizgtvsilva.simple.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	
	//O Objetivo deste serviço é retornar o ID de Pedido
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Pedido.class.getName()));
		}
	
}
