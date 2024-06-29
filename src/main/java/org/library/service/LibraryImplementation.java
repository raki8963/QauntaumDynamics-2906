package org.library.service;

import org.library.dto.Book;

import java.util.List;

public interface LibraryImplementation {

    void saveBook(Book book);
    boolean removeBook(String ISBN);
    List<Book> findBookByTitle(String title);
    List<Book> findBookByAuthor(String author);
    List<Book> listAllBooks();
    List<Book> listAvailableBooks();


}
