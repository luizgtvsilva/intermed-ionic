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
import com.luizgtvsilva.simple.repositories.PagamentoRepository;
import com.luizgtvsilva.simple.repositories.PedidoRepository;
import com.luizgtvsilva.simple.repositories.ProdutoRepository;

@SpringBootApplication
public class SimpleApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Instância de Categoria e Produto
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		//Instância de Estado e Cidade
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Instância de Cliente e Endereço
		Cliente cli1 = new Cliente(null, "Aline Martini", "alinemartini@hotmail.com", "12642100803", TipoCliente.PESSOAFISICA);
				cli1.getTelefones().addAll(Arrays.asList("1188888888", "1188888889"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "03434050", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Mattos", "185", "Sala 800", "Centro", "03435070", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		//Instância de Pagamento e Pedido
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2018 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2018 11:37"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), sdf.parse("25/10/2018 02:22"));
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		
	}

}

