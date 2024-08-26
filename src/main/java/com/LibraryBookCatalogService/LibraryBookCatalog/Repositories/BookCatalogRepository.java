package com.LibraryBookCatalogService.LibraryBookCatalog.Repositories;

import com.LibraryBookCatalogService.LibraryBookCatalog.Models.BookCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCatalogRepository extends JpaRepository<BookCatalog, Long> {
    List<BookCatalog> findByAuthor(String author);
    List<BookCatalog> findByCategory(String category);
}
