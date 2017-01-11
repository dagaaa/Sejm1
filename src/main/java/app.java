import org.json.JSONObject;

/**
 * Created by daga on 31.12.2016.
 */
public class app {

    public static void main(String[] args) {

        try {

       //     JSONObject j=JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie.json");
            ParserArg arg = new ParserArg(args);
            Deputies deputies = new Deputies(arg.cadence);
            StatisticSystem statisticSystem= new StatisticSystem(deputies);
       //     deputies.deputiesList.forEach(System.out:: println);
           // Trips trip = new Trips();

            System.out.println( new Trips().wereInItaly(deputies,statisticSystem));
            System.out.println("lalala");
        }catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}