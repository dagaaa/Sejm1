/**
 * Created by daga on 08.01.2017.
 */
public class Deputy {
    String name;
    int ID;
    Deputy(String name, int ID)
    {
        this.name=name;
        this.ID=ID;

    }

    @Override
    public String toString() {
        return "Deputy{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
