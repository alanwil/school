import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Classs> classes;
    public static final double REQUIRED_AVERAGE = 4.3;

    public School(){
        classes = new ArrayList<>();
    }

    public void addClass(Classs classs){
        classes.add(classs);
    }

    public List<Classs> getClasses() {
        return classes;
    }

    public void endOfYear(){
        classes.forEach(Classs::removeStudents);
    }
}
