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
        Student julka = new Student("Julka");

        firstMatFiz.addStudent(janek);
        firstMatFiz.addStudent(julka);

        Subject math = new Subject(SubjectName.MATH);

        janek.addSubject(math);
        julka.addSubject(new Subject());

        math.addMark(5.0);
        math.addMark(4.0);
        math.addMark(3.5);
        math.addMark(6.1);

        System.out.println(math);
        janek.improveMark(SubjectName.MATH, 3.5, 5.0);
        janek.improveMark(SubjectName.MATH, 4.0, 4.5);
        
        System.out.println(math);
        System.out.println(math.isAllMarksAdjusted());
        System.out.println(janek.isTooStupid());

        System.out.println(firstMatFiz.getStudents());
        school.endOfYear();
        System.out.println(firstMatFiz.getStudents());
    }
}
