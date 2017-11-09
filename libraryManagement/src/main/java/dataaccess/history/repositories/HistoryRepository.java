package dataaccess.history.repositories;

import esipe.dataaccess.history.entities.HistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends CrudRepository<HistoryEntity,Long> {




}
