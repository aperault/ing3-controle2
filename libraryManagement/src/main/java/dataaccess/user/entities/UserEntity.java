package esipe.dataaccess.user.entities;

import dataaccess.Exemplaire.ExemplaireEntity;
import dataaccess.history.entities.HistoryEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;


	@OneToMany(mappedBy = "user")
	private List<ExemplaireEntity> exemplaireList;

	@OneToMany(mappedBy = "user")
	private List<HistoryEntity> historyList;

}