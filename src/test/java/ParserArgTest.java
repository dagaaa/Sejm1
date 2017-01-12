import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by daga on 12.01.2017.
 */
public class ParserArgTest {

    @Test
    public void parArgTest() throws Exception {
        String[] testtab1 = {"iwinski-tadeusz","7"};
        String[] testtab2 = {"kopacz-ewa","8" };
        ParserArg test1 = new ParserArg(testtab1);
        ParserArg test2 = new ParserArg(testtab2);
        assertEquals(test1.name,("iwinski-tadeusz"));
        assertEquals(test1.cadence,7);
        assertEquals(test2.name,("kopacz-ewa"));
        assertEquals(test2.cadence,8);


    }


}
