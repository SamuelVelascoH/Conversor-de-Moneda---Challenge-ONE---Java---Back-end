import java.util.HashMap;

public class ConsultaService {
    HashMap<Integer,PairCoins> pairs = new HashMap<>();
    {
        pairs.put(1,new PairCoins("USD","ARS"));
        pairs.put(2,new PairCoins("ARS","USD"));
        pairs.put(3,new PairCoins("USD","BRL"));
        pairs.put(4,new PairCoins("BRL","USD"));
        pairs.put(5,new PairCoins("USD","COP"));
        pairs.put(6,new PairCoins("COP","USD"));
    }
    private static String separador = "*************************************";
    private String base;
    private String monedaConverted;
    public ConsultaService(Integer numeroMenu, Consulta consulta, double amount){
        PairCoins pair = pairs.get(numeroMenu);
        if (pair != null){
            TipoDeMoneda cantidad = consulta.consultaTipoDeMoneda(pair.base(), pair.monedaConverted(), amount);
            printResutado(pair, cantidad, amount);
        } else {
            System.out.println("Opcion invalida, comprale una silla de ruedas");
        }
    }

    public static void printResutado(PairCoins pair, TipoDeMoneda tipoMoneda, double amount){
        System.out.println(amount+" "+pair.base()+" equivalen a: "+tipoMoneda.conversion_rate()
                +" "+pair.monedaConverted()+"\n"+separador+"\n");
    }
}
