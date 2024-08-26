package com.LibraryBookCatalogService.LibraryBookCatalog.Service;

import com.LibraryBookCatalogService.LibraryBookCatalog.Models.BookCatalog;
import com.LibraryBookCatalogService.LibraryBookCatalog.Repositories.BookCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindBooksService {
    @Autowired
    BookCatalogRepository bookCatalogRepository;

    // find all books
    public List<BookCatalog> findAllBooks() {
        return bookCatalogRepository.findAll();
    }

    // find book by author
    public List<BookCatalog> findBookByAuthor(String author) {
        return bookCatalogRepository.findByAuthor(author);
    }

    // find book by category
    public List<BookCatalog> findBookByCategory(String category) {
        return bookCatalogRepository.findByCategory(category);
    }


}
