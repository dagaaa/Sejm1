import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by daga on 08.01.2017.
 */
public class Deputies {
   public LinkedList<Deputy> deputiesList ;

   Deputies()throws IOException , JSONException {
        deputiesList=addDeputies();

   }
private LinkedList<Deputy> addDeputies() throws IOException, JSONException
{
   LinkedList<Deputy> deputiestmp= new LinkedList<>();

    JSONArray deputyJson= JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie.json").getJSONArray("Dataobject");

    deputyJson.toList().stream().map(HashMap.class :: cast).forEach(e-> deputiestmp.add(new Deputy(e.get("slug").toString(),Integer.parseInt(e.get("id").toString()))));

    return deputiestmp;
}


}
