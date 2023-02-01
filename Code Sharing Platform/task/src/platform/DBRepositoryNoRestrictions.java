package platform;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DBRepositoryNoRestrictions extends CrudRepository<Code, Long> {
}
