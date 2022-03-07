package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllByAgeRestrictionLike(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestrictionLike(ageRestriction);
    }

    @Override
    public List<Book> findBookByEditionTypeAndCopiesLessThan(EditionType gold, int i) {
        return this.bookRepository.findBookByEditionTypeAndCopiesLessThan(gold, i);
    }

    @Override
    public List<Book> findBookByPriceLessThanOrPriceGreaterThan(BigDecimal bigDecimal, BigDecimal bigDecimal1) {
        return this.bookRepository.findBookByPriceLessThanOrPriceGreaterThan(bigDecimal, bigDecimal1);
    }

    @Override
    public List<Book> findBookByReleaseYearNotIn(Integer year) {
        return this.bookRepository.findBookByReleaseYearNotIn(year);
    }

    @Override
    public List<Book> findBookByReleaseDateBefore(LocalDate actual) {
        return bookRepository.findBookByReleaseDateBefore(actual);
    }

    @Override
    public List<Book> findBookByTitleContaining(String string) {
        return bookRepository.findBookByTitleContaining(string);
    }

    @Override
    public List<Book> findBookByAuthorLastNameStartsWith(String string) {
        return this.bookRepository.findBookByAuthorLastNameStartsWith(string);
    }

    @Override
    public int findBookCountByTitleLength(int length) {
        return bookRepository.findBookCountByTitleLength(length);
    }

    @Override
    public int totalBookCopiesByAuthorDescByCount(String name) {
        return bookRepository.totalBookCopiesByAuthorDescByCount(name);
    }

    @Override
    public String findBookInfoByTitle(String title) {
        return bookRepository.findBookInfoByTitle(title);
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate date) {
        return bookRepository.findAllByReleaseDateAfter(date);
    }

    @Override
    public int saveAll(Iterable<Book> books) {
        return bookRepository.saveAll(books).size();
    }

    @Override
    @Transactional
    public int deleteBooksByCopiesLessThan(Integer amount) {
        return bookRepository.deleteByCopiesLessThan(amount);
    }

    @Override
    public int getAuthorBookCount(String authorName) {
        return bookRepository.getAuthorBookCount(authorName);
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
