import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;
    private boolean tooStupid;

    public Student(String name) {
        this.name = name;
        subjects = new ArrayList<>();
        tooStupid = false;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public boolean isTooStupid() {
        return tooStupid;
    }

    public void improveMarks(){
        for (Subject subject : subjects) {
            subject.adjustMark(Math.random() * 2 + 4);
        }
        checkLowMarks();
    }

    public void checkLowMarks(){
        boolean lessThanTwoMark = subjects.stream().anyMatch(Subject::isStillHasLowMark);
        boolean tooLowAverage = subjects.stream().anyMatch(subject -> subject.getAverage() < 4.3);
        if (lessThanTwoMark && tooLowAverage){
            tooStupid = true;
        }
    }
}
