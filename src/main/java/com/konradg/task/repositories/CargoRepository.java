package com.konradg.task.repositories;

import com.konradg.task.models.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo,Long> {
}
