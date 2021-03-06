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

               sum+=rocznikiArray.getJSONObject(i).getJSONArray("pola").toList().stream().map(String.class::cast).mapToDouble(Double::parseDouble).sum();

        }
        return  sum;
    }

    public Double smallExpenses (Deputies deputies, StatisticSystem deputiesData, String name)
    {
        Double sum = 0.0;
        Integer ID = deputies.getDeputyID(name);
        JSONObject deputyExpens = deputiesData.deputiesDataMap.get(ID);
        JSONArray rocznikiArray = deputyExpens.getJSONObject("layers").getJSONObject("wydatki").getJSONArray("roczniki");
        int years = rocznikiArray.length();
        for(int i =0 ;i<years;i++){
            sum+=rocznikiArray.getJSONObject(i).getJSONArray("pola").getDouble(12); // zmienic tak zeby nie było zahardkodowane , szukamy po tytule zapisujemy do zmiennej i ta zmienna wstawiamy w miejsce indexu
        }
        return  sum;
    }

    private int  index(JSONObject wydatki){
        boolean contain = false;
        int i=0;
        int num=-1;
        while (!contain && wydatki.getJSONArray("punkty").length()>i ) {
           if( wydatki.getJSONArray("punkty").getJSONObject(i).get("tytul").equals("Koszty drobnych napraw i remontów lokalu biura poselskiego")) {
               contain = true;
               num= wydatki.getJSONArray("punkty").getJSONObject(i).getInt("numer");
           }

            i++;
        }

        if(contain && num!=-1)
            return  num-1;
        throw new IllegalArgumentException("There is no category like drobne naprawy");
    }

    public  Double avgAllExpenses(StatisticSystem deputiesData) {
        Double sum = 0.0;
        int amountOfDeputies = deputiesData.deputiesDataMap.size();
        for(Integer ID: deputiesData.deputiesDataMap.keySet()) {
            JSONArray rocznikiArray = deputiesData.deputiesDataMap.get(ID).getJSONObject("layers").getJSONObject("wydatki").getJSONArray("roczniki");
            int years = rocznikiArray.length();
            for (int j = 0; j < years; j++) {
                sum += rocznikiArray.getJSONObject(j).getJSONArray("pola").toList().stream().map(String.class::cast).mapToDouble(Double::parseDouble).sum();
            }



        }
        sum /= amountOfDeputies;
        return sum;
    }

}
