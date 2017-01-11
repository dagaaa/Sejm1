import org.json.JSONArray;

/**
 * Created by daga on 11.01.2017.
 */
public class Trips {
    public String maxTrips(Deputies deputies, StatisticSystem deputiesData) {
        Integer max = 0;


        int id = 0;
        for (Integer ID : deputiesData.deputiesDataMap.keySet()) {
            if(!deputiesData.isWyjazdyArrayEmpty(ID)) {
                Integer amountOfTrips = deputiesData.deputiesDataMap.get(ID).getJSONObject("layers").getJSONArray("wyjazdy").length();
                if (amountOfTrips > max) {
                    max = amountOfTrips;
                    id = ID;
                }
            }
        }
        return deputies.getDeputyName(id) + " amount of trips: " + max;

    }

    // najdluzej za granica
    public String maxTripAbroad(Deputies deputies, StatisticSystem deputiesData) {

        int id=0;
        Integer max=0;
        Integer sum;

        for(Integer ID : deputiesData.deputiesDataMap.keySet())
        {
            sum=0;
            if(!deputiesData.isWyjazdyArrayEmpty(ID)){
            JSONArray trips=deputiesData.deputiesDataMap.get(ID).getJSONObject("layers").getJSONArray("wyjazdy");
            Integer amountOfTrips = trips.length();
            for(int i=0;i<amountOfTrips;i++)
            {
                sum+=trips.getJSONObject(i).getInt("liczba_dni");
            }
            if (sum>max) {
                max = sum;
                id = ID;
            }
            }
        }
        return deputies.getDeputyName(id) + " was abroad for " + max + " days";

    }
    


}