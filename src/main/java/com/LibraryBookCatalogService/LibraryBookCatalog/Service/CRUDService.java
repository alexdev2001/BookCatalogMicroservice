package com.LibraryBookCatalogService.LibraryBookCatalog.Service;

import com.LibraryBookCatalogService.LibraryBookCatalog.Models.BookCatalog;
import com.LibraryBookCatalogService.LibraryBookCatalog.Repositories.BookCatalogRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CRUDService {
    @Autowired
    BookCatalogRepository bookCatalogRepository;

    // create new book
    public BookCatalog addBook(BookCatalog bookCatalog) {
        return bookCatalogRepository.save(bookCatalog);
    }

    // retrieve book by id
    public Optional<BookCatalog> findBookById(Long id) {
        return bookCatalogRepository.findById(id);
    }

    // update existing book
    public BookCatalog updateBook(Long id, BookCatalog bookDetails) {
        BookCatalog book = bookCatalogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("oould not find book" + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublisher(bookDetails.getPublisher());
        book.setPublishedDate(bookDetails.getPublishedDate());
        book.setCategory(bookDetails.getCategory());
        book.setTotal_copies(bookDetails.getTotal_copies());
        book.setAvailable_copies(bookDetails.getAvailable_copies());

        return bookCatalogRepository.save(book);
    }

    // delete book by id
    public void deleteBookById(Long id) {
        BookCatalog book = bookCatalogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("could not find book" + id));
        bookCatalogRepository.delete(book);
    }
}
