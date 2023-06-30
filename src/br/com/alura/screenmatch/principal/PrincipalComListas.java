package br.com.alura.screenmatch.principal;

import java.util.ArrayList;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComListas {

	public static void main(String[] args) {
		Filme meuFilme = new Filme("O poderoso chefÃ£o", 1970);
		meuFilme.avalia(8);
		Filme outroFilme = new Filme("Avatar", 2023);
		outroFilme.avalia(9);
		Filme filmeDoPaulo = new Filme("Dogville", 2003);
		filmeDoPaulo.avalia(7);
		Serie lost = new Serie("Lost", 2000);

		ArrayList<Titulo> lista = new ArrayList<>();

		lista.add(filmeDoPaulo);
		lista.add(meuFilme);
		lista.add(outroFilme);

		lista.add(lost);

		for (Titulo titulo : lista) {

			if (titulo instanceof Filme) {
				Filme filme = (Filme) titulo;
				System.out.println(titulo.getNome() + " Clasificação: " + filme.getClassificacao());
			} else {
				System.out.println(titulo.getNome());
			}

		}

	}

}
