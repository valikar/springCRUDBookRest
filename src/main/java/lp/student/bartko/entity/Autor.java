package lp.student.bartko.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Transactional
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString(exclude = {"book"})
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            mappedBy = "autor"
    )
    @JsonIgnore
    private List<Book> book;

}
