package MDMMDM.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OsobaRepository extends CrudRepository<OsobaEntity, Long> {
    @Override
    List<OsobaEntity> findAll();
    Optional<OsobaEntity> findById(Integer osobaId);
}
