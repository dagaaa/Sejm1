import org.json.JSONObject;

/**
 * Created by daga on 31.12.2016.
 */
public class app {

    public static void main(String[] args) {

        try {
            JSONObject j=JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie.json");
            Deputies deputies = new Deputies();
            System.out.print(new StatisticSystem(deputies).deputiesData.keySet().size());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}