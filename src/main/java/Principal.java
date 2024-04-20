import java.util.Scanner;
public class Principal extends Consulta {

    //private static String inCantidad = "Escriba la cantidad que quiere convertir: ";

    private static void mostrarMenu(){
        System.out.println("1) Dolar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dolar");
        System.out.println("3) Dolar =>> Real Brasileño");
        System.out.println("4) Dolar =>> Real Brasileño");
        System.out.println("5) Dolar =>> Peso Colombiano");
        System.out.println("6) Peso Colombiano =>> Dolar");
        System.out.println("7. Salir");
        System.out.println("Elija un numero en el menu de conversiones: ");
    }

    public static void main(String[] args) {
        try {
            Scanner lectura = new Scanner(System.in);
            Consulta consulta = new Consulta();


            do {
                mostrarMenu();
                var numeroMenu = lectura.nextInt();
                lectura.nextLine();
                if (numeroMenu ==7 ){
                    System.out.println("Finalizando la aplicacion...");
                    break;
                }
                System.out.println("Escriba la cantidad que quiere convertir: ");
                var amount = Double.valueOf(lectura.nextLine());
                ConsultaService consultaService = new ConsultaService(numeroMenu, consulta, amount);

            } while ( true );
        } catch (NumberFormatException e ){
            System.out.println("No se encontro el tipo de moneda "+e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion... ");
        }


    }
}
