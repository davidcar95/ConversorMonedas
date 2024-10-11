
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {

    private ExchangeRateApi api;
    private List<String> conversionHistory;

    public CurrencyConverter(ExchangeRateApi api) {
        this.api = api;
        this.conversionHistory = new ArrayList<>();
    }

    // Metodo para convertir moneda
    public double convertCurrency(int baseCurrencyIndex, int targetCurrencyIndex, double amount) throws Exception {
        String[] currencies = {"ARS", "BOB", "BRL", "CLP", "COP", "USD", "EUR"};
        String baseCurrency = currencies[baseCurrencyIndex - 1];
        String targetCurrency = currencies[targetCurrencyIndex - 1];

        // Obtener tasa de conversión desde la API
        double exchangeRate = api.getExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = amount * exchangeRate;

        // Capturar la marca de tiempo actual
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Crear un registro de la conversión
        String record = String.format("Fecha: %s, %s -> %s, Cantidad: %.2f, Resultado: %.2f",
                timestamp.format(formatter), baseCurrency, targetCurrency, amount, convertedAmount);

        // Añadir el registro al historial
        conversionHistory.add(record);

        // Devolver el monto convertido
        return convertedAmount;
    }

    // Metodo para mostrar el historial de conversiones
    public void showConversionHistory() {
        if (conversionHistory.isEmpty()) {
            System.out.println("\n*********************************");
            System.out.println("\nNo se han realizado conversiones aún.");
            System.out.println("\n*********************************");
        } else {
            System.out.println("\n*********************************");
            System.out.println("\nHistorial de conversiones:");
            System.out.println("");
            for (String record : conversionHistory) {
                System.out.println(record);
            }
            System.out.println("\n*********************************");
        }
    }
}