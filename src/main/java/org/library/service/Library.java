package org.library.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.library.dto.Book;

import java.util.*;
import java.util.stream.Collectors;

public class Library implements LibraryImplementation {

    private Map<String, List<Book>> departments;
    private final Validator validator;

    public Library() {
        departments = new HashMap<>();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Override
    public List<Book> listAvailableBooks() {
        return departments.values().stream()
                .flatMap(List::stream)
                .filter(Book::isAvailabilty)
                .toList();
    }

    private Boolean findBookByIsbn(String isbn){
        return departments.values().stream()
                .flatMap(List::stream)
                .filter(book -> book.getISBN().equals(isbn))
                .findAny().isEmpty();
    }

    @Override
    public void saveBook(Book newBook) {

        Set<ConstraintViolation<Book>> violations = validator.validate(newBook);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> violation : violations) {
                System.out.println(violation.getMessage());
            }
            return;
        }

        if(!findBookByIsbn(newBook.getISBN())){
            throw new RuntimeException("Book Already exits in "+newBook.getDepartment());
        }
        String dptm = newBook.getDepartment();
        departments.putIfAbsent(dptm, new ArrayList<>());//creates a new department if not exits
        List<Book> books = departments.get(dptm);
        books.add(newBook);
        departments.put(dptm,books);
        System.out.println("Book successfully saved...");
    }

    @Override
    public boolean removeBook(String ISBN) {
        for (List<Book> books: departments.values()){
            if (books.removeIf(book -> book.getISBN().equals(ISBN))){
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Book> findBookByTitle(String title) {
        return departments.values().stream()
                .flatMap(List::stream)
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return departments.values().stream()
                .flatMap(List::stream)
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    @Override
    public List<Book> listAllBooks() {
        return departments.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
