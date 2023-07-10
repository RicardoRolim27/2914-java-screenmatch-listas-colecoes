package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import br.com.alura.screenmatch.dto.TituloOmdbDTO;
import br.com.alura.screenmatch.excecao.TituloNuloException;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Digite um filme para a busca:");

		Scanner leitura = new Scanner(System.in);

		String busca = leitura.next();

		String endereco = "https://www.omdbapi.com/?apikey=eadba239&t=";
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco + busca.replace(" ", ""+""))).build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			String json = response.body();

			Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

			TituloOmdbDTO tituloOmdbDto;
			// try {
			tituloOmdbDto = gson.fromJson(json, TituloOmdbDTO.class);
			System.out.println(tituloOmdbDto);
			Titulo titulo = new Titulo(tituloOmdbDto);
			System.out.println(titulo);
		} catch (JsonSyntaxException e1) {

			System.out.println("Ops, ocorreu um erro na busca do filme!n/" + "Não foi possível carregar");
			System.out.println(e1.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Endereço inválido");
			System.out.println(e.getMessage());
		} catch (TituloNuloException e){
			System.out.println(e.getMessage());
		}

		System.out.println("Programa finalizou corretamente!");

	}

}
