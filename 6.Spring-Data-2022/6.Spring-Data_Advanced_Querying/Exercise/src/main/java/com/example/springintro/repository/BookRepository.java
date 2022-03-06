package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestrictionLike(AgeRestriction ageRestriction);

    List<Book> findBookByEditionTypeAndCopiesLessThan(EditionType gold, int i);

    List<Book> findBookByPriceLessThanOrPriceGreaterThan(BigDecimal bigDecimal, BigDecimal bigDecimal1);

    @Query("SELECT b FROM Book b" +
            " WHERE YEAR(b.releaseDate) NOT IN :year")
    List<Book> findBookByReleaseYearNotIn(Integer year);

    List<Book> findBookByReleaseDateBefore(LocalDate actual);

    List<Book> findBookByTitleContaining(String string);

    List<Book> findBookByAuthorLastNameStartsWith(String string);

    @Query("SELECT COUNT(b.title) FROM Book b" +
            " WHERE LENGTH(b.title) > :length")
    int findBookCountByTitleLength(int length);

    @Query("SELECT SUM(b.copies) FROM Book b" +
            " WHERE CONCAT(b.author.firstName,' ', b.author.lastName) = :name" +
            " GROUP BY b.author.id")
    int totalBookCopiesByAuthorDescByCount(String name);

    @Query("SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book b" +
            " WHERE b.title = :title")
    String findBookInfoByTitle(String title);

    @Modifying
    int deleteByCopiesLessThan(Integer amount);
}

