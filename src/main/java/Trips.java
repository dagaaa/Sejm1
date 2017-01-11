import org.json.JSONArray;

import java.util.LinkedList;

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
    //posła/posłanki, który odbył najdroższą podróż zagraniczną
    public String mostExpensiveTrip(Deputies deputies, StatisticSystem deputiesData)
    {
        int id=0;
        Double max=0.0;
        Double sum;
        Double sumTmp;
        for (Integer ID : deputiesData.deputiesDataMap.keySet())
        {
            sum=0.0;
            sumTmp=0.0;
            if(!deputiesData.isWyjazdyArrayEmpty(ID)){
                JSONArray trips=deputiesData.deputiesDataMap.get(ID).getJSONObject("layers").getJSONArray("wyjazdy");
                Integer amountOfTrips = trips.length();
                for(int i=0;i<amountOfTrips;i++)
                {
                    sumTmp=trips.getJSONObject(i).getDouble("koszt_suma");
                    if(sumTmp>sum)
                    {
                        sum=sumTmp;
                    }
                }
                if(sum>max)
                {
                    max=sum;
                    id=ID;
                }
            }
        }
        return deputies.getDeputyName(id)+ " the most expensive trip is: " + max;

    }
    //listę wszystkich posłów, którzy odwiedzili Włochy
    public LinkedList<String> wereInItaly(Deputies deputies, StatisticSystem deputiesData){

        LinkedList<String> deputiesInItalyList= new LinkedList<>();
        for(Integer ID: deputiesData.deputiesDataMap.keySet() ) {
            if (!deputiesData.isWyjazdyArrayEmpty(ID)) {
                JSONArray trips = deputiesData.deputiesDataMap.get(ID).getJSONObject("layers").getJSONArray("wyjazdy");
                Integer amountOfTrips = trips.length();
                if(wasInItaly(amountOfTrips,ID,trips))
                        deputiesInItalyList.add( deputies.getDeputyName(ID));

            }
        }
        return deputiesInItalyList;
    }

    public boolean wasInItaly(Integer numberOfTrips, Integer id, JSONArray trips)
    {
        for (int i = 0; i < numberOfTrips; i++) {
            if (trips.getJSONObject(i).getString("kraj").equals("Włochy"))
                return true;
        }
        return false;
    }



}