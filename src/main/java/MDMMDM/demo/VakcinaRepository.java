package MDMMDM.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VakcinaRepository extends CrudRepository<VakcinaEntity, Long> {
    @Override
    List<VakcinaEntity> findAll();

    Optional<VakcinaEntity> findById(Long  VakcinaId);
}