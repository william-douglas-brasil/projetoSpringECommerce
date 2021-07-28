package br.com.cotiinformatica.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cotiinformatica.dtos.produtos.ProdutoGetDTO;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.interfaces.IProdutoRepository;

@Controller
@Transactional
public class ProdutosController {

	private static final String ENDPOINT = "/api/produtos";

	@Autowired
	private IProdutoRepository produtoRepository;

	@CrossOrigin
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ProdutoGetDTO>> getAll() {

		try {

			List<ProdutoGetDTO> result = new ArrayList<ProdutoGetDTO>();

			for (Produto produto : produtoRepository.findAll()) {

				ProdutoGetDTO dto = new ProdutoGetDTO();

				dto.setIdProduto(produto.getIdProduto());
				dto.setNome(produto.getNome());
				dto.setPreco(produto.getPreco());
				dto.setDescricao(produto.getDescricao());
				dto.setFoto(produto.getFoto());

				result.add(dto);
			}

			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@CrossOrigin
	@RequestMapping(value = ENDPOINT + "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ProdutoGetDTO> getById(@PathVariable("id") Integer id) {

		try {

			Optional<Produto> result = produtoRepository.findById(id);

			if (result == null || result.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}

			Produto produto = result.get();

			ProdutoGetDTO dto = new ProdutoGetDTO();

			dto.setIdProduto(produto.getIdProduto());
			dto.setNome(produto.getNome());
			dto.setPreco(produto.getPreco());
			dto.setDescricao(produto.getDescricao());
			dto.setFoto(produto.getFoto());

			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
