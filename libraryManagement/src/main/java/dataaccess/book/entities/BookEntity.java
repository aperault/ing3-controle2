package dataaccess.book.entities;

import dataaccess.Exemplaire.ExemplaireEntity;
import esipe.dataaccess.history.entities.HistoryEntity;
import esipe.dataaccess.user.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;


    @Column(name = "category")
    private String category;

    @Column(name = "state")
    private boolean state;

    @OneToMany(mappedBy = "book")
    private List<ExemplaireEntity> exemplaireList;

}
