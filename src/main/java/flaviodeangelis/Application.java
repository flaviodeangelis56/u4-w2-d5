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
        Magazine test1 = new Magazine("fufu", 24342, 42234, Periodicità.SETTIMANALE);
        archivio.add(test1);
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

        System.out.println(archivio);
// ------------------------------------------- REMOVE ----------------------------------------------
        System.out.println("Inserisci un codice ISBN per rimuovere quell'elemento dall'archivio");
        long inputISBN = Integer.parseInt(input.nextLine());
        archivio.removeIf(element -> element.getISBN() == inputISBN);


        // ------------------------------------------- RICERCA ISBN ----------------------------------------------
        System.out.println("Inserisci un codice ISBN per cercare un libro");
        long inputISBNCerca = Integer.parseInt(input.nextLine());
        archivio.stream().filter(element -> element.getISBN() == inputISBNCerca).forEach(element -> System.out.println(element));
        // ------------------------------------------- RICERCA ANNO ----------------------------------------------
        System.out.println("Inserisci un anno per cercare un libro");
        int inputAnnoCerca = Integer.parseInt(input.nextLine());
        archivio.stream().filter(element -> element.getYearOfPublication() == inputAnnoCerca).forEach(element -> System.out.println(element));
        // ------------------------------------------- RICERCA AUTORE ----------------------------------------------
        System.out.println("Inserisci un autore per cercare un libro");
        String inputAutoreCerca = input.nextLine();
        List<Books> booksList = new ArrayList<>();
        for (int i = 0; i < archivio.size(); i++) {
            if (archivio.get(i) instanceof Books) {
                booksList.add((Books) archivio.get(i));
            }
        }
        booksList.stream().filter(element -> element.getAuthor().equals(inputAutoreCerca)).forEach(book -> System.out.println(book));

    }


}




