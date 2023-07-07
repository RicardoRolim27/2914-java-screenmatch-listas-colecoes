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

import br.com.alura.screenmatch.dto.TituloOmdbDTO;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Digite um filme para a busca:");
		
		Scanner leitura = new Scanner(System.in);
		
		String busca = leitura.next();
		
		String endereco = "https://www.omdbapi.com/?apikey=eadba239&t=";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco + busca)).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String json = response.body();
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		
		TituloOmdbDTO tituloOmdbDto = gson.fromJson(json, TituloOmdbDTO.class);
		
		System.out.println(tituloOmdbDto);
		
		Titulo titulo = new Titulo(tituloOmdbDto);
		
		System.out.println(titulo);

	}

}
