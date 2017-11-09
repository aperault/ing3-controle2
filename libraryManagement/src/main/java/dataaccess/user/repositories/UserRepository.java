package esipe.dataaccess.user.repositories;

import esipe.dataaccess.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	List<UserEntity> findAll();

	UserEntity getUserByLastName(String lastName);
}
