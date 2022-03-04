package com.example.book_shop.services;

import com.example.book_shop.models.Author;
import com.example.book_shop.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    Random random = new Random();

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {
        long count = this.authorRepository.count();
        int author = random.nextInt((int) count) + 1;
        return this.authorRepository.getById(author);
    }
}
