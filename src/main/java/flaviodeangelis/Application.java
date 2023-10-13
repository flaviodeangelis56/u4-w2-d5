package flaviodeangelis;

import flaviodeangelis.entities.Magazine;
import flaviodeangelis.entities.Periodicità;
import flaviodeangelis.entities.element;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<element> archivio = new ArrayList<>();
        Magazine test1 = new Magazine("test1", 2023, 125, Periodicità.SETTIMANALE);
        archivio.add(test1);
        System.out.println(archivio);
    }

    public static void addAnElement(String bOrM) {

    }

    public static void addAMagazine(String title, int yearOfPublication, int numberOfPage, String periodicità) {
        if (periodicità.equals("settimanale")) {
            Magazine magazine = new Magazine(title, yearOfPublication, numberOfPage, Periodicità.SETTIMANALE);
            archivio.add(magazine);
        } else if (periodicità.equals("mensile")) {
            Magazine magazine = new Magazine(title, yearOfPublication, numberOfPage, Periodicità.MENSILE);
        } else if (periodicità.equals("semestrale")) {
            Magazine magazine = new Magazine(title, yearOfPublication, numberOfPage, Periodicità.SEMESTRALE);
        }
    }
}
