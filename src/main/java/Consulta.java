import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {

    public TipoDeMoneda consultaTipoDeMoneda(String tipoDeMoneda1,String tipoDeMoneda2, double amount) {
        String url_srt = "https://v6.exchangerate-api.com/v6/e20562094e7e6b91b22f9e56/pair/"+tipoDeMoneda1+"/"+tipoDeMoneda2+"/"+amount;
        URI url = URI.create(url_srt);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TipoDeMoneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se creo el archivo from Json");
        }
    }
}
