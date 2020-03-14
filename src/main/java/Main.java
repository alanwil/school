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

    }
}
