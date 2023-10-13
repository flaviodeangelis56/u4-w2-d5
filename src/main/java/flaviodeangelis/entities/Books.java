package flaviodeangelis.entities;

import java.util.Random;

public class Books extends element {
    long ISBN;
    String title;
    int yearOfPublication;
    int numberOfPage;
    String author;
    String type;

    public Books(String title, int yearOfPublication, int numberOfPage, String author, String type) {
        Random rndm = new Random();
        this.ISBN = rndm.nextInt(0, 99999999);
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPage = numberOfPage;
        this.author = author;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Books : {" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", numberOfPage=" + numberOfPage +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
