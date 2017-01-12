/**
 * Created by daga on 11.01.2017.
 */
public class ParserArg {

    public String name;
    public int cadence;


    ParserArg(String []arg) {
        name =checkArg(arg)[0];
        cadence =Integer.parseInt(checkArg(arg)[1]);
    }

    public String[] checkArg(String[] arg)
    {
        if(arg.length!=2)
            throw new IllegalArgumentException("You passed wrong number of parameters");
        if(Integer.parseInt(arg[1])!=7 && Integer.parseInt(arg[1])!=8)
            throw new NumberFormatException("You passed wrong number. It can be only 7 or 8");
        return arg;

    }
}
