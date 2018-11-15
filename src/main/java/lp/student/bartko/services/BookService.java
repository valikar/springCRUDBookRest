package lp.student.bartko.services;


import lp.student.bartko.entity.Book;

import java.util.List;

public interface BookService {
    void Save(Book book);

    Book findById(int id);

    List<Book> findAll();

    void deleteById(int id);

    boolean isBookExist(Book book);
}
