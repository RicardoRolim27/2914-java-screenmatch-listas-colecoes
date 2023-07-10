package br.com.alura.screenmatch.excecao;

public class TituloNuloException extends RuntimeException {
	
	private String mensagem;

	public TituloNuloException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String getMessage() {
		return this.mensagem;
	}
	
}
