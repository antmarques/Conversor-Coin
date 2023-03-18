package client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import conversor.Moedas;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ClientEconomic {

    String endpoint = "https://economia.awesomeapi.com.br/last/";
    String moedasParam = "USD-BRL,BRL-USD,EUR-BRL,BRL-EUR,GBP-BRL,BRL-GBP,ARS-BRL,BRL-ARS,CLP-BRL,BRL-CLP";

    private String atualizarCambio() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(endpoint.concat(moedasParam)))
                    .timeout(Duration.of(10, ChronoUnit.SECONDS))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Moedas getMoedas() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.readValue(atualizarCambio(), Moedas.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
