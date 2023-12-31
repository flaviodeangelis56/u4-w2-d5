package flaviodeangelis;

import flaviodeangelis.entities.Books;
import flaviodeangelis.entities.Magazine;
import flaviodeangelis.entities.Periodicità;
import flaviodeangelis.entities.element;
import flaviodeangelis.exception.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        File file = new File("src/output.txt");
        List<element> archivio = new ArrayList<>();
        Magazine test1 = new Magazine("Focus", 2015, 129, Periodicità.SETTIMANALE);
        archivio.add(test1);
        try {
            Scanner input = new Scanner(System.in);
            int inputChoose = 0;
            do {

                try {
                    System.out.println("Inserisci 1 per aggiungere un elemento all'archivio, 2 per rimuovere un elemento tramite ISBN,3 per cercare un elemento tramite ISBN,4 per cercare un elemento con l'anno");
                    System.out.println("Inserisci 5 per cercare un libro con il suo autore,6 per salvare l'archivio sul disco,7 per leggere l'archivio salvato sul disco,0 per interrompere");
                    inputChoose = Integer.parseInt(input.nextLine());

                    switch (inputChoose) {
                        case 0:
                            break;
                        case 1:
                            try {
                                System.out.println("Inserisci book per aggiunere un libro, magazine per aggiungere una rivista");
                                String inputCreazione = input.nextLine();
                                if (inputCreazione.toLowerCase().trim().equals("book")) {
                                    System.out.println("Come si chiama il tuo libro : ");
                                    String inputTitle = input.nextLine();
                                    System.out.println("Qual'è l'anno di publicazione : ");
                                    int inputYear = Integer.parseInt(input.nextLine());
                                    if (inputYear > 2023) {
                                        throw new InputAnnoException();
                                    }
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
                                    if (inputYear > 2023) {
                                        throw new InputAnnoException();
                                    }
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
                                    throw new ElementException();
                                }
                            } catch (ElementException e) {
                                System.out.println("ERRORE : " + e.getMessage());
                            } catch (InputAnnoException e) {
                                System.out.println("ERRORE : " + e.getMessage());
                            }

                            break;
                        case 2:
                            System.out.println("Inserisci un codice ISBN per rimuovere quell'elemento dall'archivio");
                            long inputISBN = Integer.parseInt(input.nextLine());
                            archivio.removeIf(element -> element.getISBN() == inputISBN);
                            break;
                        case 3:
                            try {
                                System.out.println("Inserisci un codice ISBN per cercare un libro");
                                long inputISBNCerca = Integer.parseInt(input.nextLine());
                                List<element> outputISBN = archivio.stream().filter(element -> element.getISBN() == inputISBNCerca).toList();
                                if (outputISBN.isEmpty()) {
                                    throw new ISBNCercaException();
                                } else {
                                    System.out.println(outputISBN);
                                }
                            } catch (ISBNCercaException e) {
                                System.out.println("ERRORE : " + e.getMessage());
                            }

                            break;
                        case 4:
                            try {
                                System.out.println("Inserisci un anno per cercare un libro");
                                int inputAnnoCerca = Integer.parseInt(input.nextLine());
                                List<element> outputAnno = archivio.stream().filter(element -> element.getYearOfPublication() == inputAnnoCerca).toList();
                                if (outputAnno.isEmpty()) {
                                    throw new AnnoException();
                                } else {
                                    System.out.println(outputAnno);
                                }
                            } catch (AnnoException e) {
                                System.out.println("ERRORE : " + e.getMessage());
                            }

                            break;
                        case 5:
                            try {
                                System.out.println("Inserisci un autore per cercare un libro");
                                String inputAutoreCerca = input.nextLine();
                                List<Books> booksList = new ArrayList<>();
                                for (int i = 0; i < archivio.size(); i++) {
                                    if (archivio.get(i) instanceof Books) {
                                        booksList.add((Books) archivio.get(i));
                                    }
                                }
                                List<Books> outputAutore = booksList.stream().filter(element -> element.getAuthor().equals(inputAutoreCerca)).toList();
                                if (outputAutore.isEmpty()) {
                                    throw new AutoreException();
                                } else {
                                    System.out.println(outputAutore);
                                }
                            } catch (AutoreException e) {
                                System.out.println("ERRORE : " + e.getMessage());
                            }


                            break;
                        case 6:
                            try {
                                FileUtils.writeStringToFile(file, archivio.toString(), StandardCharsets.UTF_8);
                                break;
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        case 7:
                            try {
                                String filetext = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                                System.out.println(filetext);
                                break;
                            } catch (IOException e) {
                                throw new RuntimeException(e);

                            }
                        default:
                            throw new ChooseInputException();
                    }
                } catch (ChooseInputException e) {
                    System.out.println("ERRORE : " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("ERRORE : " + e.getMessage());
                }
            } while (inputChoose != 0);

            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}







