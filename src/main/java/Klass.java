import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Klass {
    private String classNumberAndProfile;
    private List<Student> students;

    public Klass(String classNumberAndProfile) {
        this.classNumberAndProfile = classNumberAndProfile;
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(){
        students = students.stream().filter(Student::isTooStupid).collect(Collectors.toList());
    }

    public String getClassNumberAndProfile() {
        return classNumberAndProfile;
    }

    public List<Student> getStudents() {
        return students;
    }
}
