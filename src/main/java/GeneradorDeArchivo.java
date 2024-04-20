import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(TipoDeMoneda tipoDeMoneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(tipoDeMoneda.conversion_rate()+".json");
        escritura.write(gson.toJson(tipoDeMoneda));
        escritura.close();
    }
}
