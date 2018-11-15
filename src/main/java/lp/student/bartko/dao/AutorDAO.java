package lp.student.bartko.dao;

import lp.student.bartko.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutorDAO extends JpaRepository<Autor, Integer> {

}
