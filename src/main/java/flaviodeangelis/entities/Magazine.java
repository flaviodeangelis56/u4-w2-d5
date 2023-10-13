package flaviodeangelis.entities;

import java.util.Random;

public class Magazine extends element {
    private long ISBN;
    private String title;
    private int yearOfPublication;
    private int numberOfPage;
    private Periodicità periodicità;

    public Magazine(String title, int yearOfPublication, int numberOfPage, Periodicità periodicità) {
        Random rndm = new Random();
        this.ISBN = rndm.nextInt(0, 99999999);
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPage = numberOfPage;
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Magazine : {" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", numberOfPage=" + numberOfPage +
                ", periodicità=" + periodicità +
                '}';
    }

    public long getISBN() {
        return ISBN;
    }


    public int getYearOfPublication() {
        return yearOfPublication;
    }

}
