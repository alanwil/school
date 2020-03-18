import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classs {
    private String classNumberAndProfile;
    private List<Student> students;

    public Classs(String classNumberAndProfile) {
        this.classNumberAndProfile = classNumberAndProfile;
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudents(){
        students.forEach(Student::checkLowMarks);
        students = students
                .stream()
                .filter(student -> !student.isNotSmartEnough())
                .collect(Collectors.toList());
    }

    public String getClassNumberAndProfile() {
        return classNumberAndProfile;
    }

    public List<Student> getStudents() {
        return students;
    }
}
