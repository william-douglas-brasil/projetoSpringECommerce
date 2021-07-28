package br.com.cotiinformatica.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.dtos.auth.AuthGetDTO;
import br.com.cotiinformatica.dtos.auth.AuthPostDTO;
import br.com.cotiinformatica.dtos.clientes.ClienteGetDTO;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.interfaces.IClienteRepository;
import br.com.cotiinformatica.security.Cryptography;
import br.com.cotiinformatica.security.JwtToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@Transactional
public class AuthController {

	private static final String ENDPOINT = "/api/auth";

	@Autowired
	private IClienteRepository clienteRepository;

	@CrossOrigin
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<AuthGetDTO> post(@RequestBody AuthPostDTO dto) {

		try {

			Cliente cliente = clienteRepository.findByEmailAndSenha(dto.getEmail(),
					Cryptography.criptografar(dto.getSenha()));

			if (cliente == null) { // não foi encontrado..
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			}

			AuthGetDTO result = new AuthGetDTO();
			result.setAccessToken(JwtToken.generateToken(cliente.getEmail()));
			result.setMensagem("Usuário autenticado com sucesso.");

			result.setCliente(new ClienteGetDTO());
			result.getCliente().setIdCliente(cliente.getIdCliente());
			result.getCliente().setNome(cliente.getNome());
			result.getCliente().setEmail(cliente.getEmail());
			result.getCliente().setCpf(cliente.getCpf());
			result.getCliente().setTelefone(cliente.getTelefone());
			result.getCliente().setLogradouro(cliente.getEndereco().getLogradouro());
			result.getCliente().setNumero(cliente.getEndereco().getNumero());
			result.getCliente().setComplemento(cliente.getEndereco().getComplemento());
			result.getCliente().setBairro(cliente.getEndereco().getBairro());
			result.getCliente().setCidade(cliente.getEndereco().getCidade());
			result.getCliente().setEstado(cliente.getEndereco().getEstado());
			result.getCliente().setCep(cliente.getEndereco().getCep());

			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}

	}

}
