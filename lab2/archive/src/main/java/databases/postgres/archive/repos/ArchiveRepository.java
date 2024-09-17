package databases.postgres.archive.repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArchiveRepository extends CrudRepository {

    @Query("")
    String findByName(String name);
}
