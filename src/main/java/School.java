import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Klass> classes;
    public static final double REQUIRED_AVERAGE = 4.3;

    public School(){
        classes = new ArrayList<>();
    }

    public void addClass(Klass klass){
        classes.add(klass);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public void endOfYear(){
        classes.forEach(Klass::removeStudent);
    }
}
