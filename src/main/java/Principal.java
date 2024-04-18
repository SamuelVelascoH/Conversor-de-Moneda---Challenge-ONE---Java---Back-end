import java.io.IOException;
import java.util.Scanner;

public class Principal extends Consulta {
    private static String separador = "*************************************";

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

    public static void main(String[] args) {
        try {
            Consulta consulta = new Consulta();
            mostrarMenu();
            Scanner lectura = new Scanner(System.in);
            var numeroMenu = Integer.valueOf(lectura.nextLine());
            while (numeroMenu != 7){
                var tipoDeMonedaString = "";
                if (numeroMenu == 1){
                    tipoDeMonedaString = numeroMenu.toString().replace("1","ARS");
                    System.out.println("Escriba la cantidad que quiere convertir: ");
                    var amount = Double.valueOf(lectura.nextLine());
                    TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda("USD",tipoDeMonedaString, amount);
                    System.out.println(amount+" USD equivalen a: "+cantidad.conversion_rate()+" "+tipoDeMonedaString+"\n"+separador+"\n");
                    mostrarMenu();
                    numeroMenu = Integer.valueOf(lectura.nextLine());
                } else if (numeroMenu == 2) {
                    tipoDeMonedaString = numeroMenu.toString().replace("2","USD");
                    System.out.println("Escriba la cantidad que quiere convertir: ");
                    var amount = Double.valueOf(lectura.nextLine());
                    TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda("ARS",tipoDeMonedaString, amount);
                    System.out.println(amount+" ARS equivalen a: "+cantidad.conversion_rate()+" "+tipoDeMonedaString+"\n"+separador+"\n");
                    mostrarMenu();
                    numeroMenu = Integer.valueOf(lectura.nextLine());
                } else if (numeroMenu == 3) {
                    tipoDeMonedaString = numeroMenu.toString().replace("3","BRL");
                    System.out.println("Escriba la cantidad que quiere convertir: ");
                    var amount = Double.valueOf(lectura.nextLine());
                    TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda("USD",tipoDeMonedaString, amount);
                    System.out.println(amount+" USD equivalen a: "+cantidad.conversion_rate()+" "+tipoDeMonedaString+"\n"+separador+"\n");
                    mostrarMenu();
                    numeroMenu = Integer.valueOf(lectura.nextLine());
                } else if (numeroMenu == 4) {
                    tipoDeMonedaString = numeroMenu.toString().replace("4","USD");
                    System.out.println("Escriba la cantidad que quiere convertir: ");
                    var amount = Double.valueOf(lectura.nextLine());
                    TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda("BRL",tipoDeMonedaString, amount);
                    System.out.println(amount+" BRL equivalen a: "+cantidad.conversion_rate()+" "+tipoDeMonedaString+"\n"+separador+"\n");
                    mostrarMenu();
                    numeroMenu = Integer.valueOf(lectura.nextLine());
                } else if (numeroMenu == 5) {
                    tipoDeMonedaString = numeroMenu.toString().replace("5","COP");
                    System.out.println("Escriba la cantidad que quiere convertir: ");
                    var amount = Double.valueOf(lectura.nextLine());
                    TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda("USD",tipoDeMonedaString, amount);
                    System.out.println(amount+" USD equivalen a: "+cantidad.conversion_rate()+" "+tipoDeMonedaString+"\n"+separador+"\n");
                    mostrarMenu();
                    numeroMenu = Integer.valueOf(lectura.nextLine());
                } else if ( numeroMenu == 6) {
                    tipoDeMonedaString = numeroMenu.toString().replace("6","USD");
                    System.out.println("Escriba la cantidad que quiere convertir: ");
                    var amount = Double.valueOf(lectura.nextLine());
                    TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda("COP",tipoDeMonedaString, amount);
                    System.out.println(amount+" COP equivalen a: "+cantidad.conversion_rate()+" "+tipoDeMonedaString+"\n"+separador+"\n");
                    mostrarMenu();
                    numeroMenu = Integer.valueOf(lectura.nextLine());
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
