import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        Klass firstMatFiz = new Klass("I mat-fiz");
        Klass secondBioChem = new Klass("II bio-chem");
        Klass thirdHum = new Klass("III hum");

        school.addClass(firstMatFiz);
        school.addClass(secondBioChem);
        school.addClass(thirdHum);

        List<Double> goodMarks = Arrays.asList(5.5, 4.5, 5.0, 6.0, 4.0, 6.0, 5.0, 4.5);
        List<Double> okMarks = Arrays.asList(5.0, 4.5, 4.0, 4.0, 4.5, 5.0, 5.0, 4.5);
        List<Double> poorMarks = Arrays.asList(4.0, 4.5, 4.5, 4.0, 4.5, 1.0, 5.0, 4.5);
        List<Double> badMarks = Arrays.asList(1.0, 2.5, 3.0, 3.0, 1.5, 2.0, 3.0, 3.5);

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Subject compSci = new Subject("Computer Science", goodMarks);
        Subject english = new Subject("English", okMarks);
        Subject chemistry = new Subject("Chemistry", poorMarks);
        Subject biology = new Subject("Biology", badMarks);
        Subject polish = new Subject("Polish", 5.0, 4.5, 4.8, 5.2, 5.8, 4.1, 3.8, 5.3);
        Subject history = new Subject("History", 4.0, 4.5, 5.0, 3.0, 1.0, 4.5, 4.8, 5.0);

        Student janek = new Student("Janek");
        math.generateRandomMarks();
        physics.generateRandomMarks();
        janek.addSubject(math);
        janek.addSubject(physics);

        Student franek = new Student("Franek");
        franek.addSubject(compSci);
        franek.addSubject(english);

        Student placek = new Student("Placek");
        placek.addSubject(chemistry);
        placek.addSubject(biology);

        Student jacek = new Student("Jacek");
        jacek.addSubject(polish);
        jacek.addSubject(history);

        firstMatFiz.addStudent(janek);
        firstMatFiz.addStudent(franek);
        secondBioChem.addStudent(placek);
        thirdHum.addStudent(jacek);


    }
}
