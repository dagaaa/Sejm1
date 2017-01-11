import org.json.JSONObject;

/**
 * Created by daga on 31.12.2016.
 */
public class app {

    public static void main(String[] args) {

        try {
            JSONObject j=JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie.json");
            Deputies deputies = new Deputies();
            deputies.deputiesList.forEach(System.out:: println);
            StatisticSystem statisticSystem= new StatisticSystem(deputies);
           // Trips trip = new Trips();

            System.out.print( new Trips().maxTripAbroad(deputies,statisticSystem));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}