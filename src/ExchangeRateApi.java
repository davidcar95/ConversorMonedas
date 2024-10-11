
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateApi {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/470498099bdd79e9acf4d2b2/latest/";


    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        // Construcción de la URL con la API key y la moneda base
        String urlStr = API_URL + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Comprobar que la conexión fue exitosa
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed: HTTP error code : " + connection.getResponseCode());
        }

        // Parsear la respuesta JSON
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();

        // Comprobar si la API retornó un resultado exitoso
        if (!jsonResponse.get("result").getAsString().equals("success")) {
            throw new RuntimeException("Error en la API: " + jsonResponse.get("result").getAsString());
        }

        // Obtener las tasas de conversión
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

        // Buscar la tasa de conversión para la moneda objetivo
        if (conversionRates.has(targetCurrency)) {
            return conversionRates.get(targetCurrency).getAsDouble();
        } else {
            throw new RuntimeException("Moneda no encontrada: " + targetCurrency);
        }
    }
}