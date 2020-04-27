package com.luizgtvsilva.simple;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luizgtvsilva.simple.domain.Categoria;
import com.luizgtvsilva.simple.domain.Cidade;
import com.luizgtvsilva.simple.domain.Cliente;
import com.luizgtvsilva.simple.domain.Endereco;
import com.luizgtvsilva.simple.domain.Estado;
import com.luizgtvsilva.simple.domain.ItemPedido;
import com.luizgtvsilva.simple.domain.Pagamento;
import com.luizgtvsilva.simple.domain.PagamentoComBoleto;
import com.luizgtvsilva.simple.domain.PagamentoComCartao;
import com.luizgtvsilva.simple.domain.Pedido;
import com.luizgtvsilva.simple.domain.Produto;
import com.luizgtvsilva.simple.domain.enums.EstadoPagamento;
import com.luizgtvsilva.simple.domain.enums.TipoCliente;
import com.luizgtvsilva.simple.repositories.CategoriaRepository;
import com.luizgtvsilva.simple.repositories.CidadeRepository;
import com.luizgtvsilva.simple.repositories.ClienteRepository;
import com.luizgtvsilva.simple.repositories.EnderecoRepository;
import com.luizgtvsilva.simple.repositories.EstadoRepository;
import com.luizgtvsilva.simple.repositories.ItemPedidoRepository;
import com.luizgtvsilva.simple.repositories.PagamentoRepository;
import com.luizgtvsilva.simple.repositories.PedidoRepository;
import com.luizgtvsilva.simple.repositories.ProdutoRepository;

@SpringBootApplication
public class SimpleApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	}
}
