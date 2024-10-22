import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        int opcionUsuario = 0;
        ConsultaInfoMoneda consulta = new ConsultaInfoMoneda();
        ArrayList<Conversion> listaDeConversiones = new ArrayList<>();
        System.out.println("****************************************************************************\n");
        System.out.println("*** Bienvenid@ al conversor de moneda ***\n");
        while (opcionUsuario != 3) {
            Menu menu = new Menu();
            menu.mostrarMenuPrincipal();
            opcionUsuario = menu.leerOpcionPrincipal();

            switch (opcionUsuario) {
                case 1:
                    menu.mostrarMenuMonedas("inicial");
                    String monedaBase = menu.leerOpcionMoneda();
                    menu.mostrarMenuMonedas("final");
                    String monedaFinal = menu.leerOpcionMoneda();
                    Double cantidadACambiar = menu.leerCantidadACambiar();
                    Conversor conversor = consulta.buscaMoneda(monedaBase);
                    Double tasaDeConversion = conversor.getConversionRate(monedaFinal.toUpperCase());
                    Double cantidadObtenida = menu.cantidadObtenida(monedaBase, cantidadACambiar, tasaDeConversion, monedaFinal);
                    Conversion nuevaConversion = new Conversion(monedaBase, monedaFinal, cantidadACambiar, cantidadObtenida);
                    listaDeConversiones.add(nuevaConversion);
                    break;
                case 2:
                    menu.imprimirConversiones(listaDeConversiones);
                    break;
                case 3:
                    System.out.println("Gracias por utilizar el conversor de monedas");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        }
    }
}
