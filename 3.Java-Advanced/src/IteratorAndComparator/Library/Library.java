package IteratorAndComparator.Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library<Book> implements Iterable<Book> {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public int size() {
        return this.books.size();
    }

    public Book get(int index) {
        return this.books.get(index);
    }

    public List<Book> getBooks() {
        return books;
    }

    private final class LibIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < books.size();
        }

        @Override
        public Book next() {
            Book next = books.get(counter);
            counter++;
            return next;
        }
    }


    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

}
