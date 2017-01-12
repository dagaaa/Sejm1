import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by daga on 12.01.2017.
 */
public class AppTest {
    @Test
    public  void main() throws IOException {
        String []tab1= new String[2];
        tab1[0]="iwinski-tadeusz";
        tab1[1]="7";
        ParserArg arg = new ParserArg(tab1);
        Deputies deputies = new Deputies(arg.cadence);
        StatisticSystem statisticSystem= new StatisticSystem(deputies);

        Trips trip = new Trips();
        Expenses expense = new Expenses();
        //  System.out.println(deputies.getDeputyID("garbowski-tomasz"));
        Double deputyExpenses = expense.deputyExpenses(deputies,statisticSystem,arg.name);
        assertTrue(deputyExpenses>289315.0 && deputyExpenses<289315.1 );

        Double smallExpenses =expense.smallExpenses(deputies,statisticSystem,arg.name);
        assertTrue(smallExpenses>2241.60 && smallExpenses<2241.61);

        Double avgAllExpenses= expense.avgAllExpenses(statisticSystem);
        assertTrue(avgAllExpenses>272247.60 && avgAllExpenses<272247.61);

        String maxTrips = trip.maxTrips(deputies,statisticSystem);
        assertTrue(maxTrips.startsWith("iwinski-tadeusz"));
        assertTrue(maxTrips.endsWith("67"));

        String maxTripAbroad = trip.maxTripAbroad(deputies,statisticSystem);
        assertTrue(maxTripAbroad.startsWith("iwinski-tadeusz"));
        assertTrue(maxTripAbroad.endsWith("272 days"));

        String mostExpensiveTrip = trip.mostExpensiveTrip(deputies,statisticSystem);
        assertTrue(mostExpensiveTrip.startsWith("szejnfeld-adam"));
        assertTrue(mostExpensiveTrip.endsWith("27529.35"));

        LinkedList<String> wereInItaly = trip.wereInItaly(deputies,statisticSystem);
        assertEquals(wereInItaly.size(),50);






        String []tab2= new String[2];
        tab2[0]="kopacz-ewa";
        tab2[1]="8";
        ParserArg arg2 = new ParserArg(tab2);
        Deputies deputies2 = new Deputies(arg2.cadence);
        StatisticSystem statisticSystem2= new StatisticSystem(deputies2);

        Trips trip2 = new Trips();
        Expenses expense2 = new Expenses();
        //  System.out.println(deputies.getDeputyID("garbowski-tomasz"));
        Double deputyExpenses2 = expense.deputyExpenses(deputies2,statisticSystem2,arg2.name);
        assertTrue(deputyExpenses2>290196.84 && deputyExpenses2<290196.86 );

        Double smallExpenses2 =expense.smallExpenses(deputies2,statisticSystem2,arg2.name);
        assertTrue(smallExpenses2>170.4 && smallExpenses2<170.6);

        Double avgAllExpenses2= expense.avgAllExpenses(statisticSystem2);
        assertTrue(avgAllExpenses2>144882.96 && avgAllExpenses2<144882.97);

        String maxTrips2 = trip.maxTrips(deputies2,statisticSystem2);
        assertTrue(maxTrips2.startsWith("dziedziczak-jan"));
        assertTrue(maxTrips2.endsWith("45"));

        String maxTripAbroad2 = trip.maxTripAbroad(deputies2,statisticSystem2);
        assertTrue(maxTripAbroad2.startsWith("dziedziczak-jan"));
        assertTrue(maxTripAbroad2.endsWith("165 days"));

        String mostExpensiveTrip2 = trip.mostExpensiveTrip(deputies2,statisticSystem2);
        assertTrue(mostExpensiveTrip2.startsWith("waszczykowski-witold"));
        assertTrue(mostExpensiveTrip2.endsWith("27305.58"));

        LinkedList<String> wereInItaly2 = trip.wereInItaly(deputies2,statisticSystem2);
        assertEquals(wereInItaly2.size(),25);
    }
}
