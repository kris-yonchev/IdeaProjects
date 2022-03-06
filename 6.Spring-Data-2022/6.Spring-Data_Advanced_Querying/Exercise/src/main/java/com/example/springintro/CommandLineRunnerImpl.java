package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Enter exercise number to test[1-13]: ");
        int problemNumber = Integer.parseInt(scanner.nextLine());
        switch (problemNumber) {
            case 1:
                problem1();
                break;
            case 2:
                problem2();
                break;
            case 3:
                problem3();
                break;
            case 4:
                problem4();
                break;
            case 5:
                problem5();
                break;
            case 6:
                problem6();
                break;
            case 7:
                problem7();
                break;
            case 8:
                problem8();
                break;
            case 9:
                problem9();
                break;
            case 10:
                problem10();
                break;
            case 11:
                problem11();
                break;
            case 12:
                problem12();
                break;
            case 13:
                problem13();
                break;
            default:
                System.out.println("Invalid exercise number!");
                break;
        }

    }

    private void problem13() {
        System.out.println("Enter copies amount to delete by: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println(bookService.deleteBooksByCopiesLessThan(amount));
    }

    private void problem12() {
        System.out.println("Enter date: ");
        String stringDate = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate date = LocalDate.parse(stringDate, dtf);
        System.out.println("Enter amount to increase book copies by: ");
        int amount = Integer.parseInt(scanner.nextLine());
        List<Book> books = bookService.findAllByReleaseDateAfter(date);
        books.forEach(b -> b.setCopies(b.getCopies() + amount));
        bookService.saveAll(books);
        System.out.println(books.size() * amount);
    }

    private void problem11() {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();
        String bookInfo = bookService.findBookInfoByTitle(title);
        System.out.println(bookInfo.replaceAll(",", " "));
    }

    private void problem10() {
        System.out.println("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.println(bookService.totalBookCopiesByAuthorDescByCount(authorName));
    }

    private void problem9() {
        System.out.println("Enter title length: ");
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(bookService.findBookCountByTitleLength(length));
    }

    private void problem8() {
        System.out.println("Enter string: ");
        String string = scanner.nextLine();
        bookService.findBookByAuthorLastNameStartsWith(string)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void problem7() {
        System.out.println("Enter string: ");
        String string = scanner.nextLine();
        bookService.findBookByTitleContaining(string)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void problem6() {
        System.out.println("Enter a suffix: ");
        String suffix = scanner.nextLine();
        authorService.findAuthorByFirstNameEndsWith(suffix)
                .forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void problem5() {
        System.out.println("Enter date: ");
        String[] dateInfo = scanner.nextLine().split("-");
        LocalDate actual = LocalDate.of(Integer.parseInt(dateInfo[2]),
                Integer.parseInt(dateInfo[1]),
                Integer.parseInt(dateInfo[0]));
        bookService.findBookByReleaseDateBefore(actual)
                .forEach(b -> System.out.printf("%s %s %s\n", b.getTitle(), b.getEditionType().name(), b.getPrice()));
    }

    private void problem4() {
        System.out.println("Enter year to sort by: ");
        Integer year = Integer.parseInt(scanner.nextLine());
        bookService.findBookByReleaseYearNotIn(year).forEach(b -> System.out.println(b.getTitle()));
    }

    private void problem3() {
        bookService.findBookByPriceLessThanOrPriceGreaterThan(new BigDecimal(5), new BigDecimal(40))
                .forEach(b -> System.out.printf("%s - $%s\n", b.getTitle(), b.getPrice()));
    }

    private void problem2() {
        bookService.findBookByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void problem1() {
        System.out.println("Enter age restriction[minor, teen, adult].");
        AgeRestriction restriction = AgeRestriction.valueOf(scanner.nextLine().toUpperCase());
        this.bookService.findAllByAgeRestrictionLike(restriction)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
