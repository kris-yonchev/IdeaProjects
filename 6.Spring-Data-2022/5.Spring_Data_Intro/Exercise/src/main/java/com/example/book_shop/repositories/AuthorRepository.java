package com.example.book_shop.repositories;

import com.example.book_shop.models.Author;
import com.example.book_shop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


    @Query(value = "SELECT a.firstName, a.lastName, COUNT(b.id) AS book_count FROM Author a\n" +
            "JOIN Book b ON a.id = b.author.id\n" +
            "GROUP BY a.id\n" +
            "ORDER BY book_count DESC\n")
    List<String> findAndOrderByCountOfBooks();

    @Query(value = "SELECT b FROM Book b" +
            " JOIN Author a ON a.id = b.author.id" +
            " WHERE CONCAT(a.firstName, ' ', a.lastName) = 'George Powell'" +
            " ORDER BY b.releaseDate DESC, b.title")
    List<Book> findAllBooksByGeorge();
}
