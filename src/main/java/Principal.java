import java.util.Scanner;

public class Principal extends Consulta {
    private static String separador = "*************************************";
    private static String inCantidad = "Escriba la cantidad que quiere convertir: ";

    private static void mostrarMenu(){
        System.out.println("Elija un numero en el menu de conversiones: ");
        System.out.println("1) Dolar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dolar");
        System.out.println("3) Dolar =>> Real Brasileño");
        System.out.println("4) Dolar =>> Real Brasileño");
        System.out.println("5) Dolar =>> Peso Colombiano");
        System.out.println("6) Peso Colombiano =>> Dolar");
        System.out.println("7. Salir");
    }

    public static void ejecutarConversion(String tipoDeMonedaString, Integer numeroMenu, Scanner lectura, Consulta consulta, String sms, String tipo1, String tipo2){
        tipoDeMonedaString = numeroMenu.toString().replace(numeroMenu.toString(),tipo2);
        System.out.println("Escriba la cantidad que quiere convertir: ");
        var amount = Double.valueOf(lectura.nextLine());
        TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda(tipo1,tipoDeMonedaString, amount);
        System.out.println(amount+sms+cantidad.conversion_rate()+" "+tipoDeMonedaString+"\n"+separador+"\n");
        mostrarMenu();
        numeroMenu = Integer.valueOf(lectura.nextLine());
    }

    public static void main(String[] args) {
        try {
            Consulta consulta = new Consulta();
            mostrarMenu();
            Scanner lectura = new Scanner(System.in);
            var numeroMenu = Integer.valueOf(lectura.nextLine());
            while (numeroMenu != 7){
                var tipoDeMonedaString = "";
                if (numeroMenu == 1){
                    ejecutarConversion(tipoDeMonedaString, numeroMenu, lectura, consulta, " USD equivalen a: ", "USD", "ARS");
                } else if (numeroMenu == 2) {
                    ejecutarConversion(tipoDeMonedaString, numeroMenu, lectura, consulta, " ARS equivalen a: ", "ARS", "USD");
                } else if (numeroMenu == 3) {
                    ejecutarConversion(tipoDeMonedaString, numeroMenu, lectura, consulta, " USD equivalen a: ", "USD", "BRL");
                } else if (numeroMenu == 4) {
                    ejecutarConversion(tipoDeMonedaString, numeroMenu, lectura, consulta, " BRL equivalen a: ", "BRL", "USD");
                } else if (numeroMenu == 5) {
                    ejecutarConversion(tipoDeMonedaString, numeroMenu, lectura, consulta, " USD equivalen a: ", "USD", "COP");
                } else if (numeroMenu == 6) {
                    ejecutarConversion(tipoDeMonedaString, numeroMenu, lectura, consulta, " COP equivalen a: ", "COP", "USD");
                } else {
                    System.out.println("Opcion no valida \n");
                    mostrarMenu();
                    numeroMenu = Integer.valueOf(lectura.nextLine());
                }
            }
            if (numeroMenu ==7 ){
                System.out.println("Finalizando la aplicacion...");
            }
        } catch (NumberFormatException e ){
            System.out.println("No se encontro el tipo de moneda "+e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion... ");
        }


    }
}
