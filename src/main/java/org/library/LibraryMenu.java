package org.library;

import org.library.dto.Book;
import org.library.service.Library;
import org.library.service.LibraryImplementation;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {

    private final LibraryImplementation library;
    private final Scanner scanner;

    public LibraryMenu() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void diplayMenu(){

        while (true){
            System.out.println("\nLibrary Menu:");
            System.out.println("1. add book");
            System.out.println("2. remove book");
            System.out.println("3. Find Book by title");
            System.out.println("4. Find Book by author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. exit");
            System.out.println("Choose an option......");
            try {
                int choose=scanner.nextInt();
                scanner.nextLine();
                boolean flag = true;
                List<Book> books;
                switch (choose){
                    case 1://addBook
                        library.saveBook(addBook());
                        break;
                    case 2://removeBook
                        System.out.println("Enter ISBN number...");
                        String isbn = scanner.nextLine();
                        if(library.removeBook(isbn)){
                            System.out.println("Book removed....");
                        }else{
                            System.out.println("Book is not found...");
                        }
                        break;
                    case 3://find book by title
                        System.out.println("Enter title...");
                        String title = scanner.nextLine();
                        books = library.findBookByTitle(title);
                        printBooks(books);
                        break;
                    case 4://find book by author
                        System.out.println("Enter author...");
                        String author = scanner.nextLine();
                        books = library.findBookByAuthor(author);
                        printBooks(books);
                        break;
                    case 5://list all books
                        books = library.listAllBooks();
                        printBooks(books);
                        break;
                    case 6:
                        books = library.listAvailableBooks();
                        printBooks(books);
                        break;
                    case 7:
                        System.out.println("Thank you!....");
                        flag =false;
                        break;
                    default:
                        System.out.println("Invalid choice ... Try again.. ");
                }

                if (!flag){
                    break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }

    }

    public void printBooks(List<Book> books){
        for (Book book:books){
            System.out.println(book);
        }
    }

    public Book addBook(){
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.println("Is the book available? (true/false): ");
        boolean availability = scanner.nextBoolean();
        scanner.nextLine();

        return new Book(title,author,isbn,genre,year,availability,department);

    }

    public static void main(String[] args) {

            LibraryMenu libraryMenu = new LibraryMenu();
            libraryMenu.diplayMenu();

    }
}