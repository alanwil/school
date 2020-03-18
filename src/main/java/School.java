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
        boolean endOfYearAllowed = classes.stream()
                .flatMap(classs -> classs.getStudents().stream())
                .allMatch(Student::canEndYear);
        if (endOfYearAllowed){
            classes.forEach(Classs::removeStudents);
            System.out.println("End of Year completed");
        } else {
            System.out.println("Not all marks adjusted");
        }
    }
}
