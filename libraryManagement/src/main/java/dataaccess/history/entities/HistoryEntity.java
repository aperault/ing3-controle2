package dataaccess.history.entities;


import dataaccess.Exemplaire.ExemplaireEntity;
import dataaccess.book.entities.BookEntity;
import dataaccess.user.entities.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "history")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "dateEmprunt")
    private Timestamp date = new Timestamp(System.currentTimeMillis());

    @Column(name = "dateRetour")
    private Timestamp date ;

    @ManyToOne
    private ExemplaireEntity exemplaire;

    @ManyToOne
    private UserEntity user;





}
