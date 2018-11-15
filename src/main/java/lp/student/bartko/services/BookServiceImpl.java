package lp.student.bartko.services;

import lp.student.bartko.dao.BookDAO;
import lp.student.bartko.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;

    public void Save(Book book) {
        bookDAO.save(book);
    }

    public Book findById(int id) {
        return bookDAO.findOne(id);
    }

    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    public void deleteById(int id) {
        bookDAO.delete(id);
    }

    public boolean isBookExist(Book book) {
        List<Book> books = bookDAO.findAll();
        for (Book booker : books) {
            if ((book.getName().equals(booker.getName())) && (book.getAutor().equals(booker.getAutor()))) {
                return true;
            }

        }
        return false;
    }


}
