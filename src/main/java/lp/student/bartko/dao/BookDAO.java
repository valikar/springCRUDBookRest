package lp.student.bartko.dao;

import lp.student.bartko.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookDAO extends JpaRepository<Book, Integer> {
}
