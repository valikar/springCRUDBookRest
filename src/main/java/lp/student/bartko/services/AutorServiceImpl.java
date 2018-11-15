package lp.student.bartko.services;


import lp.student.bartko.dao.AutorDAO;
import lp.student.bartko.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class AutorServiceImpl implements AutorService {
    @Autowired
    AutorDAO autorDAO;

    public void Save(Autor autor) {
        autorDAO.save(autor);
    }

    public Autor findById(int id) {
        return autorDAO.findOne(id);
    }

    public List<Autor> findAll() {
        return autorDAO.findAll();
    }

    public void deleteById(int id) {
        autorDAO.delete(id);
    }

    public int autorIdIfExist(Autor autor) {
        List<Autor> autors = autorDAO.findAll();
        for (Autor autores : autors) {
            if (autor.getName().equals(autores.getName())) {
                return autores.getId();
            }

        }
        return -1;
    }

}
