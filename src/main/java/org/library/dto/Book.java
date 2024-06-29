package org.library.dto;

import jakarta.validation.constraints.NotNull;
import org.library.annotations.ValidYear;

public class Book {

    private String title;

    @NotNull
    private String author;

    @NotNull
    private String ISBN;
    private String genre;

    @ValidYear//created a valid year annotation to have only 4 digits
    @NotNull
    private int publication_year;

    @NotNull
    private String Department;

    @NotNull
    private boolean availabilty;

    public Book(String title, String author, String ISBN, String genre, int publication_year,
                boolean availabilty, String department) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.publication_year = publication_year;
        this.availabilty = availabilty;
        Department = department;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }


    public String getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }


    public boolean isAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(boolean availabilty) {
        this.availabilty = availabilty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", genre='" + genre + '\'' +
                ", publication_year=" + publication_year +
                ", Department='" + Department + '\'' +
                ", availabilty=" + availabilty +
                '}';
    }
}
