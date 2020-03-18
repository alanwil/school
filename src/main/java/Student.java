import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;
    private double globalAverage;
    private boolean notSmartEnough;

    public Student(String name) {
        this.name = name;
        subjects = new ArrayList<>();
        notSmartEnough = false;
        globalAverage = 0;
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

    public void calcGlobalAverage() {
        globalAverage = subjects
                .stream()
                .mapToDouble(Subject::getAverage)
                .average()
                .orElse(0);
    }

    public double getGlobalAverage() {
        return globalAverage;
    }

    public boolean isNotSmartEnough() {
        return notSmartEnough;
    }

    public void improveMark(SubjectName subjectName, double oldMark, double newMark){
        for (Subject subject: subjects) {
            if (subject.getSubjectName() == subjectName){
                subject.adjustMark(oldMark, newMark);
                break;
            }
        }
        calcGlobalAverage();
        checkLowMarks();
    }

    public boolean canEndYear(){
        return subjects
                .stream()
                .allMatch(Subject::isAllMarksAdjusted);
    }

    public void checkLowMarks(){
        boolean lessThanTwoMark = subjects
                .stream()
                .flatMap(subject -> subject.getMarks().stream())
                .map(Mark::getMark)
                .anyMatch(mark -> mark < 2.0);
        boolean allMarksAdjusted = subjects.stream().allMatch(Subject::isAllMarksAdjusted);
        calcGlobalAverage();
        boolean tooLowAverage = getGlobalAverage() < School.REQUIRED_AVERAGE;
        if (lessThanTwoMark && tooLowAverage && allMarksAdjusted){
            notSmartEnough = true;
        }
    }

    @Override
    public String toString() {
        return this.getName() + this.getSubjects();
    }
}
