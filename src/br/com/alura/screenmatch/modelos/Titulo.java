package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.dto.TituloOmdbDTO;
import br.com.alura.screenmatch.excecao.TituloNuloException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;
    
    

    public Titulo(String nome, int anoDeLancamento) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
	}

	public Titulo(TituloOmdbDTO tituloOmdbDto) {
		if (tituloOmdbDto.getNome().isEmpty()) {
			throw new TituloNuloException("Título não pode ser nulo.");
		}
		this.nome = tituloOmdbDto.getNome();
		this.anoDeLancamento = Integer.valueOf(tituloOmdbDto.getAnoDeLancamento());
		this.duracaoEmMinutos = Integer.valueOf(tituloOmdbDto.getDuracaoEmMinutos()
				.substring(0,3));
	}

	public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lanÃ§amento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

	@Override
	public int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}

	@Override
	public String toString() {
		return "Titulo [nome= " + nome + ", anoDeLancamento= " + anoDeLancamento + ", duração = " + duracaoEmMinutos + "]";
	}
	
	
}
