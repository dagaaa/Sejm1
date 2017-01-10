import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Optional;

/**
 * Created by daga on 10.01.2017.
 */
public class Expenses {
    public Double deputyExpenses (Deputies deputies, StatisticSystem deputiesData, String name){
        Double sum =0.0;
        Integer ID=deputies.getDeputyID(name);
        JSONObject deputyExpens = deputiesData.deputiesDataMap.get(ID);
        JSONArray rocznikiArray = deputyExpens.getJSONObject("layers").getJSONObject("wydatki").getJSONArray("roczniki");
        int years = rocznikiArray.length();
        for(int i =0;i<years;i++)
        {

               sum=rocznikiArray.getJSONObject(i).getJSONArray("pola").toList().stream().mapToDouble(Double.class::cast).sum();

        }
        return  sum;
    }
}
