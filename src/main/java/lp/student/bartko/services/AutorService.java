package lp.student.bartko.services;


import lp.student.bartko.entity.Autor;

import java.util.List;

public interface AutorService {
    void Save(Autor autor);

    Autor findById(int id);

    List<Autor> findAll();

    void deleteById(int id);

    int autorIdIfExist(Autor autor);
}
