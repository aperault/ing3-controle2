package dataaccess.Exemplaire;

import dataaccess.book.entities.BookEntity;
import dataaccess.history.entities.HistoryEntity;

import javax.persistence.*;
import java.util.List;

public class ExemplaireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private esipe.dataaccess.user.entities.UserEntity user;

    @ManyToOne
    private BookEntity book;

    @OneToMany(mappedBy = "exemplaire")
    private List<HistoryEntity> historyEntityList;
}
