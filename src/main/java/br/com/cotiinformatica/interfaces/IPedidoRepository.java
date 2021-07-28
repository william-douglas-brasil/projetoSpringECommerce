package br.com.cotiinformatica.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Pedido;

public interface IPedidoRepository extends CrudRepository<Pedido, Integer> {
	
	//Query JPQL para trazer todos os pedidos feito por um Cliente
	@Query("from Pedido p join p.cliente c where c.idCliente = :pIdCliente")
	List<Pedido> findByCliente(@Param("pIdCliente") Integer idCliente);

}
