import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Subject {
    private String subjectName;
    private List<Double> marks;
    private double average;
    private boolean markAdjusted;
    private boolean stillHasLowMark;
    private final int MARKS_GENERATOR_LIMIT = 10;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        markAdjusted = false;
        stillHasLowMark = false;
        marks = new ArrayList<>();
        average = 0;
    }

    public Subject(String subjectName, double ... marks) {
        this.subjectName = subjectName;
        markAdjusted = false;
        stillHasLowMark = false;
        this.marks = inputMarksList(marks);
        average = 0;
    }

    public Subject(String subjectName, List<Double> marks) {
        this.subjectName = subjectName;
        markAdjusted = false;
        stillHasLowMark = false;
        this.marks = marks;
        average = 0;
    }

    public Subject() {
        this.subjectName = "Generated";
        markAdjusted = false;
        stillHasLowMark = false;
        generateRandomMarks();
    }

    public void addMark(double mark){
        marks.add(mark);
        calcAverage();
    }

    public void generateRandomMarks(){
        marks = DoubleStream
                .generate(() -> Math.random() * 5 + 1)
                .limit(MARKS_GENERATOR_LIMIT)
                .map(mark -> Math.round(mark * 10d)/10d)
                .boxed()
                .collect(Collectors.toList());
        calcAverage();
    }

    public void generateGoodMarks(){
        marks = DoubleStream
                .generate(() -> Math.random() * 2 + 4)
                .limit(MARKS_GENERATOR_LIMIT)
                .map(mark -> Math.round(mark * 10d)/10d)
                .boxed()
                .collect(Collectors.toList());
        calcAverage();
    }

    public void generatePoorMarks(){
        marks = DoubleStream
                .generate(() -> Math.random() * 3 + 1)
                .limit(MARKS_GENERATOR_LIMIT)
                .map(mark -> Math.round(mark * 10d)/10d)
                .boxed()
                .collect(Collectors.toList());
        calcAverage();
    }

    public void inputMarks(double ... marks){
        this.marks = DoubleStream
                .of(marks).boxed()
                .collect(Collectors.toList());
        calcAverage();
    }

    public List<Double> inputMarksList(double ... marks){
        this.marks = DoubleStream
                .of(marks)
                .boxed()
                .collect(Collectors.toList());
        return this.marks;
    }

    public void calcAverage(){
        average = Math.round(marks
                .stream()
                .reduce(0.0, Double::sum) / marks.size() * 10d)/10d;
    }

    public void adjustMark(double markToAdjust, double newMark){
        if (!markAdjusted){
            if (marks.contains(markToAdjust)){
                int markIndex = marks.indexOf(markToAdjust);
                marks.set(markIndex, newMark);
                markAdjusted = true;
            } else {
                System.out.println("No such mark found");
            }
        } else {
            System.out.println("Mark already adjusted");
        }
    }

    public void adjustMark(double newMark){
        if (!markAdjusted && marks.size() > 0){
            double lowestMark = marks.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
            marks.set(marks.indexOf(lowestMark), newMark);
            markAdjusted = true;
        } else {
            System.out.println("Mark already adjusted");
        }
    }

    public boolean isStillHasLowMark() {
        if (markAdjusted){
            stillHasLowMark = marks.stream().anyMatch(mark -> mark < 2.0);
            if (stillHasLowMark){
                return true;
            }
        }
        return false;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public List<Double> getMarks() {
        return marks;
    }

    public double getAverage() {
        return average;
    }

    public boolean isMarkAdjusted() {
        return markAdjusted;
    }

    @Override
    public String toString() {
        return subjectName +
                ", marks=" + marks +
                ", average=" + average;
    }
}
