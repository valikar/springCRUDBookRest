package lp.student.bartko.controllers;

import lp.student.bartko.entity.Autor;
import lp.student.bartko.entity.Book;
import lp.student.bartko.services.AutorService;
import lp.student.bartko.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;
import java.util.Map;

@Transactional
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    BookService bookService;
    @Autowired
    AutorService autorService;

    //-------------------Retrieve All Books--------------------------------------------------------

    @GetMapping("/book")
    public String listAllBooks() {
        List<Book> books = bookService.findAll();
        if (books.isEmpty()) {
            return "There is not any book";
        }
        return books.toString();
    }

    //-------------------Retrieve Single Book--------------------------------------------------------

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") int id) {
        System.out.println("Fetching Book with id " + id);
        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("Book with id " + id + " was  not found");
            return "Book with id " + id + " was not found";
        }
        return book.toString();
    }

    //-------------------Create a Book--------------------------------------------------------

    @PostMapping("/book")
    public String createBook(@RequestBody Map<String, String> params) {
        String name = params.get("name");
        String autorName = params.get("autor");
        System.out.println("Creating Book " + name);
        Autor autor = Autor.builder().name(autorName).build();
        if (autorService.autorIdIfExist(autor) != -1) {
            autor = autorService.findById(autorService.autorIdIfExist(autor));
        } else autorService.Save(autor);
        Book book = Book.builder().autor(autor).name(name).build();
        if (bookService.isBookExist(book)) {
            System.out.println("A Book with name " + book.getName() + " already exist");
            return "This book is already exists";
        }
        bookService.Save(book);
        return "The book was added:" + "\n" + book;
    }
//------------------- Update a Book --------------------------------------------------------

    @PutMapping("/book/{id}")
    public String updateBook(@PathVariable("id") int id, @RequestBody Map<String, String> params) {
        String name = params.get("name");
        String autorName = params.get("autor");
        Book currentBook = bookService.findById(id);
        if (currentBook == null) {
            System.out.println("Book with id " + id + " was not found");
            return "Book with id " + id + " was not found";
        }
        System.out.println("Updating Book " + id);
        Autor autor = Autor.builder().name(autorName).build();
        if (autorService.autorIdIfExist(autor) != -1) {
            autor = autorService.findById(autorService.autorIdIfExist(autor));
        } else autorService.Save(autor);
        currentBook.setName(name);
        currentBook.setAutor(autor);
        bookService.Save(currentBook);
        return "Book was updated: \n" + currentBook;
    }
    //------------------- Delete a book --------------------------------------------------------

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting book with id " + id);
        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("Unable to delete. book with id " + id + " was not found");
            return ("Unable to delete. book with id " + id + " was not found");
        }
        bookService.deleteById(id);
        return ("Book with id " + id + " was deleted");
    }
}

