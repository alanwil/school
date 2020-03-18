public class Main {
    public static void main(String[] args) {
        School school = new School();
        Classs firstMatFiz = new Classs("I mat-fiz");
        Classs secondBioChem = new Classs("II bio-chem");
        Classs thirdHum = new Classs("III hum");

        school.addClass(firstMatFiz);
        school.addClass(secondBioChem);
        school.addClass(thirdHum);

        Student janek = new Student("Janek");
        Student darek = new Student("Darek");

        firstMatFiz.addStudent(janek);
        firstMatFiz.addStudent(darek);

        Subject math = new Subject(SubjectName.MATH);
        Subject physics = new Subject(SubjectName.PHYSICS);

        janek.addSubject(math);
        darek.addSubject(physics);

        math.addMark(5.0);
        math.addMark(4.0);
        math.addMark(3.5);
        math.addMark(6.1);
        physics.addMark(2.0);
        physics.addMark(3.5);
        physics.addMark(5.0);
        physics.addMark(3.0);

        janek.improveMark(SubjectName.MATH, 3.5, 5.0);
        System.out.println(firstMatFiz.getStudents());
        school.endOfYear();
        darek.improveMark(SubjectName.PHYSICS, 2.0, 3.0);
        darek.improveMark(SubjectName.PHYSICS, 3.5, 4.0);
        darek.improveMark(SubjectName.PHYSICS, 3.0, 3.0);
        janek.improveMark(SubjectName.MATH, 4.0, 4.5);
        firstMatFiz.removeStudents();
        System.out.println(firstMatFiz.getStudents());

    }
}
