import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by daga on 31.12.2016.
 */
public class Parliment {

    public static void main(String[] args) {

        try {

       //     JSONObject j=JsonDownloader.run("https://api-v3.mojepanstwo.pl/dane/poslowie.json");
            ParserArg arg = new ParserArg(args);
            Deputies deputies = new Deputies(arg.cadence);
            StatisticSystem statisticSystem= new StatisticSystem(deputies);
       //     deputies.deputiesList.forEach(System.out:: println);
            Trips trip = new Trips();
            Expenses expense = new Expenses();
          //  System.out.println(deputies.getDeputyID("garbowski-tomasz"));
            System.out.println( expense.deputyExpenses(deputies,statisticSystem,arg.name));
            System.out.println( expense.smallExpenses(deputies,statisticSystem,arg.name));
            System.out.println( expense.avgAllExpenses(statisticSystem));
            System.out.println( trip.maxTrips(deputies,statisticSystem));
            System.out.println( trip.maxTripAbroad(deputies,statisticSystem));
            System.out.println( trip.mostExpensiveTrip(deputies,statisticSystem));
            System.out.println( trip.wereInItaly(deputies,statisticSystem));

        }catch (IOException | JSONException ex) {
            System.out.println(ex );
        } catch (NumberFormatException ex) {
            System.out.println( ex);
        } catch (IllegalArgumentException ex) {
            ex.getCause();
        }catch (RuntimeException ex){
            System.out.println(ex);
        }



    }
}