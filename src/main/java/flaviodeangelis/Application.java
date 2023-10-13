package flaviodeangelis;

import flaviodeangelis.entities.Books;
import flaviodeangelis.entities.Magazine;
import flaviodeangelis.entities.Periodicità;
import flaviodeangelis.entities.element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<element> archivio = new ArrayList<>();

// --------------------------------------- ADD --------------------------------------
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci book per aggiunere un libro, magazine per aggiungere una rivista");
        String inputCreazione = input.nextLine();
        if (inputCreazione.toLowerCase().trim().equals("book")) {
            System.out.println("Come si chiama il tuo libro : ");
            String inputTitle = input.nextLine();
            System.out.println("Qual'è l'anno di publicazione : ");
            int inputYear = Integer.parseInt(input.nextLine());
            System.out.println("Quante pagine ha : ");
            int inputPage = Integer.parseInt(input.nextLine());
            System.out.println("Chi è l'autore : ");
            String inputAuthor = input.nextLine();
            System.out.println("Di che genere è : ");
            String inputType = input.nextLine();
            Books book = new Books(inputTitle, inputYear, inputPage, inputAuthor, inputType);
            archivio.add(book);
        } else if (inputCreazione.toLowerCase().trim().equals("magazine")) {
            System.out.println("Come si chiama la tua rivista : ");
            String inputTitle = input.nextLine();
            System.out.println("Qual'è l'anno di publicazione : ");
            int inputYear = Integer.parseInt(input.nextLine());
            System.out.println("Quante pagine ha : ");
            int inputPage = Integer.parseInt(input.nextLine());
            System.out.println("Qual'è la sua periodicità (periodicità disponibili settimanale,mensile,semestrale) : ");
            String inputPeriod = input.nextLine();
            if (inputPeriod.toLowerCase().trim().equals("settimanale")) {
                Magazine magazine = new Magazine(inputTitle, inputYear, inputPage, Periodicità.SETTIMANALE);
                archivio.add(magazine);
            } else if (inputPeriod.toLowerCase().trim().equals("mensile")) {
                Magazine magazine = new Magazine(inputTitle, inputYear, inputPage, Periodicità.MENSILE);
                archivio.add(magazine);
            } else if (inputPeriod.toLowerCase().trim().equals("semestrale")) {
                Magazine magazine = new Magazine(inputTitle, inputYear, inputPage, Periodicità.SEMESTRALE);
                archivio.add(magazine);
            }
        } else {
            System.out.println("Tipo di elemento non disponibile");
        }
// ------------------------------------------- REMOVE ----------------------------------------------

        System.out.println(archivio);
    }


}




