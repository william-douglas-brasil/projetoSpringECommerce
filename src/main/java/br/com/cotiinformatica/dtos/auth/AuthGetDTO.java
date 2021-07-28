package br.com.cotiinformatica.dtos.auth;

import br.com.cotiinformatica.dtos.clientes.ClienteGetDTO;

public class AuthGetDTO {

	private String mensagem;
	private String accessToken;
	private ClienteGetDTO cliente;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public ClienteGetDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteGetDTO cliente) {
		this.cliente = cliente;
	}
	
	
}
