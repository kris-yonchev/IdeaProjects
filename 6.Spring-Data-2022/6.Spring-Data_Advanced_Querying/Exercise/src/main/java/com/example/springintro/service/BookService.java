package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findAllByAgeRestrictionLike(AgeRestriction ageRestriction);

    List<Book> findBookByEditionTypeAndCopiesLessThan(EditionType gold, int i);

    List<Book> findBookByPriceLessThanOrPriceGreaterThan(BigDecimal bigDecimal, BigDecimal bigDecimal1);

    List<Book> findBookByReleaseYearNotIn(Integer year);

    List<Book> findBookByReleaseDateBefore(LocalDate actual);

    List<Book> findBookByTitleContaining(String string);

    List<Book> findBookByAuthorLastNameStartsWith(String string);

    int findBookCountByTitleLength(int length);

    int totalBookCopiesByAuthorDescByCount(String name);

    String findBookInfoByTitle(String title);

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    int saveAll(Iterable<Book> books);

    int deleteBooksByCopiesLessThan(Integer amount);

    int getAuthorBookCount(String authorName);
}
