import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.library.dto.Book;
import org.library.service.Library;
import org.library.service.LibraryImplementation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryMenuTest {

    private LibraryImplementation library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void setUp(){
        book1 = new Book("Java","Praveen","1",
                "programming",1998,true,"Computer Science");
        book2 = new Book("C++","Mahesh","2",
                "programming",2001,false,"Computer Science");
        book3 = new Book("Kalki 2898AD","Nag aswin","3",
                    "Mythology",2024,true,"Movie");

        library = new Library();

    }

    @Test
    public void testSaveBookAndDuplicateBooksException(){
        library.saveBook(book1);
        library.saveBook(book2);
        Book bookWithSameISBNNumber = new Book("same isbn","rakesh","2",
                "test",2024,true,"Testing Department");
        try {
            library.saveBook(bookWithSameISBNNumber);
        }catch (Exception e){
            assertEquals("Book Already exits in "+bookWithSameISBNNumber.getDepartment(),e.getMessage());
        }

        assertEquals(2,library.listAllBooks().size());

    }

    @Test
    public void testRemoveBook(){
        library.saveBook(book1);
        library.saveBook(book2);
        library.saveBook(book3);

        library.removeBook("2");

        assertEquals(library.listAllBooks().size(),2);
    }

    @Test
    public void  testFindBookByTitle(){
        library.saveBook(book1);
        library.saveBook(book2);
        library.saveBook(book3);

        List<Book> bookLibrary = library.findBookByTitle("java");
        assertEquals(1,bookLibrary.size());
        assertEquals("Java",bookLibrary.get(0).getTitle());
    }

    @Test
    public void  testFindBookByAuthor(){
        library.saveBook(book1);
        library.saveBook(book2);
        library.saveBook(book3);

        List<Book> bookLibrary = library.findBookByAuthor("praveen");
        assertEquals(1,bookLibrary.size());
        assertEquals("Praveen",bookLibrary.get(0).getAuthor());
    }

    @Test
    public void testListofAllBooks(){
        library.saveBook(book1);
        library.saveBook(book2);
        library.saveBook(book3);

        List<Book> bookLibrary = library.listAllBooks();

        assertEquals(3,bookLibrary.size());
    }

    @Test
    public void ListAvailableBooks(){
        library.saveBook(book1);
        library.saveBook(book2);//Not available
        library.saveBook(book3);

        List<Book> books = library.listAvailableBooks();

        assertEquals(books.size(),2);
        assertEquals("Kalki 2898AD",books.get(0).getTitle());

    }

}
