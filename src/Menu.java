import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final String monedasDisponibles = """
            USD --- Dólar Estadounidense
            ARS --- Peso Argentino
            BRL --- Real Brasileño
            COP --- Peso Colombiano
            EUR --- Euro""";

    public void mostrarMenuPrincipal() {
        System.out.println("****************************************************************************");
        System.out.println("A continuación digíte la opción que desea realizar: \n");
        String menuPrincipal = """
                1) Realizar una conversión
                2) Consultar historial de conversiones
                3) Salir""";
        System.out.println(menuPrincipal);
    }

    public int leerOpcionPrincipal(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Elija una opción válida");
        System.out.println("****************************************************************************");
        return lectura.nextInt();
    }

    public void mostrarMenuMonedas(String denominacion) {
        System.out.println("****************************************************************************");
        System.out.println("Selecciona la denominación " + denominacion + ": \n");
        System.out.println(monedasDisponibles);
        System.out.println("****************************************************************************");
    }

    public String leerOpcionMoneda() {
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!monedasDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("La opción digitada no está disponible");
            System.out.println("Elija una opción válida");
            System.out.println("****************************************************************************");
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public Double leerCantidadACambiar() {
        System.out.println("****************************************************************************");
        System.out.println("Digíte la cantidad que desea cambiar: \n");
        System.out.println("****************************************************************************");
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            System.out.println("****************************************************************************");
            System.out.println("La cantidad digitada no es un número válido");
            System.out.println("Ingrese una cnatidad válida");
            System.out.println("****************************************************************************");
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public Double cantidadObtenida(String monedaBase, Double cantidadACambiar, Double tasaDeConversion, String monedaFinal) {
        Double resultado = cantidadACambiar * tasaDeConversion;
        System.out.println("****************************************************************************");
        System.out.println(cantidadACambiar + " " + monedaBase + " equivalen a: " + resultado + " " + monedaFinal);
        return resultado;
    }

    public void imprimirConversiones(ArrayList<Conversion> listaDeConversiones) {
        if (listaDeConversiones.isEmpty()) {
            System.out.println("No se hab realizado conversiones.");
        } else {
            System.out.println("Historial de conversiones:");
            for (int i = 0; i < listaDeConversiones.size(); i++) {
                Conversion conversion = listaDeConversiones.get(i);
                System.out.println("Conversion " + (i + 1) + ":");
                System.out.println("Moneda origen: " + conversion.getMonedaBase());
                System.out.println("Moneda objetivo: " + conversion.getMonedaObjetivo());
                System.out.println("Cantidad a cambiar: " + conversion.getCantidadACambiar());
                System.out.println("Cantidad obtenida: " + conversion.getCantidadCambiada());
                System.out.println("Fecha y hora: " + formarDateTime(conversion.getTiempo()));
                System.out.println("--------------------------------------------------------------------");
            }
        }
    }

    private String formarDateTime(LocalDateTime tiempo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return tiempo.format(formatter);
    }
}
