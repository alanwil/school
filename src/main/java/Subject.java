import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Subject {
    private SubjectName subjectName;
    private List<Mark> marks;
    private double average;
    private boolean allMarksAdjusted = false;
    private final int MARKS_GENERATOR_LIMIT = 4;

    public Subject(SubjectName subjectName) {
        this.subjectName = subjectName;
        marks = new ArrayList<>();
        average = 0;
    }

    public Subject() {
        this.subjectName = SubjectName.DEFAULT;
        generateRandomMarks();
    }

    private void generateRandomMarks() {
        marks = DoubleStream
                .generate(() -> Math.random() * 5 + 1)
                .limit(MARKS_GENERATOR_LIMIT)
                .map(mark -> Math.round(mark * 10d)/10d)
                .boxed()
                .map(Mark::new)
                .collect(Collectors.toList());
        calcAverage();
    }

    public void addMark(double mark){
        if (mark >= 1 && mark <= 6){
            marks.add(new Mark(mark));
        }
        calcAverage();
    }

    public void calcAverage(){
        average = Math.round(marks
                .stream()
                .map(Mark::getMark)
                .reduce(0.0, Double::sum) / marks.size() * 10d)/10d;
    }

    public void adjustMark(double markToAdjust, double newMark){
        if (marks.size() > 0){
            for (int i = 0; i < marks.size(); i++) {
                if (marks.get(i).getMark() == markToAdjust
                        && !marks.get(i).isAdjusted()
                        && newMark >= 1.0
                        && newMark <= 6.0){
                    marks.set(i, new Mark(newMark, true));
                    areAllMarksAdjusted();
                    calcAverage();
                    break;
                }
            }
        } else {
            System.out.println("No such mark found");
        }
    }

    private void areAllMarksAdjusted(){
        allMarksAdjusted = marks.stream().allMatch(Mark::isAdjusted);
    }

    public boolean isAllMarksAdjusted() {
        areAllMarksAdjusted();
        return allMarksAdjusted;
    }

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return subjectName.getName() +
                ", marks = " + marks +
                ", average = " + average;
    }
}
