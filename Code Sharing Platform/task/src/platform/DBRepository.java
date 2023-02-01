package platform;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public interface DBRepository extends CrudRepository<Code, Long> {
}
