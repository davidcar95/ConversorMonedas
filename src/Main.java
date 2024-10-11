
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateApi api = new ExchangeRateApi();
        CurrencyConverter converter = new CurrencyConverter(api);

        boolean running = true;

        while (running) {
            System.out.println("\nQue te gustaría hacer hoy?");
            System.out.println("\n1. Convertir moneda");
            System.out.println("2. Mostrar historial de conversiones");
            System.out.println("3. Salir");
            System.out.println("\nSelecciona una opción:");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    int baseCurrencyIndex = -1;
                    int targetCurrencyIndex = -1;
                    boolean validBaseCurrency = false;
                    boolean validTargetCurrency = false;

                    // Bucle para la selección de moneda base
                    while (!validBaseCurrency) {
                        try {
                            System.out.println("\n*********************************");
                            System.out.println("\nSeleccione la moneda base:");
                            System.out.println("\n1. ARS - Peso argentino");
                            System.out.println("2. BOB - Boliviano boliviano");
                            System.out.println("3. BRL - Real brasileño");
                            System.out.println("4. CLP - Peso chileno");
                            System.out.println("5. COP - Peso colombiano");
                            System.out.println("6. USD - Dólar estadounidense");
                            System.out.println("7. EUR - Euro");
                            System.out.print("\nIngrese el número de la moneda base: ");

                            // Obtener selección de moneda base
                            baseCurrencyIndex = scanner.nextInt();
                            if (baseCurrencyIndex < 1 || baseCurrencyIndex > 7) {
                                throw new IllegalArgumentException("Opción inválida para la moneda base.");
                            }
                            validBaseCurrency = true; // Marcar que la opción es válida
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n*********************************");
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    // Bucle para la selección de moneda objetivo
                    while (!validTargetCurrency) {
                        try {
                            System.out.println("\n*********************************");
                            System.out.println("\nSeleccione la moneda objetivo:");
                            System.out.println("\n1. ARS - Peso argentino");
                            System.out.println("2. BOB - Boliviano boliviano");
                            System.out.println("3. BRL - Real brasileño");
                            System.out.println("4. CLP - Peso chileno");
                            System.out.println("5. COP - Peso colombiano");
                            System.out.println("6. USD - Dólar estadounidense");
                            System.out.println("7. EUR - Euro");
                            System.out.print("\nIngrese el número de la moneda objetivo: ");

                            // Obtener selección de moneda objetivo
                            targetCurrencyIndex = scanner.nextInt();
                            if (targetCurrencyIndex < 1 || targetCurrencyIndex > 7) {
                                throw new IllegalArgumentException("Opción inválida para la moneda objetivo.");
                            }
                            validTargetCurrency = true; // Marcar que la opción es válida
                        } catch (IllegalArgumentException e) {
                            System.out.println("\n*********************************");
                            System.out.println("\n" + e.getMessage());
                        }
                    }

                    System.out.println("\n*********************************");
                    System.out.print("\nIngrese la cantidad a convertir: ");
                    double amount = scanner.nextDouble();

                    // Realizar conversión
                    double result = converter.convertCurrency(baseCurrencyIndex, targetCurrencyIndex, amount);
                    System.out.println("\n*********************************");
                    System.out.println("\nResultado: " + result);
                    System.out.println("\n*********************************");
                    break;

                case 2:
                    // Mostrar historial
                    converter.showConversionHistory();
                    break;

                case 3:
                    running = false;
                    System.out.println("\n*********************************");
                    System.out.println("\nGracias por usar el conversor de monedas. ¡Hasta luego!");
                    System.out.println("\n*********************************");
                    break;

                default:
                    System.out.println("\n*********************************");
                    System.out.println("\nOpción no válida.");
                    System.out.println("\n*********************************");
            }
        }

        scanner.close();
    }
}