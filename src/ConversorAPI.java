import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConversorAPI {

    // API gratuita para tasas de cambio
    private static final String API_URL = "https://open.er-api.com/v6/latest/USD";

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        try {
            // 1️ Crear cliente HTTP y hacer solicitud
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 2️ Imprimir información adicional de la respuesta
            System.out.println("Código HTTP: " + response.statusCode());
            System.out.println("Encabezados: " + response.headers());
            System.out.println("--------------------------------------------------");

            // 3️ Analizar JSON usando Gson
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);
            JsonObject rates = json.getAsJsonObject("rates");

            // 4️ Filtrar monedas que queremos usar
            String[] monedasFiltradas = {"ARS", "MXN", "BOB", "BRL", "EUR", "CAD"};
            System.out.println("Monedas disponibles para convertir:");
            for (String codigo : monedasFiltradas) {
                if (rates.has(codigo)) {
                    double valor = rates.get(codigo).getAsDouble();
                    System.out.println(codigo + " -> " + valor + " USD");
                }
            }
            System.out.println("---------------------------------------------");

            // 5️ Menú interactivo
            while (true) {
                System.out.println("CONVERSOR DE MONEDAS (basado en USD)");
                System.out.println("1 - Peso argentino (ARS)");
                System.out.println("2 - Peso mexicano (MXN)");
                System.out.println("3 - Boliviano (BOB)");
                System.out.println("4 - Real brasileño (BRL)");
                System.out.println("5 - Euro (EUR)");
                System.out.println("6 - Dólar canadiense (CAD)");
                System.out.println("7 - Salir");
                System.out.print("Ingrese una opción: ");
                char opcion = leer.next().charAt(0);

                String codigo = "";
                switch (opcion) {
                    case '1': codigo = "ARS"; break;
                    case '2': codigo = "MXN"; break;
                    case '3': codigo = "BOB"; break;
                    case '4': codigo = "BRL"; break;
                    case '5': codigo = "EUR"; break;
                    case '6': codigo = "CAD"; break;
                    case '7':
                        System.out.println("CERRANDO PROGRAMA...");
                        return;
                    default:
                        System.out.println("Opción inválida.\n");
                        continue;
                }

                if (!rates.has(codigo)) {
                    System.out.println("No se encontró la tasa de cambio para " + codigo);
                    continue;
                }

                double valorMoneda = rates.get(codigo).getAsDouble();
                System.out.print("Ingrese la cantidad en " + codigo + ": ");
                double cantidad = leer.nextDouble();

                // 6️ Convertir a dólares
                double dolares = cantidad / valorMoneda;
                dolares = Math.round(dolares * 100d) / 100d;

                System.out.println("---------------------------------------------");
                System.out.printf("|     %.2f %s = %.2f USD\n", cantidad, codigo, dolares);
                System.out.println("---------------------------------------------\n");
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }
}
