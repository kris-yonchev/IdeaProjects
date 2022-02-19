package IteratorAndComparator.Library;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

//        List<Book> books = new ArrayList<>();
//        books.add(bookOne);
//        books.add(bookTwo);
//        books.add(bookThree);

        Library<Book> library = new Library<>();
        library.add(bookOne);
        library.add(bookTwo);
        library.add(bookThree);

        List<Book> books = library.getBooks();

        books.stream().sorted(new BookComparator()).forEach(System.out::println);
//
//        for (Book book : library) {
//            System.out.println(book.getTitle());
//        }


    }
}
