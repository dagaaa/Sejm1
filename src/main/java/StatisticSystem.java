import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by daga on 10.01.2017.
 */
public class StatisticSystem {
    public HashMap<Integer,JSONObject> deputiesDataMap ;


    StatisticSystem(Deputies deputies) throws IOException {
        deputiesDataMap= addDeputiesData(deputies);
    }
    private HashMap<Integer,JSONObject> addDeputiesData(Deputies deputies) throws IOException {
        HashMap<Integer,JSONObject> deputiesDataTmp= new HashMap<>();

     for(Deputy deputy : deputies.deputiesList)
     {
         deputiesDataTmp.put(deputy.ID,JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie/"+deputy.ID+".json?layers[]=wyjazdy&layers[]=wydatki"));
     }
        return  deputiesDataTmp;
    }

    public boolean isWyjazdyArrayEmpty(Integer deputyID) {
        return deputiesDataMap
                .get(deputyID).getJSONObject("layers")
                .get("wyjazdy").toString().equals("{}");
    }
}
