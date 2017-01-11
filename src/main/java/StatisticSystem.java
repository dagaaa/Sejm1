import com.sun.deploy.net.DownloadException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by daga on 10.01.2017.
 */
public class StatisticSystem {
    public ConcurrentHashMap<Integer,JSONObject> deputiesDataMap ;


    StatisticSystem(Deputies deputies) throws IOException {
        deputiesDataMap= addDeputiesData(deputies);
    }
    private ConcurrentHashMap<Integer, JSONObject> addDeputiesData(Deputies deputies) throws IOException {
        ConcurrentHashMap<Integer,JSONObject> deputiesDataTmp= new ConcurrentHashMap<>();

        deputies.deputiesList.parallelStream().forEach(deputy -> deputiesDataTmp.put(deputy.ID,downloadJson(deputy.ID)));
    /* for(Deputy deputy : deputies.deputiesList)
     {

             try {
                 deputiesDataTmp.put(deputy.ID, JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie/" + deputy.ID + ".json?layers[]=wyjazdy&layers[]=wydatki"));
             }catch(IOException ex){
                 System.out.print("an error occurred while downloading json" + ex);
             }

     }*/
       return deputiesDataTmp;
    }

    private JSONObject downloadJson(int ID) {
        int chances =5;
        while( chances>0 ) {
            try {
                return JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie/" + ID + ".json?layers[]=wyjazdy&layers[]=wydatki");
            } catch (IOException ex) {
                chances--;
            }
        }
        throw new RuntimeException();
    }

    public boolean isWyjazdyArrayEmpty(Integer deputyID) {
        return deputiesDataMap
                .get(deputyID).getJSONObject("layers")
                .get("wyjazdy").toString().equals("{}");
    }
}
