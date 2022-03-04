package com.example.book_shop;

import com.example.book_shop.models.Author;
import com.example.book_shop.models.Book;
import com.example.book_shop.repositories.AuthorRepository;
import com.example.book_shop.repositories.BookRepository;
import com.example.book_shop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private SeedService seedService;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAll();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a query number to be executed.");
        int queryNumber = Integer.parseInt(scanner.nextLine());

        switch (queryNumber) {
            case 1:
                queryOne();
                break;
            case 2:
                queryTwo();
                break;
            case 3:
                queryThree();
                break;
            case 4:
                queryFour();
                break;
            default:
                System.out.println("Invalid query! Please enter a number between [1-4].");
        }


    }

    private void queryOne() {
        LocalDate after = LocalDate.of(2000, 1, 1);
        List<Book> books = bookRepository.findAllByReleaseDateAfter(after);
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private void queryTwo() {
        LocalDate before = LocalDate.of(1990, 1, 1);
        List<Book> books = bookRepository.findAllByReleaseDateBefore(before);
        Set<Author> authors = new HashSet<>();

        for (Book book : books) {
            Author author = book.getAuthor();
            authors.add(author);
        }

        for (Author author : authors) {
            System.out.printf("%s %s\n", author.getFirstName(), author.getLastName());
        }
    }

    private void queryThree() {
        List<String> authors = authorRepository.findAndOrderByCountOfBooks();
        for (String info : authors) {
            String[] data = info.split(",");
            System.out.println(data[0] + " " + data[1] + " " + data[2]);
        }
    }

    private void queryFour() {
        List<Book> books = authorRepository.findAllBooksByGeorge();
        for (Book book : books) {
            System.out.printf("%s %s %d\n",
                    book.getTitle(),
                    book.getReleaseDate().toString(),
                    book.getCopies());
        }
    }
}
