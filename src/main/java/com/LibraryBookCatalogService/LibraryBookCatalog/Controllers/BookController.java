package com.LibraryBookCatalogService.LibraryBookCatalog.Controllers;

import com.LibraryBookCatalogService.LibraryBookCatalog.Models.BookCatalog;
import com.LibraryBookCatalogService.LibraryBookCatalog.Service.CRUDService;
import com.LibraryBookCatalogService.LibraryBookCatalog.Service.FindBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/books/")
public class BookController {
    @Autowired
    CRUDService crudService;

    @Autowired
    FindBooksService findBooksService;

    //create book
    @PostMapping("/create")
    public ResponseEntity<BookCatalog> createBook(@RequestBody BookCatalog bookCatalog) {
        BookCatalog book = crudService.addBook(bookCatalog);
        return ResponseEntity.ok(book);
    }

    // get book by id
    @GetMapping("/{id}")
    public ResponseEntity<BookCatalog> getBookById(@PathVariable Long id) {
        Optional<BookCatalog> book = crudService.findBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    // update existing book
    @PutMapping("/{id}")
    public ResponseEntity<BookCatalog> updateBook(@PathVariable Long id, @RequestBody BookCatalog bookInfo) {
        BookCatalog updatedBook = crudService.updateBook(id, bookInfo);
        return ResponseEntity.ok(updatedBook);
    }

    // delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        crudService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    // find all books
    @GetMapping
    public  ResponseEntity<List<BookCatalog>> getAllBooks() {
        List<BookCatalog> books = findBooksService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    // find book by author
    @GetMapping("/{author}")
    public ResponseEntity<List<BookCatalog>> findBookById(@PathVariable String author) {
        List<BookCatalog> books = findBooksService.findBookByAuthor(author);
        return ResponseEntity.ok(books);
    }

    // find books by category
    @GetMapping("/{category}")
    public ResponseEntity<List<BookCatalog>> findBookByCategory(@PathVariable String category) {
        List<BookCatalog> books = findBooksService.findBookByCategory(category);
        return ResponseEntity.ok(books);
    }

}
