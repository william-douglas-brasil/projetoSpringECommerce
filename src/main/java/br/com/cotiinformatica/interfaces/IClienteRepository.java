package br.com.cotiinformatica.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer> {

	@Query("from Cliente c join c.endereco e where c.email = :pEmail")
	Cliente findByEmail(@Param("pEmail") String email);
	
	@Query("from Cliente c join c.endereco e where c.email = :pEmail and c.senha = :pSenha")
	Cliente findByEmailAndSenha(@Param("pEmail") String email, @Param("pSenha") String senha);
}
