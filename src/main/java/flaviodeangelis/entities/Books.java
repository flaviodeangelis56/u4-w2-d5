package flaviodeangelis.entities;

import java.util.Random;

public class Books extends element {

    private long ISBN;
    private String title;
    private int yearOfPublication;
    private int numberOfPage;
    private String author;
    private String type;

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

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }
}

