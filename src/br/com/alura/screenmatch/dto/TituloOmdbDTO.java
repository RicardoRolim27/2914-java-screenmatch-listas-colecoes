package br.com.alura.screenmatch.dto;

import com.google.gson.annotations.SerializedName;

public class TituloOmdbDTO {
	
	String titulo;
	@SerializedName("Title")
    private String nome;
	@SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    @SerializedName("Runtime")
    private String duracaoEmMinutos;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}
	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}
	public String getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}
	public void setDuracaoEmMinutos(String duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
	@Override
	public String toString() {
		return "TituloOmdbDTO [nome=" + nome + ", anoDeLancamento=" + anoDeLancamento + ", duracaoEmMinutos="
				+ duracaoEmMinutos + "]";
	}
    
    

}
