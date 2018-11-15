package lp.student.bartko.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Book: {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", autor=" + autor.getName() + "}" + '\n';
    }

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL}
    )
    @JsonIgnore
    private Autor autor;

}
